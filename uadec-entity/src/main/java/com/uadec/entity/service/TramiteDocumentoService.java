package com.uadec.entity.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uadec.core.base.BaseService;
import com.uadec.entity.dao.RelTramiteDocumentoDao;
import com.uadec.entity.model.RelTramiteDocumento;

@Transactional
@Service
public class TramiteDocumentoService extends BaseService<RelTramiteDocumento> {
	
	@Autowired
	private RelTramiteDocumentoDao tramiteDocumento;


	public List<RelTramiteDocumento> findRelTramiteDocumentoes(RelTramiteDocumento instance) {
		return tramiteDocumento.findAll();
	}
	
	public RelTramiteDocumento findRelTramiteDocumentoById(Long id){
		return tramiteDocumento.findById(id);
	}
	
	public void saveRelTramiteDocumento(RelTramiteDocumento instance){
		 tramiteDocumento.save(instance);
	}
	
	public void updateRelTramiteDocumento(RelTramiteDocumento instance){
		tramiteDocumento.update(instance);
	}
	
	public void deleteRelTramiteDocumento(RelTramiteDocumento instance){
		tramiteDocumento.delete(instance);
	}
}
