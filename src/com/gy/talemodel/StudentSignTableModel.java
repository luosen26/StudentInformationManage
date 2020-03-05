package com.gy.talemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gy.bean.S_attendance;

public class StudentSignTableModel extends AbstractTableModel {
	private String[] columnNames= {"签到ID","学生姓名","课程名称","签到日期"};
	private List<S_attendance> data;
	public StudentSignTableModel(List<S_attendance> data) {
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
		S_attendance attendance=data.get(rowIndex);
		switch (columnIndex) {
		case 0:return attendance.getId();
		case 1:return attendance.getStudentId().getName();
		case 2:return attendance.getCourseId().getName();
		default:return attendance.getAttendance_date();
		}
	}
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
}
