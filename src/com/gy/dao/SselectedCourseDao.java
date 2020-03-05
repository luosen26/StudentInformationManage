package com.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_selected_course;

public interface SselectedCourseDao {
	public List<S_selected_course> findAll(@Param("name")String name);
	public int create(@Param("student_id")int student_id,@Param("course_id")int course_id);
	public int modify(@Param("sid")int sid,@Param("cid")int cid,@Param("id")int id);
	public int remove(int id);
}
