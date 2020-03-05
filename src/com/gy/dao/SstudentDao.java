package com.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_student;

public interface SstudentDao {
	public S_student studentLogin(@Param("name")String name,
			@Param("password")String password);
	public int modifyPassword(@Param("id")int id,
			@Param("password")String password);
	public List<S_student> findAll(@Param("name")String name,@Param("id")int id);
	public int create(S_student student);
	public int modify(S_student student);
	public int remove(int id);
}
