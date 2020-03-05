package com.gy.bean;

import org.apache.ibatis.type.Alias;

@Alias("S_selected_course")
public class S_selected_course {
	private int id;
	private S_student studentId;
	private S_course courseId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public S_student getStudentId() {
		return studentId;
	}
	public void setStudentId(S_student studentId) {
		this.studentId = studentId;
	}
	public S_course getCourseId() {
		return courseId;
	}
	public void setCourseId(S_course courseId) {
		this.courseId = courseId;
	}
	public S_selected_course() {
	}
	public S_selected_course(int id, S_student studentId, S_course courseId) {
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
	}
	public S_selected_course(S_student studentId, S_course courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}
	@Override
	public String toString() {
		return "S_selected_course [id=" + id + ", studentId=" + studentId
				+ ", courseId=" + courseId + "]";
	}
}
