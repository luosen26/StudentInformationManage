package com.gy.talemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gy.bean.S_teacher;

public class TeacherTableModel extends AbstractTableModel {
	private String[] columnNames= {"教师ID","教师姓名","教师性别","教师职称","教师年龄","登陆密码"};
	private List<S_teacher> data;
	public TeacherTableModel(List<S_teacher> data) {
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
		S_teacher teacher=data.get(rowIndex);
		switch (columnIndex) {
		case 0:return teacher.getId();
		case 1:return teacher.getName();
		case 2:return teacher.getSex();
		case 3:return teacher.getTitle();
		case 4:return teacher.getAge();
		default:return teacher.getPassword();
		}
	}
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
}
