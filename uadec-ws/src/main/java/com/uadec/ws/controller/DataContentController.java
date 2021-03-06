package com.uadec.ws.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uadec.core.base.BaseController;
import com.uadec.core.util.Constantes;
import com.uadec.entity.model.CatDocumentos;
import com.uadec.entity.model.CatTipoTramite;
import com.uadec.ws.model.DataContent;
import com.uadec.ws.service.DataContentService;
import com.uadec.ws.util.ConstantesWs;
import com.uadec.ws.util.Utilerias;
import com.uadec.ws.validator.DataContentValidator;

@RestController
@RequestMapping(value=ConstantesWs.CONTEXTO + Constantes.CONTEXTO_ROOT + "data")
public class DataContentController extends BaseController<DataContentService,DataContent> {
	
	private static final Logger logger = Logger.getLogger(DataContentController.class);
	
	@Autowired 
	DataContentValidator dataContentValidator;
	
	/**
	 * Metodo para Guardar los datos en BD y en CM
	 * @param session
	 * @param request
	 * @param response
	 * @param dataContent
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String upladFile(HttpSession session, HttpServletRequest request, HttpServletResponse response, @ModelAttribute DataContent dataContent, BindingResult result) {
		
		dataContentValidator.validate(dataContent, result);
		if (result.hasErrors()) {
			request.setAttribute("dataContent", dataContent);
			List<ObjectError> errors = result.getAllErrors();
			logger.debug(errors.toString());
			return errors.toString();
		} else {
			try {
				CatTipoTramite catTipoTramite = new CatTipoTramite();
				catTipoTramite.setIdTipoTramite(dataContent.getSolicitud().getCatTipoTramite().getIdTipoTramite());
				dataContent.getSolicitud().setCatTipoTramite(catTipoTramite);
				if (StringUtils.isEmpty(dataContent.getSolicitud().getFechaSolicitudStr())) {
					String today = Utilerias.convertDateFormat(new Date());
					dataContent.getSolicitud().setFechaSolicitud(Utilerias.parseDate(today, "dd/MM/yyyy"));
				} else {
					dataContent.getSolicitud().setFechaSolicitud(Utilerias.parseDate(dataContent.getSolicitud().getFechaSolicitudStr(), "dd/MM/yyyy"));
				}
				
				dataContent.getSolicitud().setCatTipoTramite(catTipoTramite);
				
				if (StringUtils.isEmpty(dataContent.getSolicitud().getImporteStr())) {
					dataContent.getSolicitud().setImporte(BigDecimal.ZERO);
				} else {
					dataContent.getSolicitud().setImporte(Utilerias.convertStringToBigDecimal(dataContent.getSolicitud().getImporteStr()));
				}
				
				CatDocumentos catDocumentos = new CatDocumentos();
				catDocumentos.setIdDocumento(dataContent.getDocumentoImportado().getCatDocumentos().getIdDocumento());
				dataContent.getDocumentoImportado().setCatDocumentos(catDocumentos);
				
				dataContent = getService().saveDataContent(dataContent);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "{'success':'SUCCESS!!'}";
	}

}
