package com.gy.bean;

import org.apache.ibatis.type.Alias;

@Alias("S_student")
public class S_student {
	private int id;
	private String name;
	private S_class classId;
	private String password;
	private String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public S_class getClassId() {
		return classId;
	}
	public void setClassId(S_class classId) {
		this.classId = classId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public S_student() {
	}
	public S_student(int id, String name, S_class classId, String password,
			String sex) {
		this.id = id;
		this.name = name;
		this.classId = classId;
		this.password = password;
		this.sex = sex;
	}
	public S_student(String name, S_class classId, String password, String sex) {
		this.name = name;
		this.classId = classId;
		this.password = password;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return name;
	}
}
