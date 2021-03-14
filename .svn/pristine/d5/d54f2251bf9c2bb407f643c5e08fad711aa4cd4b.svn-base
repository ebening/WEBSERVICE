package com.uadec.entity.dao.support;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.uadec.core.base.BaseDao;

public class UadecDao<T,PK extends Serializable> extends BaseDao<T, PK>{
	@Autowired
	protected void init(@Qualifier(value="sessionFactoryUadec") SessionFactory session) {
		super.init(session);
	}
}
