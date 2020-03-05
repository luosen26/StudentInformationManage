package com.gy.dao;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_admin;
import com.gy.bean.S_student;

public interface SadminDao {
	public S_admin adminLogin(@Param("name")String name,
			@Param("password")String password);
	public int modifyPassword(@Param("id")int id,
			@Param("password")String password);
}
