package com.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_class;

public interface SclassDao {
	public List<S_class> findAll(@Param("name")String name);
	public S_class findByName(String name);
	public int create(S_class clazz);
	public int modify(S_class clazz);
	public int remove(int id);
}
