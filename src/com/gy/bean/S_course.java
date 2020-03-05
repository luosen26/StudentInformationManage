package com.gy.bean;

import org.apache.ibatis.type.Alias;

@Alias("S_course")
public class S_course {
	private int id;
	private String name;
	private S_teacher teacherId;
	private int max_student_num;
	private String info;
	private int selected_num;
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
	public S_teacher getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(S_teacher teacherId) {
		this.teacherId = teacherId;
	}
	public int getMax_student_num() {
		return max_student_num;
	}
	public void setMax_student_num(int max_student_num) {
		this.max_student_num = max_student_num;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getSelected_num() {
		return selected_num;
	}
	public void setSelected_num(int selected_num) {
		this.selected_num = selected_num;
	}
	public S_course() {
	}
	public S_course(int id, String name, S_teacher teacherId,
			int max_student_num, String info, int selected_num) {
		this.id = id;
		this.name = name;
		this.teacherId = teacherId;
		this.max_student_num = max_student_num;
		this.info = info;
		this.selected_num = selected_num;
	}
	public S_course(String name, S_teacher teacherId, int max_student_num,
			String info, int selected_num) {
		this.name = name;
		this.teacherId = teacherId;
		this.max_student_num = max_student_num;
		this.info = info;
		this.selected_num = selected_num;
	}
	@Override
	public String toString() {
		return name;
	}
}
