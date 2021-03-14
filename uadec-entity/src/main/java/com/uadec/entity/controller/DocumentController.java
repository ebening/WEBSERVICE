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
import com.uadec.entity.model.CatDocumentos;
import com.uadec.entity.model.DocumentoImportado;
import com.uadec.entity.model.Solicitud;
import com.uadec.entity.model.Usuario;
import com.uadec.entity.service.DocumentoImportadoService;
import com.uadec.entity.util.ConstantesEntity;

@RestController
@RequestMapping(value=ConstantesEntity.CONTEXTO + Constantes.CONTEXTO_ROOT + "document")
public class DocumentController extends BaseController<DocumentoImportadoService,DocumentoImportado> {

	@RequestMapping(method = RequestMethod.GET)
	public List<DocumentoImportado> findBy(@ModelAttribute DocumentoImportado instance) {
		DocumentoImportado documentoImportado = new DocumentoImportado();
		CatDocumentos catDocumentos = new CatDocumentos();
		catDocumentos.setIdDocumento(1);
		documentoImportado.setCatDocumentos(catDocumentos);
		documentoImportado.setNombredoc("nombre");
		documentoImportado.setPid("");
		Solicitud solicitud2 = new Solicitud();
		solicitud2.setIdSolicitud(1L);
		documentoImportado.setSolicitud(solicitud2);
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1L);
		documentoImportado.setUsuario(usuario);
		getService().saveDocumentoImportado(documentoImportado);
		return getService().findDocumentoImportado(instance);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DocumentoImportado findById(@PathVariable String id) {
		return getService().findDocumentoImportadoById(Long.valueOf(id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody DocumentoImportado instance) {
		getService().saveDocumentoImportado(instance);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody DocumentoImportado instance, @PathVariable Long id) {
		instance.setIdDocumentoImportado(id);
		getService().updateDocumentoImportado(instance);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		getService().deleteDocumentoImportado(Long.valueOf(id));
	}

}
