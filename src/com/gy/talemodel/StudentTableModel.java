package com.gy.talemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gy.bean.S_student;

public class StudentTableModel extends AbstractTableModel {
	private String[] columnNames= {"学生编号","学生姓名","所属班级","学生性别","登陆密码"};
	private List<S_student> data;
	public StudentTableModel(List<S_student> data) {
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
		S_student student=data.get(rowIndex);
		switch (columnIndex) {
		case 0:return student.getId();
		case 1:return student.getName();
		case 2:return student.getClassId().getName();
		case 3:return student.getSex();
		default:return student.getPassword();
		}
	}
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
}
