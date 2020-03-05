package com.gy.bean;

import org.apache.ibatis.type.Alias;

@Alias("S_class")
public class S_class {
	private int id;
	private String name;
	private String info;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public S_class(int id, String name, String info) {
		this.id = id;
		this.name = name;
		this.info = info;
	}
	public S_class() {
	}
	public S_class(String name, String info) {
		this.name = name;
		this.info = info;
	}
	@Override
	public String toString() {
		return name;
	}
}
