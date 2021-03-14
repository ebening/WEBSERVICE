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
public class RelTramiteDocumentoService extends BaseService<RelTramiteDocumento> {
	
	@Autowired
	private RelTramiteDocumentoDao relTramiteDocumentoDao;


	public List<RelTramiteDocumento> findRelTramiteDocumentoes(RelTramiteDocumento instance) {
		return relTramiteDocumentoDao.findAll();
	}
	
	public RelTramiteDocumento findRelTramiteDocumentoById(Long id){
		return relTramiteDocumentoDao.findById(id);
	}
	
	public void saveRelTramiteDocumento(RelTramiteDocumento instance){
		relTramiteDocumentoDao.save(instance);
	}
	
	public void updateRelTramiteDocumento(RelTramiteDocumento instance){
		relTramiteDocumentoDao.update(instance);
	}
	
	public void deleteRelTramiteDocumento(RelTramiteDocumento instance){
		relTramiteDocumentoDao.delete(instance);
	}
}
