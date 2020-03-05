package com.gy.dao.impl;

import java.util.List;

import com.gy.bean.S_class;
import com.gy.dao.SclassDao;

public class SclassDaoImpl extends BaseDao<SclassDao> implements SclassDao {
	public SclassDaoImpl() {
		this.setMapper(SclassDao.class);
	}
	@Override
	public List<S_class> findAll(String name) {
		return this.getMapper().findAll(name);
	}
	@Override
	public S_class findByName(String name) {
		return this.getMapper().findByName(name);
	}
	@Override
	public int create(S_class clazz) {
		int count=this.getMapper().create(clazz);
		this.session.commit();
		return count;
	}
	@Override
	public int modify(S_class clazz) {
		int count=this.getMapper().modify(clazz);
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
