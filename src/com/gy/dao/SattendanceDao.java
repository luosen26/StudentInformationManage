package com.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_attendance;

public interface SattendanceDao {
	public List<S_attendance> findAll(@Param("cname")String cname,@Param("date")String date,
			@Param("sname")String sname);
	public int findByCourseAndDate(@Param("course_id")int id,
			@Param("attendance_date")String date);
	public int create(@Param("student_id")int sid,
			@Param("course_id")int cid,@Param("attendance_date")String date);
	public int modify(S_attendance attendance);
	public int remove(int id);
}
