package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.gy.bean.S_selected_course;
import com.gy.bean.S_student;
import com.gy.dao.ScourseDao;
import com.gy.dao.SselectedCourseDao;
import com.gy.dao.SstudentDao;
import com.gy.dao.impl.ScourseDaoImpl;
import com.gy.dao.impl.SselectedCourseDaoImpl;
import com.gy.dao.impl.SstudentDaoImpl;
import com.gy.talemodel.SelectCourseTableModel;
import com.gy.tools.Tools;

public class ChooseCourseManageFrame {
	private String userType;
	private ScourseDao courseDao;
	private SstudentDao studentDao;
	private S_student student;
	private String[] courseNames;
	private String[] studentNames;
	private SselectedCourseDao selectedCourseDao;
	private JComboBox<String> studentNameUpComboBox;
	private JComboBox<String> studentNameDownComboBox;
	private JComboBox<String> courseUpComboBox;
	private JComboBox<String> courseDwonComboBox;
	private JTable chooseCourseTable;
	private int selectCourseSelectedRow = -1;
	private List<S_selected_course> selectCourseData;

	public ChooseCourseManageFrame(String userType,Object userObject, JDesktopPane desktopPane) {
		this.userType=userType;
		courseDao = new ScourseDaoImpl();
		studentDao=new SstudentDaoImpl();
		selectedCourseDao=new SselectedCourseDaoImpl();
		JInternalFrame internalFrame = new JInternalFrame("\u9009\u8BFE\u7BA1\u7406");
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

		studentNameUpComboBox = new JComboBox<String>();
		studentNameUpComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sName=(String) studentNameUpComboBox.getSelectedItem();
				if (!sName.equals("-请选择-")) {
					student=studentDao.findAll(sName,0).get(0);
					courseNames=Tools.getCourseNames(courseDao.findById(student.getId()));
					courseUpComboBox.setModel(new DefaultComboBoxModel<String>(courseNames));
				}else {
					courseUpComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"-请选择-"}));
				}
			}
		});
		studentNameUpComboBox.setForeground(Color.BLUE);
		studentNameUpComboBox.setFont(new Font("宋体", Font.BOLD, 22));
		studentNameUpComboBox.setBounds(195, 29, 180, 40);
		internalFrame.getContentPane().add(studentNameUpComboBox);
		
		courseUpComboBox = new JComboBox<String>();
		courseUpComboBox.setForeground(Color.BLUE);
		courseUpComboBox.setFont(new Font("宋体", Font.BOLD, 22));
		courseUpComboBox.setBounds(535, 29, 200, 40);
		internalFrame.getContentPane().add(courseUpComboBox);

		JButton selectCourseButton = new JButton("\u786E\u8BA4\u9009\u8BFE");
		selectCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecteCourse();
			}
		});
		selectCourseButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		selectCourseButton.setForeground(Color.BLUE);
		selectCourseButton.setFont(new Font("宋体", Font.BOLD, 25));
		selectCourseButton.setBounds(760, 25, 158, 50);
		internalFrame.getContentPane().add(selectCourseButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 88, 843, 389);
		internalFrame.getContentPane().add(scrollPane);

		chooseCourseTable = new JTable();
		chooseCourseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		chooseCourseTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		chooseCourseTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		chooseCourseTable.setRowHeight(51);
		scrollPane.setViewportView(chooseCourseTable);

		JLabel label_2 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 25));
		label_2.setBounds(125, 490, 154, 44);
		internalFrame.getContentPane().add(label_2);

		JLabel label_5 = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		label_5.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u65B0\u4EBA\u8BFE\u7A0B.png")));
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("宋体", Font.BOLD, 25));
		label_5.setBounds(548, 490, 154, 44);
		internalFrame.getContentPane().add(label_5);

		studentNameDownComboBox = new JComboBox<String>();
		studentNameDownComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sName=(String) studentNameDownComboBox.getSelectedItem();
				if (!sName.equals("-请选择-")) {
					student=studentDao.findAll(sName,0).get(0);
					courseNames=Tools.getCourseNames(courseDao.findById(student.getId()));
					courseDwonComboBox.setModel(new DefaultComboBoxModel<String>(courseNames));
				}else {
					courseDwonComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"-请选择-"}));
				}
			}
		});
		studentNameDownComboBox.setForeground(Color.BLUE);
		studentNameDownComboBox.setFont(new Font("宋体", Font.BOLD, 22));
		studentNameDownComboBox.setBounds(271, 494, 180, 40);
		internalFrame.getContentPane().add(studentNameDownComboBox);

		courseDwonComboBox = new JComboBox<String>();
		courseDwonComboBox.setForeground(Color.BLUE);
		courseDwonComboBox.setFont(new Font("宋体", Font.BOLD, 22));
		courseDwonComboBox.setBounds(700, 492, 200, 40);
		internalFrame.getContentPane().add(courseDwonComboBox);

		JButton yesButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify();
			}
		});
		yesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		yesButton.setFont(new Font("宋体", Font.BOLD, 25));
		yesButton.setForeground(Color.BLUE);
		yesButton.setBounds(217, 547, 158, 50);
		internalFrame.getContentPane().add(yesButton);

		JButton removeButton = new JButton("\u9000\u9009\u8BFE\u7A0B");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
			}
		});
		removeButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5220\u9664.png")));
		removeButton.setForeground(Color.BLUE);
		removeButton.setFont(new Font("宋体", Font.BOLD, 25));
		removeButton.setBounds(632, 547, 158, 50);
		internalFrame.getContentPane().add(removeButton);

		ListSelectionModel rowSelectionModel = chooseCourseTable.getSelectionModel();
		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 只处理鼠标释放
				if (e.getValueIsAdjusting()) {
					return;
				}
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				selectCourseSelectedRow = lsm.getMinSelectionIndex();
				if (selectCourseSelectedRow < 0) {
					return;
				}
				S_selected_course selected_course = selectCourseData.get(selectCourseSelectedRow);
				studentNameDownComboBox.setSelectedItem(selected_course.getStudentId().getName());
			}
		});
		
		if (userType.equals("学生")) {
			student=(S_student) userObject;
			studentNameUpComboBox.addItem(student.getName());
			studentNameDownComboBox.addItem(student.getName());
			selectCourseData = selectedCourseDao.findAll(student.getName());
			chooseCourseTable.setModel(new SelectCourseTableModel(selectCourseData));
			courseNames=Tools.getCourseNames(courseDao.findById(student.getId()));
			courseUpComboBox.setModel(new DefaultComboBoxModel<String>(courseNames));
			courseDwonComboBox.setModel(new DefaultComboBoxModel<String>(courseNames));
			studentNameUpComboBox.setEnabled(false);
			studentNameDownComboBox.setEnabled(false);
		}else {
			selectCourseData = selectedCourseDao.findAll(null);
			chooseCourseTable.setModel(new SelectCourseTableModel(selectCourseData));
			studentNames = Tools.getStudentNames(studentDao.findAll(null, 0));
			studentNameUpComboBox.setModel(new DefaultComboBoxModel<String>(studentNames));
			studentNameDownComboBox.setModel(new DefaultComboBoxModel<String>(studentNames));
			courseUpComboBox.addItem("-请选择-");
			courseDwonComboBox.addItem("-请选择-");
		}
	}

	private void selecteCourse() {
		String sName=(String) studentNameUpComboBox.getSelectedItem();
		if (!sName.equals("-请选择-")) {
			String cName=(String) courseUpComboBox.getSelectedItem();
			if (!cName.equals("-请选择-")) {
				int sid=studentDao.findAll(sName,0).get(0).getId();
				int cid=courseDao.findAll(cName,0).get(0).getId();
				if (selectedCourseDao.create(sid,cid)>0) {
					JOptionPane.showMessageDialog(null,Tools.getLable("选课成功"));
					studentNameUpComboBox.setSelectedIndex(0);
					if (userType.equals("学生")) {
						selectCourseData = selectedCourseDao.findAll(student.getName());
						chooseCourseTable.setModel(new SelectCourseTableModel(selectCourseData));
					}else {
						selectCourseData = selectedCourseDao.findAll(null);
						chooseCourseTable.setModel(new SelectCourseTableModel(selectCourseData));
					}
					studentNameDownComboBox.setSelectedIndex(0);
				}else {
					JOptionPane.showMessageDialog(null,Tools.getLable("选课失败，未知错误"));
				}
			}else {
				JOptionPane.showMessageDialog(null,Tools.getLable("请选择一门你要学的课程"));
			}
		}else {
			JOptionPane.showMessageDialog(null,Tools.getLable("请先选择一名学生"));
		}
	}

	private void remove() {
		if (selectCourseSelectedRow!=-1) {
			if (JOptionPane.showConfirmDialog(null, Tools.getLable("是否确定要退选该课程？"), "退选课程",
					JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				if (selectedCourseDao.remove(selectCourseData.get(selectCourseSelectedRow).getId())>0) {
					JOptionPane.showMessageDialog(null,Tools.getLable("退选课程成功"));
					if (userType.equals("学生")) {
						selectCourseData = selectedCourseDao.findAll(student.getName());
						chooseCourseTable.setModel(new SelectCourseTableModel(selectCourseData));
					}else {
						selectCourseData = selectedCourseDao.findAll(null);
						chooseCourseTable.setModel(new SelectCourseTableModel(selectCourseData));
					}
					studentNameDownComboBox.setSelectedIndex(0);
				}else {
					JOptionPane.showMessageDialog(null,Tools.getLable("退选课程失败，未知错误"));
				}
			}else {
				return;
			}
		}else {
			JOptionPane.showMessageDialog(null,Tools.getLable("请选择一门你要修改的课程"));
		}
	}

	private void modify() {
		if (selectCourseSelectedRow!=-1) {
			String sName=(String) studentNameDownComboBox.getSelectedItem();
			if (!sName.equals("-请选择-")) {
				String cName=(String) courseDwonComboBox.getSelectedItem();
				if (!cName.equals("-请选择-")) {
					if (JOptionPane.showConfirmDialog(null, Tools.getLable("是否确定要退选该课程？"), "退选课程",
							JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
						S_selected_course selected_course=selectCourseData.get(selectCourseSelectedRow);
						if (userType.equals("学生")) {
							int sid=student.getId();
							int cid=courseDao.findAll(cName,0).get(0).getId();
							int id=selected_course.getId();
							if (selectedCourseDao.modify(sid,cid,id)>0) {
								JOptionPane.showMessageDialog(null,Tools.getLable("修改成功"));
								selectCourseData = selectedCourseDao.findAll(student.getName());
								chooseCourseTable.setModel(new SelectCourseTableModel(selectCourseData));
							}else {
								JOptionPane.showMessageDialog(null,Tools.getLable("修改失败，未知错误"));
							}
						}else {
							int sid=studentDao.findAll(sName,0).get(0).getId();
							int cid=courseDao.findAll(cName,0).get(0).getId();
							int id=selected_course.getId();
							if (selectedCourseDao.modify(sid,cid,id)>0) {
								JOptionPane.showMessageDialog(null,Tools.getLable("修改成功，未知错误"));
								selectCourseData = selectedCourseDao.findAll(null);
								chooseCourseTable.setModel(new SelectCourseTableModel(selectCourseData));
							}else {
								JOptionPane.showMessageDialog(null,Tools.getLable("修改失败，未知错误"));
							}
						}
						studentNameDownComboBox.setSelectedIndex(0);
					}else {
						return;
					}
				}else {
					JOptionPane.showMessageDialog(null,Tools.getLable("请选择一门你要修改的课程"));
				}
			}else {
				JOptionPane.showMessageDialog(null,Tools.getLable("请先选择一名学生"));
			}
		}else {
			JOptionPane.showMessageDialog(null,Tools.getLable("请选择一门你要修改的课程"));
		}
	}
}
