package com.gy.bean;

public enum UserType {
	//�����û�����
	ADMIN("ϵͳ����Ա",0),TEACHER("��ʦ",1),STUDENT("ѧ��",2);
	private String name;
	private int index;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	private UserType(String name, int index) {
		this.name = name;
		this.index = index;
	}
	@Override
	public String toString(){
		return this.name;
	}
}
