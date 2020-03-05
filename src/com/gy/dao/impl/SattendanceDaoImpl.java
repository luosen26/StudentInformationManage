package com.gy.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_attendance;
import com.gy.dao.SattendanceDao;

public class SattendanceDaoImpl extends BaseDao<SattendanceDao> implements SattendanceDao {
	public SattendanceDaoImpl() {
		this.setMapper(SattendanceDao.class);
	}
	@Override
	public List<S_attendance> findAll(String cname,String date,String sname) {
		return this.getMapper().findAll(cname,date,sname);
	}
	@Override
	public int findByCourseAndDate(int id, String date) {
		return this.getMapper().findByCourseAndDate(id, date);
	}
	@Override
	public int create(int sid, int cid, String date) {
		int count=this.getMapper().create(sid, cid, date);
		this.session.commit();
		return count;
	}
	@Override
	public int modify(S_attendance attendance) {
		int count=this.getMapper().modify(attendance);
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
