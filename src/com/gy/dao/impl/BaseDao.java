package com.gy.dao.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDao<T> {
	private SqlSessionFactory sqlSessionFactory;
	protected SqlSession session;
	private Class<T> mapper;
	
	public BaseDao() {
		initSqlSessionFactory();
		session=sqlSessionFactory.openSession();
	}
	
	public T getMapper() {
		return session.getMapper(mapper);
	}

	public void setMapper(Class<T> mapper) {
		this.mapper = mapper;
	}

	private void initSqlSessionFactory(){
		InputStream is=null;
		try {
			is=Resources.getResourceAsStream("MyBatis.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
	}
}
