package com.uadec.entity.service;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uadec.core.base.BaseService;
import com.uadec.entity.dao.CatTipoTramiteDao;
import com.uadec.entity.model.CatTipoTramite;

@Transactional
@Service
public class CatTipoTramiteService extends BaseService<CatTipoTramite> {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CatTipoTramiteDao catTipoTramiteDao;


	public List<CatTipoTramite> findCatTipoTramites(CatTipoTramite instance) {
		return catTipoTramiteDao.findAll();
	}
	
	public CatTipoTramite findCatTipoTramiteById(Integer id){
		return catTipoTramiteDao.findById(id);
	}
	
	public void saveCatTipoTramite(CatTipoTramite instance){
		catTipoTramiteDao.save(instance);
	}
	
	public void updateCatTipoTramite(CatTipoTramite instance){
		catTipoTramiteDao.update(instance);
	}
	
	public void deleteCatTipoTramite(CatTipoTramite instance){
		catTipoTramiteDao.delete(instance);
	}
	
	public CatTipoTramite findCatTipoTramitesByDescripcion(CatTipoTramite instance) {
			CatTipoTramite catTipoTramite = (CatTipoTramite)sessionFactory.getCurrentSession().createQuery("from CatTipoTramite where descripcion = ?").setParameter(0,instance.getDescripcion()).uniqueResult(); 
		return catTipoTramite;
	}
}
