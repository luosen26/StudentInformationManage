package com.gy.dao.impl;

import java.util.List;

import com.gy.bean.S_teacher;
import com.gy.dao.SteacherDao;

public class SteacherDaoImpl extends BaseDao<SteacherDao> implements SteacherDao {
	public SteacherDaoImpl() {
		this.setMapper(SteacherDao.class);
	}

	@Override
	public S_teacher teacherLogin(String name, String password) {
		return this.getMapper().teacherLogin(name, password);
	}

	@Override
	public int modifyPassword(int id, String password) {
		int count=this.getMapper().modifyPassword(id, password);
		this.session.commit();
		return count;
	}

	@Override
	public List<S_teacher> findAll(String name) {
		return this.getMapper().findAll(name);
	}

	@Override
	public int create(S_teacher teacher) {
		int count=this.getMapper().create(teacher);
		this.session.commit();
		return count;
	}

	@Override
	public int modify(S_teacher teacher) {
		int count=this.getMapper().modify(teacher);
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
