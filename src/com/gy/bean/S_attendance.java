package com.gy.bean;

import org.apache.ibatis.type.Alias;

@Alias("S_attendance")
public class S_attendance {
	private int id;
	private S_student studentId;
	private S_course courseId;
	private String attendance_date;
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
	public String getAttendance_date() {
		return attendance_date;
	}
	public void setAttendance_date(String attendance_date) {
		this.attendance_date = attendance_date;
	}
	public S_attendance() {
	}
	public S_attendance(int id, S_student studentId, S_course courseId,
			String attendance_date) {
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
		this.attendance_date = attendance_date;
	}
	public S_attendance(S_student studentId, S_course courseId,
			String attendance_date) {
		this.studentId = studentId;
		this.courseId = courseId;
		this.attendance_date = attendance_date;
	}
	@Override
	public String toString() {
		return "S_attendance [id=" + id + ", studentId=" + studentId
				+ ", courseId=" + courseId + ", attendance_date="
				+ attendance_date + "]";
	}
}
