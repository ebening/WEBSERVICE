package com.uadec.entity.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uadec.core.base.BaseService;
import com.uadec.entity.dao.DetalleCuentaDao;
import com.uadec.entity.model.DetalleCuentas;

@Transactional
@Service
public class DetalleCuentaService extends BaseService<DetalleCuentas> {
	
	@Autowired
	private DetalleCuentaDao detalleCuenta;


	public List<DetalleCuentas> findDetalleCuentases(DetalleCuentas instance) {
		return detalleCuenta.findAll();
	}
	
	public DetalleCuentas findDetalleCuentasById(Long id){
		return detalleCuenta.findById(id);
	}
	
	public void saveDetalleCuentas(DetalleCuentas instance){
		 detalleCuenta.save(instance);
	}
	
	public void updateDetalleCuentas(DetalleCuentas instance){
		detalleCuenta.update(instance);
	}
	
	public void deleteDetalleCuentas(DetalleCuentas instance){
		detalleCuenta.delete(instance);
	}
}
