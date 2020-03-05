package com.gy.dao.impl;

import java.util.List;

import com.gy.bean.S_course;
import com.gy.dao.ScourseDao;

public class ScourseDaoImpl extends BaseDao<ScourseDao> implements ScourseDao {
	public ScourseDaoImpl() {
		this.setMapper(ScourseDao.class);
	}
	@Override
	public List<S_course> findAll(String name,int id) {
		return this.getMapper().findAll(name,id);
	}
	@Override
	public int create(S_course course) {
		int count=this.getMapper().create(course);
		this.session.commit();
		return count;
	}
	@Override
	public int modify(S_course course) {
		int count=this.getMapper().modify(course);
		this.session.commit();
		return count;
	}
	@Override
	public int remove(int id) {
		int count=this.getMapper().remove(id);
		this.session.commit();
		return count;
	}
	@Override
	public List<S_course> findById(int id) {
		return this.getMapper().findById(id);
	}

}
