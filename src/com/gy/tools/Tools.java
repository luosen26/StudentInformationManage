package com.gy.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.gy.bean.S_class;
import com.gy.bean.S_course;
import com.gy.bean.S_selected_course;
import com.gy.bean.S_student;
import com.gy.bean.S_teacher;

public class Tools {
	
	public static String dateToString(Date date){
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static String changeDate(String date){
		int first=date.indexOf("-");
		int last=date.lastIndexOf("-");
		char[] buf=(date+"»’").toCharArray();
		buf[first]='ƒÍ';
		buf[last]='‘¬';	
		return new String(buf);
	}
	
	public static Date stringToDate(String date){
		Date d=null;
		try {
			d = new SimpleDateFormat().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static boolean isNumber(String str){
		String number=str.replace(" ", "");
		if (number.length()!=0) {
			char[] buf=number.toCharArray();
			for (int i = 0; i < buf.length; i++) {
				if (buf[i]<48||buf[i]>57) {
					return false;
				}
			}
			return true;
		}else {
			return false;
		}
	}
	public static boolean isPassword(String str){
		String number=str.replace(" ", "");
		if (number.length()!=0) {
			char[] buf=number.toCharArray();
			for (int i = 0; i < buf.length; i++) {
				if (buf[i]<48||buf[i]>122) {
					return false;
				}else if (57<buf[i]&&buf[i]<65) {
					return false;
				}else if (90<buf[i]&&buf[i]<97) {
					return false;
				}
			}
			return true;
		}else {
			return false;
		}
	}
	
	public static String isEmpty(String str){
		return str.replace(" ","");
	}
	public static boolean isNotNull(String s){
		if(s!="" && s!=null){
			return true;
		}
		return false;
	}
	public static JLabel getLable(String str) {
		JLabel label = new JLabel(str);
		label.setForeground(Color.red);
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		return label;
	}
	public static String[] getClassNames(List<S_class> data) {
		String[] names=new String[data.size()+1];
		names[0]="-«Î—°‘Ò-";
		for(int i=1;i<names.length;i++) {
			names[i]=data.get(i-1).getName();
		}
		return names;
	}
	public static String[] getTeacherNames(List<S_course> data) {
		String[] names=new String[data.size()+1];
		names[0]="-«Î—°‘Ò-";
		for(int i=1;i<names.length;i++) {
			names[i]=data.get(i-1).getTeacherId().getName();
		}
		return names;
	}
	public static String[] getteacherNames(List<S_teacher> data) {
		String[] names=new String[data.size()+1];
		names[0]="-«Î—°‘Ò-";
		for(int i=1;i<names.length;i++) {
			names[i]=data.get(i-1).getName();
		}
		return names;
	}
	public static String[] getStudentNames(List<S_student> data) {
		String[] names=new String[data.size()+1];
		names[0]="-«Î—°‘Ò-";
		for(int i=1;i<names.length;i++) {
			names[i]=data.get(i-1).getName();
		}
		return names;
	}
	public static String[] getstudentNames(List<S_selected_course> data) {
		String[] names=new String[data.size()+1];
		names[0]="-«Î—°‘Ò-";
		for(int i=1;i<names.length;i++) {
			names[i]=data.get(i-1).getStudentId().getName();
		}
		return names;
	}
	public static String[] getCourseNames(List<S_course> data) {
		String[] names=new String[data.size()+1];
		names[0]="-«Î—°‘Ò-";
		for(int i=1;i<names.length;i++) {
			names[i]=data.get(i-1).getName();
		}
		return names;
	}
	public static String[] getcourseNames(List<S_selected_course> data) {
		String[] names=new String[data.size()+1];
		names[0]="-«Î—°‘Ò-";
		for(int i=1;i<names.length;i++) {
			names[i]=data.get(i-1).getCourseId().getName();
		}
		return names;
	}
	public static boolean isName(String str) {
		String bankName=str.replace(" ", "");
		if (bankName.length()>1) {
			char[] buf=bankName.toCharArray();
			for (int i = 0; i < buf.length; i++) {
				if (48<=buf[i]&&buf[i]<=57) {
					return false;
				}
			}
			return true;
		}else {
			return false;
		}
	}
	public static Point getPostion(int width,int height){
		double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int x = (int) (screenWidth - width)/2;
		int y = (int) (screenHeight - height)/2;
		return new Point(x, y);
	}
}
