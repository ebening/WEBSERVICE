package com.uadec.entity.service;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uadec.core.base.BaseService;
import com.uadec.entity.dao.UsuarioDao;
import com.uadec.entity.model.Usuario;

@Transactional
@Service
public class UsuarioService extends BaseService<Usuario> {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UsuarioDao usuarioDao;


	public List<Usuario> findUsuarios(Usuario instance) {
		return usuarioDao.findAll();
	}
	
	public Usuario findUsuarioById(Long id){
		return usuarioDao.findById(id);
	}
	
	public void saveUsuario(Usuario instance){
		usuarioDao.save(instance);
	}
	
	public void updateUsuario(Usuario instance){
		usuarioDao.update(instance);
	}
	
	public void deleteUsuario(Usuario instance){
		usuarioDao.delete(instance);
	}
	
	public Usuario findUsuarioByLogin(Usuario instance) {
		Usuario usuario = (Usuario)sessionFactory.getCurrentSession().createQuery("from Usuario where login = ?").setParameter(0,instance.getLogin()).uniqueResult(); 
	return usuario;
}
}
