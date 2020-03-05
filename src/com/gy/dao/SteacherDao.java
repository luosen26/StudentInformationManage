package com.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_teacher;

public interface SteacherDao {
	public S_teacher teacherLogin(@Param("name")String name,
			@Param("password")String password);
	public int modifyPassword(@Param("id")int id,
			@Param("password")String password);
	public List<S_teacher> findAll(@Param("name")String name);
	public int create(S_teacher teacher);
	public int modify(S_teacher teacher);
	public int remove(int id);
}
