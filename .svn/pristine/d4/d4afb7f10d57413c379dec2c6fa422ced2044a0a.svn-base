/**
 * 
 */
package com.uadec.ws.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.uadec.core.cm.AtributoCm;
import com.uadec.core.cm.BaseFolderCm;
import com.uadec.core.cm.GroupAtributoCm;
import com.uadec.core.util.PropertyUtil;
import com.uadec.entity.model.Solicitud;
import com.uadec.ws.util.ConstantesWs;

/**
 * @author adinfi
 *
 */
public class CMExpediente extends BaseFolderCm implements Serializable {

	private static final long serialVersionUID = 9143580773269827713L;
	private final static Logger log = Logger.getLogger(CMExpediente.class);

	private DataContent content;

	public CMExpediente(DataContent instance) {
		setModel(instance);
	}

	public DataContent getContent() {
		return content;
	}

	public void setModel(DataContent content) {
		this.content = content;
	}

	@Override
	public void mapAttributesValues(Map<String, Object> attributesValues, List<GroupAtributoCm> groupAttributesValues) {
		Solicitud solicitud = getContent().getSolicitud();
		attributesValues.put("UAC_ID_SOL", solicitud.getIdSolicitud());
		attributesValues.put("UAC_CICLO", solicitud.getCiclo());
		attributesValues.put("UAC_CUENTA_PAGAR", solicitud.getCuentaPagar());
		// attributesValues.put("UAC_FECHA_SOL",new
		// java.sql.Date(solicitud.getFechaSolicitud().getTime()));
		attributesValues.put("UAC_FECHA_SOL", solicitud.getFechaSolicitud());
		attributesValues.put("UAC_FONDO", solicitud.getFondo());
		attributesValues.put("UAC_NCBANCARIA", solicitud.getNCbancaria());
		attributesValues.put("UAC_UNID_ORG", solicitud.getUnidadOrg());
		attributesValues.put("UAC_IMPORTE", solicitud.getImporte().toString());
		attributesValues.put("UAC_AUTORIZADOR", solicitud.getAutorizador());
		attributesValues.put("UAC_ELABORADOR", solicitud.getElaborador());
		attributesValues.put("UAC_CONTRATO", solicitud.getContrato());
		attributesValues.put("UAC_RFC_PROVEEDOR", solicitud.getRfcProveedor());
		attributesValues.put("UAC_CHEQUE", solicitud.getCheque());
		attributesValues.put("UAC_FOLIO_V", solicitud.getFolioVentanilla());
		attributesValues.put("UAC_FOLIO_S", solicitud.getFolioSdr());
		attributesValues.put("UAC_N_COMPROMISO", solicitud.getNCompromiso());
		attributesValues.put("UAC_C_BENEFICIARIO", solicitud.getClaveBeneficiario());
		attributesValues.put("UAC_T_TRAMITE", solicitud.getCatTipoTramite().getDescripcion());
		// attributesValues.put("UAC_CUENTA",getCatCuentas().getDescripcion());
		// attributesValues.put("UAC_SCUENTA",getCatCuentas().getDescripcion());
		// attributesValues.put("UAC_SSCUENTA",getCatCuentas().getDescripcion());
		
		List<AtributoCm> attributes;
		
		String[] values = getContent().getCatCuenta().getDescripcion().split(",");
		GroupAtributoCm group = new GroupAtributoCm("CUENTA",new ArrayList<List<AtributoCm>>());
		groupAttributesValues.add(group);
		for(String value : values){
			attributes = new ArrayList<AtributoCm>();
			attributes.add(new AtributoCm("UAC_CUENTA",value));
			group.getListAttributesValues().add(attributes);
		}
		
		values = getContent().getCatSubCuenta().getDescripcion().split(",");
		group = new GroupAtributoCm("SCUENTA",new ArrayList<List<AtributoCm>>());
		groupAttributesValues.add(group);
		for(String value : values){
			attributes = new ArrayList<AtributoCm>();
			attributes.add(new AtributoCm("UAC_SCUENTA",value));
			group.getListAttributesValues().add(attributes);
		}
		
		values = getContent().getCatSubSubCuenta().getDescripcion().split(",");
		group = new GroupAtributoCm("SSCUENTA",new ArrayList<List<AtributoCm>>());
		groupAttributesValues.add(group);
		for(String value : values){
			attributes = new ArrayList<AtributoCm>();
			attributes.add(new AtributoCm("UAC_SSCUENTA",value));
			group.getListAttributesValues().add(attributes);
		}
	}

	@Override
	public String getValueSearch() {
		return getContent().getSolicitud().getIdSolicitud().toString();
	}

	@Override
	public String getModel() {
		return PropertyUtil.getProperty(ConstantesWs.UAC_EXPEDIENTE_KEY_MODEL);
	}

	@Override
	public String getKeySearch() {
		return ConstantesWs.UAC_EXPEDIENTE_KEY_SEARCH;
	}
}
