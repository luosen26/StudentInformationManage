package com.gy.dao.impl;

import com.gy.bean.S_admin;
import com.gy.bean.S_student;
import com.gy.dao.SadminDao;

public class SadminDaoImpl extends BaseDao<SadminDao> implements SadminDao {
	
	
	public SadminDaoImpl() {
		this.setMapper(SadminDao.class);
	}

	@Override
	public S_admin adminLogin(String name, String password) {
		return this.getMapper().adminLogin(name, password);
	}

	@Override
	public int modifyPassword(int id, String password) {
		int count=this.getMapper().modifyPassword(id, password);
		this.session.commit();
		return count;
	}

}
