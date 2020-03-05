package com.gy.talemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gy.bean.S_attendance;
import com.gy.dao.SattendanceDao;

public class SignCountTableModel extends AbstractTableModel {
	private String[] columnNames= {"课程名称","签到人数","缺席人数","选课人数","日期"};
	private List<S_attendance> data;
	private SattendanceDao attendanceDao;
	private int signCount;
	public SignCountTableModel(SattendanceDao attendanceDao,List<S_attendance> data) {
		this.attendanceDao=attendanceDao;
		this.data=data;
		this.signCount=0;
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
		signCount=attendanceDao.findByCourseAndDate(attendance.getCourseId().getId(),
				attendance.getAttendance_date());
		switch (columnIndex) {
		case 0:return attendance.getCourseId().getName();
		case 1:return signCount;
		case 2:return attendance.getCourseId().getSelected_num()-signCount;
		case 3:return attendance.getCourseId().getSelected_num();
		default:return attendance.getAttendance_date();
		}
	}
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
}
