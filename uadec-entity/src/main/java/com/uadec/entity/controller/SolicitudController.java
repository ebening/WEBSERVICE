package com.uadec.entity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uadec.core.base.BaseController;
import com.uadec.core.util.Constantes;
import com.uadec.entity.model.Solicitud;
import com.uadec.entity.service.SolicitudService;
import com.uadec.entity.util.ConstantesEntity;

@RestController
@RequestMapping(value=ConstantesEntity.CONTEXTO + Constantes.CONTEXTO_ROOT + "solicitud")
public class SolicitudController extends BaseController<SolicitudService,Solicitud> {

	@RequestMapping(method = RequestMethod.GET)
	public List<Solicitud> findBy(@ModelAttribute Solicitud instance) {
		List<Solicitud> list = getService().findSolicitudes(instance);
		return list;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Solicitud findById(@PathVariable String id) {
		return getService().findSolicitudById(Long.valueOf(id));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody Solicitud instance, @PathVariable String id) {
		getService().updateSolicitud(instance, Long.valueOf(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		getService().deleteSolicitud(Long.valueOf(id));
	}
}
