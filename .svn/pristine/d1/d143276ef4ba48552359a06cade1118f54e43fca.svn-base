package com.uadec.entity.service;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uadec.core.base.BaseService;
import com.uadec.entity.dao.CatDocumentoDao;
import com.uadec.entity.model.CatDocumentos;

@Transactional
@Service
public class CatDocumentoService extends BaseService<CatDocumentos> {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CatDocumentoDao catDocumentoDao;


	public List<CatDocumentos> findCatDocumentoss(CatDocumentos instance) {
		return catDocumentoDao.findAll();
	}
	
	public CatDocumentos findCatDocumentosById(Integer id){
		return catDocumentoDao.findById(id);
	}
	
	public void saveCatDocumentos(CatDocumentos instance){
		catDocumentoDao.save(instance);
	}
	
	public void updateCatDocumentos(CatDocumentos instance){
		catDocumentoDao.update(instance);
	}
	
	public void deleteCatDocumentos(CatDocumentos instance){
		catDocumentoDao.delete(instance);
	}
	
	public CatDocumentos findCatDocumentossByDescripcion(CatDocumentos instance) {
			CatDocumentos catDocumentos = (CatDocumentos)sessionFactory.getCurrentSession().createQuery("from CatDocumentos where descripcion = ?").setParameter(0,instance.getDescripcion()).uniqueResult(); 
		return catDocumentos;
	}
}
