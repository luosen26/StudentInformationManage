package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.gy.bean.S_attendance;
import com.gy.dao.SattendanceDao;
import com.gy.dao.ScourseDao;
import com.gy.dao.SselectedCourseDao;
import com.gy.dao.SstudentDao;
import com.gy.dao.impl.SattendanceDaoImpl;
import com.gy.dao.impl.ScourseDaoImpl;
import com.gy.dao.impl.SselectedCourseDaoImpl;
import com.gy.dao.impl.SstudentDaoImpl;
import com.gy.talemodel.StudentSignTableModel;
import com.gy.tools.Tools;

public class SignManageFrame {
	private SattendanceDao attendanceDao;
	private SselectedCourseDao selectedCourseDao;
	private SstudentDao studentDao;
	private ScourseDao courseDao;
	private String[] courseNames;
	private String[] studentNames;
	private JTable signManageTable;
	private int signManageSelectedRow = -1;
	private List<S_attendance> signManageData;
	private JComboBox<String> studentNameComboBox;
	private JComboBox<String> courseComboBox;

	public SignManageFrame(JDesktopPane desktopPane) {
		studentDao=new SstudentDaoImpl();
		courseDao=new ScourseDaoImpl();
		attendanceDao = new SattendanceDaoImpl();
		selectedCourseDao=new SselectedCourseDaoImpl();
		JInternalFrame internalFrame = new JInternalFrame("\u7B7E\u5230\u8003\u52E4\u7BA1\u7406");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame.setFrameIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		internalFrame.setBounds(14, 13, 987, 661);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		JLabel label_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		label_1.setFont(new Font("宋体", Font.BOLD, 25));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(52, 25, 154, 44);
		internalFrame.getContentPane().add(label_1);

		JLabel label_6 = new JLabel("\u8BFE\u7A0B\u540D\u5B57\uFF1A");
		label_6.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u65B0\u4EBA\u8BFE\u7A0B.png")));
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("宋体", Font.BOLD, 25));
		label_6.setBounds(390, 25, 154, 44);
		internalFrame.getContentPane().add(label_6);
		
		studentNames = Tools.getStudentNames(studentDao.findAll(null,0));
		studentNameComboBox = new JComboBox<String>(studentNames);
		studentNameComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sname=(String) studentNameComboBox.getSelectedItem();
				if (!sname.equals("-请选择-")) {
					courseNames = Tools.getcourseNames(selectedCourseDao.findAll(sname));
					courseComboBox.setModel(new DefaultComboBoxModel<String>(courseNames));
				}else {
					courseNames = Tools.getCourseNames(courseDao.findAll(null,0));
					courseComboBox.setModel(new DefaultComboBoxModel<String>(courseNames));
				}
			}
		});
		studentNameComboBox.setForeground(Color.BLUE);
		studentNameComboBox.setFont(new Font("宋体", Font.BOLD, 22));
		studentNameComboBox.setBounds(195, 29, 180, 40);
		internalFrame.getContentPane().add(studentNameComboBox);
		
		courseNames = Tools.getCourseNames(courseDao.findAll(null,0));
		courseComboBox = new JComboBox<String>(courseNames);
		courseComboBox.setForeground(Color.BLUE);
		courseComboBox.setFont(new Font("宋体", Font.BOLD, 22));
		courseComboBox.setBounds(535, 29, 200, 40);
		internalFrame.getContentPane().add(courseComboBox);

		JButton yesButton = new JButton("\u786E\u8BA4\u7B7E\u5230");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		yesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		yesButton.setForeground(Color.BLUE);
		yesButton.setFont(new Font("宋体", Font.BOLD, 25));
		yesButton.setBounds(760, 25, 158, 50);
		internalFrame.getContentPane().add(yesButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 88, 853, 445);
		internalFrame.getContentPane().add(scrollPane);

		signManageData = attendanceDao.findAll(null, null, null);
		signManageTable = new JTable(new StudentSignTableModel(signManageData));
		signManageTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		signManageTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		signManageTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		signManageTable.setRowHeight(51);
		scrollPane.setViewportView(signManageTable);

		JButton removeButton = new JButton("\u6DFB\u52A0\u7F3A\u52E4");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
			}
		});
		removeButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5220\u9664.png")));
		removeButton.setForeground(Color.BLUE);
		removeButton.setFont(new Font("宋体", Font.BOLD, 25));
		removeButton.setBounds(65, 546, 853, 50);
		internalFrame.getContentPane().add(removeButton);

		ListSelectionModel rowSelectionModel = signManageTable.getSelectionModel();
		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 只处理鼠标释放
				if (e.getValueIsAdjusting()) {
					return;
				}
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				signManageSelectedRow = lsm.getMinSelectionIndex();
				if (signManageSelectedRow < 0) {
					return;
				}
			}
		});

	}

	private void add() {
		String sname=(String) studentNameComboBox.getSelectedItem();
		if (!sname.equals("-请选择-")) {
			String cname=(String) courseComboBox.getSelectedItem();
			if (!cname.equals("-请选择-")) {
				if (attendanceDao.findAll(cname,Tools.dateToString(new Date()),sname).size()==0) {
					int sid=studentDao.findAll(sname,0).get(0).getId();
					int cid=courseDao.findAll(cname,0).get(0).getId();
					if (attendanceDao.create(sid,cid,Tools.dateToString(new Date()))>0) {
						JOptionPane.showMessageDialog(null,Tools.getLable("签到成功！"));
						signManageData=attendanceDao.findAll(null,null,null);
						signManageTable.setModel(new StudentSignTableModel(signManageData));
						studentNameComboBox.setSelectedIndex(0);
					}else {
						JOptionPane.showMessageDialog(null,Tools.getLable("签到失败,未知错误"));
					}
				}else {
					JOptionPane.showMessageDialog(null,Tools.getLable("你以签到,请勿重复签到！"));
				}
			}else {
				JOptionPane.showMessageDialog(null,Tools.getLable("签到失败，请选择一门你要签到的课程"));
			}
		}else {
			JOptionPane.showMessageDialog(null,Tools.getLable("签到失败，请先选择一名要签到的学生"));
		}
	}

	private void remove() {
		if (signManageSelectedRow!=-1) {
			if (JOptionPane.showConfirmDialog(null, Tools.getLable("是否确定要添加缺席？"), "添加缺席",
					JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				if (attendanceDao.remove(signManageData.get(signManageSelectedRow).getId())>0) {
					JOptionPane.showMessageDialog(null, Tools.getLable("添加成功"));
					signManageData=attendanceDao.findAll(null,null,null);
					signManageTable.setModel(new StudentSignTableModel(signManageData));
				}else {
					JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,未知错误"));
				}
			}else {
				return;
			}
		}else {
			JOptionPane.showMessageDialog(null,Tools.getLable("请先选择一条你添加缺席的签到记录"));
		}
	}
}
