package com.uadec.entity.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uadec.core.base.BaseService;
import com.uadec.entity.dao.SolicitudDao;
import com.uadec.entity.model.Solicitud;

@Transactional
@Service
public class SolicitudService extends BaseService<Solicitud> {

	@Autowired
	private SolicitudDao solicitudDao;


	public List<Solicitud> findSolicitudes(Solicitud instance) {
		return solicitudDao.findAll();
	}

	public Solicitud findSolicitudById(Long id){
		return solicitudDao.findById(id);
	}

	public void saveSolicitud(Solicitud instance){
		solicitudDao.save(instance);
	}

	public void updateSolicitud(Solicitud instance, Long id){
		solicitudDao.update(instance);
	}

	public void deleteSolicitud(Long id){
		Solicitud instance = new Solicitud();
		instance.setIdSolicitud(id);
		solicitudDao.delete(instance);
	}
}
