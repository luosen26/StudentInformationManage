package com.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_course;

public interface ScourseDao {
	public List<S_course> findAll(@Param("name")String name,@Param("id")int id);
	public List<S_course> findById(int id);
	public int create(S_course course);
	public int modify(S_course course);
	public int remove(int id);
}
