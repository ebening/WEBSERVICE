package com.uadec.entity.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uadec.core.base.BaseService;
import com.uadec.entity.dao.DocumentoDao;
import com.uadec.entity.model.DocumentoImportado;

@Transactional
@Service
public class DocumentoImportadoService extends BaseService<DocumentoImportado> {
	
	@Autowired
	private DocumentoDao documentoDao;


	public List<DocumentoImportado> findDocumentoImportado(DocumentoImportado instance) {
		return documentoDao.findAll();
	}
	
	public DocumentoImportado findDocumentoImportadoById(Long id){
		return documentoDao.findById(id);
	}
	
	public void saveDocumentoImportado(DocumentoImportado instance){
		 documentoDao.save(instance);
	}
	
	public void updateDocumentoImportado(DocumentoImportado instance){
		documentoDao.update(instance);
	}
	
	public void deleteDocumentoImportado(Long id){
		DocumentoImportado instance = new DocumentoImportado();
		instance.setIdDocumentoImportado(id);
		documentoDao.delete(instance);
	}
}
