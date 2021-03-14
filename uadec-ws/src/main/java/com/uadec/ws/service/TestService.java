package com.uadec.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uadec.core.base.BaseService;
import com.uadec.entity.dao.RolDao;
import com.uadec.entity.dao.UsuarioDao;
import com.uadec.entity.model.Rol;
import com.uadec.entity.model.Usuario;
import com.uadec.ws.model.Test;

@Transactional
@Service
public class TestService extends BaseService<Test> {

	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private RolDao rolDao;

	public List<Test> findTests(Test instance) {
		return new ArrayList<Test>();
	}

	public Test findTest(String id) {
		return new Test();
	}

	public Test saveTest(Test instance) {
		return instance;
	}

	public Test updateTest(Test instance, String id) {
		return instance;
	}

	public Test deleteTest(String id) {
		return new Test();
	}

	public Usuario saveUsuario(Usuario instance) {
		usuarioDao.save(instance);
		return instance;
	}

	public Rol saveRol(Rol instance) {
		rolDao.save(instance);
		return instance;
	}
}
