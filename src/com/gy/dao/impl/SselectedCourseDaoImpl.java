package com.gy.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_selected_course;
import com.gy.dao.SselectedCourseDao;

public class SselectedCourseDaoImpl extends BaseDao<SselectedCourseDao> implements SselectedCourseDao {
	public SselectedCourseDaoImpl() {
		this.setMapper(SselectedCourseDao.class);
	}

	@Override
	public List<S_selected_course> findAll(String name) {
		return this.getMapper().findAll(name);
	}

	@Override
	public int create(int student_id,int course_id) {
		int count=this.getMapper().create(student_id,course_id);
		this.session.commit();
		return count;
	}

	@Override
	public int modify(int sid,int cid,int id) {
		int count=this.getMapper().modify(sid,cid,id);
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
