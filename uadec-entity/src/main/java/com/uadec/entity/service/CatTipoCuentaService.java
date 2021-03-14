package com.uadec.entity.service;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uadec.core.base.BaseService;
import com.uadec.entity.dao.CatTipoCuentaDao;
import com.uadec.entity.model.CatTipoCuenta;

@Transactional
@Service
public class CatTipoCuentaService extends BaseService<CatTipoCuenta> {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CatTipoCuentaDao catTipoCuentaDao;


	public List<CatTipoCuenta> findCatTipoCuentas(CatTipoCuenta instance) {
		return catTipoCuentaDao.findAll();
	}
	
	public CatTipoCuenta findCatTipoCuentaById(Integer id){
		return catTipoCuentaDao.findById(id);
	}
	
	public void saveCatTipoCuenta(CatTipoCuenta instance){
		catTipoCuentaDao.save(instance);
	}
	
	public void updateCatTipoCuenta(CatTipoCuenta instance){
		catTipoCuentaDao.update(instance);
	}
	
	public void deleteCatTipoCuenta(CatTipoCuenta instance){
		catTipoCuentaDao.delete(instance);
	}
	
	public CatTipoCuenta findCatTipoCuentasByDescripcion(CatTipoCuenta instance) {
//		Session session = sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(CatTipoCuenta.class);
//				List<CatTipoCuenta> list = session.createCriteria(CatTipoCuenta.class)
//				      .createCriteria("catTipoCuenta")
//				          .add( Restrictions.like("descripcion", instance.getDescripcion()) )
//				      .list();
			CatTipoCuenta tipoCuenta = (CatTipoCuenta)sessionFactory.getCurrentSession().createQuery("from CatTipoCuenta where descripcion = ?").setParameter(0,instance.getDescripcion()).uniqueResult(); 
		return tipoCuenta;
	}
}
