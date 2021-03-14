package com.uadec.entity.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uadec.core.base.BaseService;
import com.uadec.entity.dao.BitacoraDao;
import com.uadec.entity.model.Bitacora;

@Transactional
@Service
public class BitacoraService extends BaseService<Bitacora> {
	
	@Autowired
	private BitacoraDao bitacoraDao;


	public List<Bitacora> findBitacoraes(Bitacora instance) {
		return bitacoraDao.findAll();
	}
	
	public Bitacora findBitacoraById(Long id){
		return bitacoraDao.findById(id);
	}
	
	public void saveBitacora(Bitacora instance){
		 bitacoraDao.save(instance);
	}
	
	public void updateBitacora(Bitacora instance){
		bitacoraDao.update(instance);
	}
	
	public void deleteBitacora(Bitacora instance){
		bitacoraDao.delete(instance);
	}
}
