package com.gy.talemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gy.bean.S_course;


public class CourseTableModel extends AbstractTableModel {
	private String[] columnNames= {"课程编号","课程名称","授课老师","课程最大人数","已选人数","课程介绍"};
	private List<S_course> data;
	public CourseTableModel(List<S_course> data) {
		this.data=data;
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		S_course course=data.get(rowIndex);
		switch (columnIndex) {
		case 0:return course.getId();
		case 1:return course.getName();
		case 2:return course.getTeacherId().getName();
		case 3:return course.getMax_student_num();
		case 4:return course.getSelected_num();
		default:return course.getInfo();
		}
	}
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
}
