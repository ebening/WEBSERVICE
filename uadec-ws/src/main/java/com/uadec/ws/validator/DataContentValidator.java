/**
 * 
 */
package com.uadec.ws.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.uadec.ws.model.DataContent;
import com.uadec.core.util.Constantes;


/**
 * @author ADINFI
 *
 */
@Component
public class DataContentValidator implements Validator {

	/**
	 * 
	 */
	public DataContentValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return DataContent.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		DataContent vo = (DataContent) obj;
		if (StringUtils.isEmpty(vo.getSolicitud().getCiclo())) {
			errors.rejectValue("solicitud.ciclo", "errors.fieldRequired", null, Constantes.CAMPO_REQUERIDO);
		} else if (StringUtils.isEmpty(vo.getSolicitud().getCuentaPagar())) {
			errors.rejectValue("solicitud.cuentaPagar", "errors.fieldRequired", null, Constantes.CAMPO_REQUERIDO);
		} else if (vo.getSolicitud().getCatTipoTramite().getIdTipoTramite() == null) {
			errors.rejectValue("solicitud.catTipoTramite.idTipoTramite", "errors.fieldRequired", null, Constantes.CAMPO_REQUERIDO);
		} else if (vo.getDocumentoImportado().getCatDocumentos().getIdDocumento() == null) {
			errors.rejectValue("documentoImportado.catDocumentos.idDocumento", "errors.fieldRequired", null, Constantes.CAMPO_REQUERIDO);
		} else if (StringUtils.isEmpty(vo.getDocumentoImportado().getUsuario().getLogin())) {
			errors.rejectValue("documentoImportado.usuario.login", "errors.fieldRequired", null, Constantes.CAMPO_REQUERIDO);
		} else if(vo.getSolicitud().getFondo().length() > 20) {
			errors.rejectValue("solicitud.fondo", "errors.length", new Object[] {"20"}, Constantes.CAMPO_MAYOR_A_20);
		} else if(vo.getSolicitud().getNCbancaria().length() > 20) {
			errors.rejectValue("solicitud.NCbancaria", "errors.length", new Object[] {"20"}, Constantes.CAMPO_MAYOR_A_20);
		} else if(vo.getSolicitud().getUnidadOrg().length() > 20) {
			errors.rejectValue("solicitud.unidadOrg", "errors.length", new Object[] {"20"}, Constantes.CAMPO_MAYOR_A_20);
		} else if(vo.getSolicitud().getAutorizador().length() > 100) {
			errors.rejectValue("solicitud.autorizador", "errors.length", new Object[] {"100"}, Constantes.CAMPO_MAYOR_A_100);
		} else if(vo.getSolicitud().getElaborador().length() > 100) {
			errors.rejectValue("solicitud.elaborador", "errors.length", new Object[] {"100"}, Constantes.CAMPO_MAYOR_A_100);
		} else if(vo.getSolicitud().getContrato().length() > 20) {
			errors.rejectValue("solicitud.contrato", "errors.length", new Object[] {"20"}, Constantes.CAMPO_MAYOR_A_20);
		} else if(vo.getSolicitud().getRfcProveedor().length() > 30) {
			errors.rejectValue("solicitud.rfcProveedor", "errors.length", new Object[] {"30"}, Constantes.CAMPO_MAYOR_A_30);
		} else if(vo.getSolicitud().getCheque().length() > 20) {
			errors.rejectValue("solicitud.cheque", "errors.length", new Object[] {"20"}, Constantes.CAMPO_MAYOR_A_20);
		} else if(vo.getSolicitud().getCuentaPagar().length() > 20) {
			errors.rejectValue("solicitud.cuentaPagar", "errors.length", new Object[] {"20"}, Constantes.CAMPO_MAYOR_A_20);
		} else if(vo.getSolicitud().getCiclo().length() > 4) {
			errors.rejectValue("solicitud.ciclo", "errors.length", new Object[] {"4"}, Constantes.CAMPO_MAYOR_A_20);
		} else if(vo.getSolicitud().getFolioVentanilla().length() > 20) {
			errors.rejectValue("solicitud.folioVentanilla", "errors.length", new Object[] {"20"}, Constantes.CAMPO_MAYOR_A_20);
		} else if(vo.getSolicitud().getFolioSdr().length() > 20) {
			errors.rejectValue("solicitud.folioSdr", "errors.length", new Object[] {"20"}, Constantes.CAMPO_MAYOR_A_20);
		} else if(vo.getSolicitud().getNCompromiso().length() > 20) {
			errors.rejectValue("solicitud.NCompromiso", "errors.length", new Object[] {"20"}, Constantes.CAMPO_MAYOR_A_20);
		} else if(vo.getSolicitud().getClaveBeneficiario().length() > 20) {
			errors.rejectValue("solicitud.claveBeneficiario", "errors.length", new Object[] {"20"}, Constantes.CAMPO_MAYOR_A_20);
		} else if(vo.getDocumentoImportado().getNombredoc().length() > 20) {
			errors.rejectValue("documentoImportado.nombredoc", "errors.length", new Object[] {"20"}, Constantes.CAMPO_MAYOR_A_20);
		} 
		
	}

}
