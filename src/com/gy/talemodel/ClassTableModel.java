package com.gy.talemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gy.bean.S_class;

public class ClassTableModel extends AbstractTableModel {
	private String[] columnNames= {"∞‡º∂±‡∫≈","∞‡º∂√˚≥∆","∞‡º∂ΩÈ…‹"};
	private List<S_class> data;
	public ClassTableModel(List<S_class> data) {
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
		S_class clazz=data.get(rowIndex);
		switch (columnIndex) {
		case 0:return clazz.getId();
		case 1:return clazz.getName();
		default:return clazz.getInfo();
		}
	}
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
}
