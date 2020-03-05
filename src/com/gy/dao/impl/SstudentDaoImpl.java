package com.gy.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_student;
import com.gy.dao.SstudentDao;

public class SstudentDaoImpl extends BaseDao<SstudentDao> implements SstudentDao {
	public SstudentDaoImpl() {
		this.setMapper(SstudentDao.class);
	}
	@Override
	public S_student studentLogin(String name, String password) {
		return this.getMapper().studentLogin(name, password);
	}
	@Override
	public int modifyPassword(int id, String password) {
		int count=this.getMapper().modifyPassword(id, password);
		this.session.commit();
		return count;
	}
	@Override
	public List<S_student> findAll(String name,int id) {
		return this.getMapper().findAll(name,id);
	}
	@Override
	public int create(S_student student) {
		int count=this.getMapper().create(student);
		this.session.commit();
		return count;
	}
	@Override
	public int modify(S_student student) {
		int count=this.getMapper().modify(student);
		this.session.commit();
		return count;
	}
	@Override
	public int remove(int id) {
		int count=this.getMapper().remove(id);
		this.session.commit();
		return count;
	}

}
