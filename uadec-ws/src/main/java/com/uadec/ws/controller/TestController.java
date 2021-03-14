package com.uadec.ws.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uadec.core.base.BaseController;
import com.uadec.core.util.Constantes;
import com.uadec.entity.model.Rol;
import com.uadec.entity.model.Usuario;
import com.uadec.ws.model.Test;
import com.uadec.ws.service.TestService;
import com.uadec.ws.util.ConstantesWs;

@RestController
@RequestMapping(value=ConstantesWs.CONTEXTO + Constantes.CONTEXTO_ROOT + "test")
public class TestController extends BaseController<TestService,Test> {

	@RequestMapping(method = RequestMethod.GET)
	public List<Test> findBy(@ModelAttribute Test instance) {
		return getService().findTests(instance);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Test findById(@PathVariable String id) {
		return getService().findTest(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Test save(@RequestBody Test instance) {
		return getService().saveTest(instance);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Test update(@RequestBody Test instance, @PathVariable String id) {
		return getService().updateTest(instance, id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Test delete(@PathVariable String id) {
		return getService().deleteTest(id);
	}
	
	@RequestMapping(value="/saveUsuario",method = RequestMethod.POST)
	public Usuario save(@RequestBody Usuario instance) {
		return getService().saveUsuario(instance);
	}
	
	@RequestMapping(value="/saveRol",method = RequestMethod.POST)
	public Rol save(@RequestBody Rol instance) {
		log.debug("Hola Edgar, me estoy pintando");
		return getService().saveRol(instance);
	}
}
