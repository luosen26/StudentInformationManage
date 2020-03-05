package com.gy.talemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gy.bean.S_selected_course;

public class SelectCourseTableModel extends AbstractTableModel {
	private String[] columnNames= {"选课编号","学生姓名","课程名称"};
	private List<S_selected_course> data;
	public SelectCourseTableModel(List<S_selected_course> data) {
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
		S_selected_course selected_course=data.get(rowIndex);
		switch (columnIndex) {
		case 0:return selected_course.getId();
		case 1:return selected_course.getStudentId().getName();
		default:return selected_course.getCourseId().getName();
		}
	}
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
}
