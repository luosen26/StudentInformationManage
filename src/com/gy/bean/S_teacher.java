package com.gy.bean;

import org.apache.ibatis.type.Alias;

@Alias("S_teacher")
public class S_teacher {
	private int id;
	private String name;
	private String sex;
	private String title;
	private int age;
	private String password;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public S_teacher() {
	}
	public S_teacher(int id, String name, String sex, String title, int age,
			String password) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.title = title;
		this.age = age;
		this.password = password;
	}
	public S_teacher(String name, String sex, String title, int age,
			String password) {
		this.name = name;
		this.sex = sex;
		this.title = title;
		this.age = age;
		this.password = password;
	}
	@Override
	public String toString() {
		return name;
	}
}
