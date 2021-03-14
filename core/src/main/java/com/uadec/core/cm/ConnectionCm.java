package com.uadec.core.cm;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ibm.mm.sdk.common.DKAttrDefICM;
import com.ibm.mm.sdk.common.DKConstant;
import com.ibm.mm.sdk.common.DKConstantICM;
import com.ibm.mm.sdk.common.DKDDO;
import com.ibm.mm.sdk.common.DKException;
import com.ibm.mm.sdk.common.DKNVPair;
import com.ibm.mm.sdk.common.DKParts;
import com.ibm.mm.sdk.common.DKRetrieveOptionsICM;
import com.ibm.mm.sdk.common.DKSequentialCollection;
import com.ibm.mm.sdk.common.DKTextICM;
import com.ibm.mm.sdk.common.DKUsageError;
import com.ibm.mm.sdk.common.dkIterator;
import com.ibm.mm.sdk.common.dkResultSetCursor;
import com.ibm.mm.sdk.server.DKDatastoreICM;
import com.uadec.core.util.MimeType;
import com.uadec.core.util.PropertyUtil;

public class ConnectionCm {
	private String library;
	private String serverFile;
	private String username;
	private String password;
	private String schema;

	private DKDatastoreICM dsIcm;
	private final static Logger log = Logger.getLogger(ConnectionCm.class);

	private ConnectionCm() {

		library = PropertyUtil.getProperty("icm.library");
		serverFile = PropertyUtil.getProperty("icm.server.file");
		username = PropertyUtil.getProperty("icm.admin");
		password = PropertyUtil.getProperty("icm.password");
		schema = PropertyUtil.getProperty("icm.schema");
//		String pathServerFile = getClass().getClassLoader().getResource("/cmbicmsrvs.ini").getPath();
//		serverFile = serverFile.replace("{0}", pathServerFile);
		connect();
	}

	public static ConnectionCm getInstance() {
		return new ConnectionCm();
	}

	public Boolean connect() {
		if (dsIcm != null && dsIcm.isConnected()) {
			return true;
		}
		try {
			dsIcm = new DKDatastoreICM(getServerFile());
			dsIcm.connect(getLibrary(), getUsername(), getPassword(), getSchema());
		} catch (Exception e) {
			log.error(e);
			return false;
		}

		return true;
	}

	public void disconect() {
		try {
			if (dsIcm != null && dsIcm.isConnected()) {
				dsIcm.disconnect();
				dsIcm.destroy();
			}
		} catch (DKException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public String uploadDocument(BaseModelCm doc) {
		if (!existsElement(doc)) {
			// doc.setAtributos(getAtributosByModel(doc.getModel()));
			// doc.setValues(doc.getAtributos());
			DKDDO ddoDocument;
			try {
				ddoDocument = dsIcm.createDDO(doc.getModel(), doc.getType());
				doc.setValuesAttributes(dsIcm,getAtributosByModel(doc.getModel()), ddoDocument);
				// fillDocumentAttrs(doc, ddoDocument);
				if (doc.getType() == DKConstant.DK_CM_DOCUMENT) {
					fillParts(ddoDocument, (BaseDocumentoCm) doc);
				}
				ddoDocument.add();
				doc.setPid(ddoDocument.getPidObject().pidString());
			} catch (DKException e) {
				log.error(e);
			} catch (Exception e) {
				log.error(e);
			}
		} else {
			log.info(" Ya existe el documento ");
		}
		return doc.getPid();
	}

	private void fillDocumentAttrs(BaseModelCm doc, DKDDO ddoDocument) {
		// Map<String, AtributoCm> atributos =
		// getAtributosByModel(doc.getModel());
		Map<String, AtributoCm> atributos = new HashMap<String, AtributoCm>();

//		doc.loadValues();
		for (AtributoCm attr : atributos.values()) {
			String attrName = attr.getName();
			Short attrType = attr.getTipo();
			Object attrValue = attr.getValor();

			try {
				if (attrValue != null) {
					if (attrType.equals(DKConstant.DK_DATE)) {
						if (attr.getValor() != "null") {
							ddoDocument.setData(ddoDocument.dataId(DKConstant.DK_CM_NAMESPACE_ATTR, attrName),
									new java.sql.Date(((Date) attrValue).getTime()));
						}
					} else if (attrType.equals(DKConstant.DK_LONG)) {
						ddoDocument.setData(ddoDocument.dataId(DKConstant.DK_CM_NAMESPACE_ATTR, attrName),
								(Integer) attrValue);
					} else if (attrType.equals(DKConstant.DK_DECIMAL)) {
						ddoDocument.setData(ddoDocument.dataId(DKConstant.DK_CM_NAMESPACE_ATTR, attrName),
								(BigDecimal) attrValue);
					} else if (attrType.equals(DKConstant.DK_FSTRING) || attrType.equals(DKConstant.DK_VSTRING)) {
						ddoDocument.setData(ddoDocument.dataId(DKConstant.DK_CM_NAMESPACE_ATTR, attrName), attrValue);
					} else {
						throw new Exception("No se ha identificado el tipo de dato para el atributo " + attrName);
					}
				}
			} catch (DKUsageError ex) {
				log.error(ex);
			} catch (Exception ex) {
				log.error(ex);
			}
		}
	}

	private void fillParts(DKDDO ddoDocument, BaseDocumentoCm doc) {
		try {
			DKTextICM base = (DKTextICM) dsIcm.createDDO("ICMBASETEXT", DKConstantICM.DK_ICM_SEMANTIC_TYPE_BASE);
			base.setFormat("");
			base.setLanguageCode("");
			
			DKParts dkParts = (DKParts) ddoDocument
					.getData(ddoDocument.dataId(DKConstant.DK_CM_NAMESPACE_ATTR, DKConstant.DK_CM_DKPARTS));
			if (doc.getUrl() != null && !doc.getUrl().isEmpty()) {
				base.setMimeType(MimeType.getMimeTypeByUrl(doc.getUrl()));
				base.setContentFromClientFile(doc.getUrl());
			}else if(doc.getFile()!=null && doc.getFile().getBytes().length>0){
				base.setMimeType(MimeType.getMimeTypeByUrl(doc.getFile().getName()));
				base.setContent(doc.getFile().getBytes());
			}else{
				throw new RuntimeException("El documento requiere un archivo y no fue encontrado ni por url ni por bytes");
			}
			dkParts.addElement(base);

		} catch (Exception ex) {
			log.info(ex);
		}
	}

	public boolean existsElement(BaseModelCm doc) {
		boolean exists = false;
		dkResultSetCursor cursor = null;
		try {

			StringBuilder query = new StringBuilder("/").append(doc.getModel()).append("[@").append(doc.getKeySearch())
					.append("=\"").append(doc.getValueSearch()).append("\"]");
			DKRetrieveOptionsICM dkRetrieveOptions = DKRetrieveOptionsICM.createInstance(dsIcm);
			dkRetrieveOptions.baseAttributes(true);
			log.info(query.toString());

			DKNVPair options[] = new DKNVPair[3];
			options[0] = new DKNVPair(DKConstant.DK_CM_PARM_MAX_RESULTS, "1");
			options[1] = new DKNVPair(DKConstant.DK_CM_PARM_RETRIEVE, dkRetrieveOptions);
			options[2] = new DKNVPair(DKConstant.DK_CM_PARM_END, null);
			cursor = dsIcm.execute(query.toString(), DKConstantICM.DK_CM_XQPE_QL_TYPE, options);
			exists = cursor.fetchNext() != null;
		} catch (Exception ex) {
			log.error(ex);
		} finally {
			if (cursor != null) {
				try {
					cursor.destroy();
				} catch (Exception ex) {
					log.error(ex);
				}
			}
		}
		return exists;
	}

	public List<AtributoCm> getAtributosByModel(String model) {
		List<AtributoCm> atributos = new ArrayList<AtributoCm>();
		if (connect()) {
			DKSequentialCollection attrColl;
			try {
				attrColl = (DKSequentialCollection) dsIcm.listEntityAttrs(model);
				if (attrColl != null) {
					dkIterator iter = attrColl.createIterator();

					while (iter.more()) {
						DKAttrDefICM attr = (DKAttrDefICM) iter.next();
						AtributoCm atributo = new AtributoCm();
						atributo.setName(attr.getName());
						atributo.setDescription(attr.getDescription());
						atributo.setTipo(attr.getType());
						atributo.setClazz(getClassType(attr.getType()));
						atributo.setLonguitud(attr.getMax());
						atributo.setRequerido(!attr.isNullable());
						atributo.setRepresentativo(attr.isRepresentative());
						atributos.add(atributo);
					}
				}
			} catch (DKException e) {
				log.error(e);
			} catch (Exception e) {
				log.error(e);
			}

		} else {
			log.info("No fue posible conectarse al CM");
		}

		return atributos;
	}

	public static Class<?> getClassType(short type) {
		Class<?> clazz;
		switch (type) {
		case DKConstant.DK_CM_DATE:
			clazz = Date.class;
			break;
		case DKConstant.DK_CM_DECIMAL:
			clazz = BigDecimal.class;
			break;
		case DKConstant.DK_CM_DOUBLE:
			clazz = Double.class;
			break;
		case DKConstant.DK_CM_INTEGER:
			clazz = Integer.class;
			break;
		case DKConstant.DK_CM_SHORT:
			clazz = Short.class;
			break;
		case DKConstant.DK_CM_TIMESTAMP:
			clazz = Timestamp.class;
			break;
		case DKConstant.DK_CM_TIME:
			clazz = Time.class;
			break;
		default:
			clazz = String.class;
		}
		return clazz;
	}

	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServerFile() {
		return serverFile;
	}

	public void setServerFile(String serverFile) {
		String pathServerFile = getClass().getClassLoader().getResource("/cmbicmsrvs.ini").getPath();
		setServerFile(String.format(serverFile, pathServerFile));
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

}
