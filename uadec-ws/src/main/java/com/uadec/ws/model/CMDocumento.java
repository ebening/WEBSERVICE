package com.uadec.ws.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.uadec.core.cm.BaseDocumentoCm;
import com.uadec.core.cm.FileCm;
import com.uadec.core.cm.GroupAtributoCm;
import com.uadec.core.util.PropertyUtil;
import com.uadec.entity.model.CatDocumentos;
import com.uadec.entity.model.DocumentoImportado;
import com.uadec.entity.model.Solicitud;
import com.uadec.entity.model.Usuario;
import com.uadec.ws.util.ConstantesWs;

/**
 * @author adinfi
 *
 */
public class CMDocumento extends BaseDocumentoCm implements Serializable {

	private static final long serialVersionUID = 9143580773269827713L;
	private final static Logger log = Logger.getLogger(CMDocumento.class);

	private Solicitud solicitud;
	private DocumentoImportado documentoImportado;
	private CatDocumentos catDocumentos;

	public CMDocumento(String url, FileCm file, Solicitud solicitud, Usuario usuario,
			DocumentoImportado documentoImportado, CatDocumentos catDocumentos) {
		super(url, file);
		setSolicitud(solicitud);
		setDocumentoImportado(documentoImportado);
		setCatDocumentos(catDocumentos);
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public DocumentoImportado getDocumentoImportado() {
		return documentoImportado;
	}

	public void setDocumentoImportado(DocumentoImportado documentoImportado) {
		this.documentoImportado = documentoImportado;
	}

	public CatDocumentos getCatDocumentos() {
		return catDocumentos;
	}

	public void setCatDocumentos(CatDocumentos catDocumentos) {
		this.catDocumentos = catDocumentos;
	}

	@Override
	public void mapAttributesValues(Map<String, Object> attributesValues, List<GroupAtributoCm> groupAttributesValues) {
		attributesValues.put("UAC_ID_SOL", getSolicitud().getIdSolicitud());
		attributesValues.put("UAC_CICLO", getSolicitud().getCiclo());
		attributesValues.put("UAC_CUENTA_PAGAR", getSolicitud().getCuentaPagar());
		attributesValues.put("UAC_USUARIO",
				getDocumentoImportado().getUsuario().getNombre() + " "
						+ getDocumentoImportado().getUsuario().getApellidoMaterno() + " "
						+ getDocumentoImportado().getUsuario().getApellidoMaterno());
		attributesValues.put("UAC_NOMBREDOC", getDocumentoImportado().getNombredoc());
		attributesValues.put("UAC_TIPODOC", getCatDocumentos().getDescripcion());
	}

	@Override
	public String getValueSearch() {
		return solicitud.getIdSolicitud().toString();
	}

	@Override
	public String getModel() {
		return PropertyUtil.getProperty(ConstantesWs.UAC_DOCUMENT_KEY_MODEL);
	}

	@Override
	public String getKeySearch() {
		return ConstantesWs.UAC_DOCUMENT_KEY_SEARCH;
	}
}
