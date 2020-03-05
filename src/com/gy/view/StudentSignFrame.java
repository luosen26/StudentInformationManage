package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.gy.bean.S_attendance;
import com.gy.bean.S_student;
import com.gy.dao.SattendanceDao;
import com.gy.dao.ScourseDao;
import com.gy.dao.impl.SattendanceDaoImpl;
import com.gy.dao.impl.ScourseDaoImpl;
import com.gy.dao.impl.SselectedCourseDaoImpl;
import com.gy.talemodel.StudentSignTableModel;
import com.gy.tools.Chooser;
import com.gy.tools.Tools;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentSignFrame {
	private S_student student;
	private ScourseDao courseDao;
	private String[] courseNames;
	private JTable studentSignTable;
	private SattendanceDao attendanceDao;
	private int studentSignSelectedRow = -1;
	private List<S_attendance> studentSignData;
	private JComboBox<String> courseUpComboBox;
	private JComboBox<String> courseDownComboBox;
	private JTextField dateText;
	
	public StudentSignFrame(Object userObject,JDesktopPane desktopPane) {
		student=(S_student) userObject;
		attendanceDao=new SattendanceDaoImpl();
		courseDao=new ScourseDaoImpl();
		JInternalFrame internalFrame = new JInternalFrame("\u5B66\u751F\u7B7E\u5230");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame
				.setFrameIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7B7E\u5230.png")));
		internalFrame.setBounds(14, 13, 987, 661);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);
		
		JLabel label_6 = new JLabel("\u8BFE\u7A0B\u540D\u5B57\uFF1A");
		label_6.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u65B0\u4EBA\u8BFE\u7A0B.png")));
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("宋体", Font.BOLD, 25));
		label_6.setBounds(166, 44, 154, 44);
		internalFrame.getContentPane().add(label_6);
		
		courseNames=Tools.getcourseNames(new SselectedCourseDaoImpl().findAll(student.getName()));
		courseUpComboBox = new JComboBox<String>(courseNames);
		courseUpComboBox.setForeground(Color.BLUE);
		courseUpComboBox.setFont(new Font("宋体", Font.BOLD, 22));
		courseUpComboBox.setBounds(311, 49, 200, 40);
		internalFrame.getContentPane().add(courseUpComboBox);
		
		JButton yesButton = new JButton("\u786E\u8BA4\u7B7E\u5230");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		yesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		yesButton.setForeground(Color.BLUE);
		yesButton.setFont(new Font("宋体", Font.BOLD, 25));
		yesButton.setBounds(587, 43, 158, 50);
		internalFrame.getContentPane().add(yesButton);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u540D\u5B57\uFF1A");
		label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u65B0\u4EBA\u8BFE\u7A0B.png")));
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("宋体", Font.BOLD, 25));
		label_1.setBounds(52, 128, 154, 44);
		internalFrame.getContentPane().add(label_1);
		
		JLabel label = new JLabel("\u65E5\u671F\uFF1A");
		label.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u65E5\u671F.png")));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 25));
		label.setBounds(452, 128, 110, 44);
		internalFrame.getContentPane().add(label);
		
		courseDownComboBox = new JComboBox<String>(courseNames);
		courseDownComboBox.setForeground(Color.BLUE);
		courseDownComboBox.setFont(new Font("宋体", Font.BOLD, 22));
		courseDownComboBox.setBounds(196, 135, 200, 40);
		internalFrame.getContentPane().add(courseDownComboBox);
		
		Chooser chooser = Chooser.getInstance();
		dateText = new JTextField();
		chooser.register(dateText);
		dateText.setForeground(Color.BLUE);
		dateText.setFont(new Font("宋体", Font.BOLD, 22));
		dateText.setColumns(10);
		dateText.setBounds(540, 135, 200, 40);
		internalFrame.getContentPane().add(dateText);
		

		JButton findButton = new JButton("\u67E5 \u8BE2");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select();
			}
		});
		findButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u641C\u7D22.png")));
		findButton.setForeground(Color.BLUE);
		findButton.setFont(new Font("宋体", Font.BOLD, 25));
		findButton.setBounds(759, 130, 158, 50);
		internalFrame.getContentPane().add(findButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 197, 865, 396);
		internalFrame.getContentPane().add(scrollPane);

		studentSignData=attendanceDao.findAll(null,null,student.getName());
		studentSignTable = new JTable(new StudentSignTableModel(studentSignData));
		studentSignTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		studentSignTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		studentSignTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		studentSignTable.setRowHeight(51);
		scrollPane.setViewportView(studentSignTable);
		
		ListSelectionModel rowSelectionModel = studentSignTable.getSelectionModel();
		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 只处理鼠标释放
				if (e.getValueIsAdjusting()) {
					return;
				}
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				studentSignSelectedRow = lsm.getMinSelectionIndex();
				if (studentSignSelectedRow < 0) {
					return;
				}
				
				
			}
		});
	}

	private void select() {
		String cname=(String) courseDownComboBox.getSelectedItem();
		String date=Tools.isEmpty(dateText.getText());
		if (cname.equals("-请选择-")&&date.equals("")) {
			studentSignData=attendanceDao.findAll(null,null,student.getName());
			studentSignTable.setModel(new StudentSignTableModel(studentSignData));
			courseDownComboBox.setSelectedIndex(0);
			dateText.setText("");
		}else if (!cname.equals("-请选择-")&&date.equals("")) {
			studentSignData=attendanceDao.findAll(cname,null,student.getName());
			studentSignTable.setModel(new StudentSignTableModel(studentSignData));
			courseDownComboBox.setSelectedIndex(0);
			dateText.setText("");
		}else if (cname.equals("-请选择-")&&!date.equals("")) {
			studentSignData=attendanceDao.findAll(null,date,student.getName());
			studentSignTable.setModel(new StudentSignTableModel(studentSignData));
			courseDownComboBox.setSelectedIndex(0);
			dateText.setText("");
		}else {
			studentSignData=attendanceDao.findAll(cname,date,student.getName());
			studentSignTable.setModel(new StudentSignTableModel(studentSignData));
			courseDownComboBox.setSelectedIndex(0);
			dateText.setText("");
		}
	}

	private void add() {
		String cname=(String) courseUpComboBox.getSelectedItem();
		if (!cname.equals("-请选择-")) {
			if (attendanceDao.findAll(cname,Tools.dateToString(new Date()),student.getName()).size()==0) {
				int cid=courseDao.findAll(cname,0).get(0).getId();
				if (attendanceDao.create(student.getId(),cid,Tools.dateToString(new Date()))>0) {
					JOptionPane.showMessageDialog(null,Tools.getLable("签到成功！"));
					studentSignData=attendanceDao.findAll(null,null,student.getName());
					studentSignTable.setModel(new StudentSignTableModel(studentSignData));
					courseUpComboBox.setSelectedIndex(0);
				}else {
					JOptionPane.showMessageDialog(null,Tools.getLable("签到失败,未知错误"));
				}
			}else {
				JOptionPane.showMessageDialog(null,Tools.getLable("你以签到,请勿重复签到！"));
			}
		}else {
			JOptionPane.showMessageDialog(null,Tools.getLable("请先选择一门你要签到的课程名称"));
		}
	}
}
