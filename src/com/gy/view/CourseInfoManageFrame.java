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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.gy.bean.S_course;
import com.gy.bean.S_teacher;
import com.gy.dao.ScourseDao;
import com.gy.dao.SteacherDao;
import com.gy.dao.impl.ScourseDaoImpl;
import com.gy.dao.impl.SteacherDaoImpl;
import com.gy.talemodel.CourseTableModel;
import com.gy.tools.Tools;

public class CourseInfoManageFrame {
	private String userType;
	private ScourseDao courseDao;
	private SteacherDao teacherDao;
	private S_teacher teacher;
	private String[] teacherNames;
	private JComboBox<String> teacherNameUpComboBox;
	private JComboBox<String> teacherNameDownComboBox;
	private JTextArea courseInfoTextArea;
	private JTable courseTable;
	private int courseSelectedRow = -1;
	private JTextField courseNameUpText;
	private List<S_course> courseData;
	private JTextField courseNameDownText;
	private JTextField studentNumberText;

	public CourseInfoManageFrame(String userType, Object userObject, JDesktopPane desktopPane) {
		this.userType = userType;
		courseDao = new ScourseDaoImpl();
		teacherDao = new SteacherDaoImpl();
		JInternalFrame internalFrame = new JInternalFrame("\u8BFE\u7A0B\u4FE1\u606F\u7BA1\u7406");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame
				.setFrameIcon(new ImageIcon(CourseInfoManageFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		internalFrame.setBounds(14, 13, 987, 661);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u540D\u5B57\uFF1A");
		label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		label_1.setFont(new Font("宋体", Font.BOLD, 25));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(52, 25, 154, 44);
		internalFrame.getContentPane().add(label_1);

		courseNameUpText = new JTextField();
		courseNameUpText.setForeground(Color.BLUE);
		courseNameUpText.setFont(new Font("宋体", Font.BOLD, 25));
		courseNameUpText.setBounds(195, 29, 180, 40);
		internalFrame.getContentPane().add(courseNameUpText);
		courseNameUpText.setColumns(10);

		JLabel label_6 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
		label_6.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("宋体", Font.BOLD, 25));
		label_6.setBounds(390, 25, 154, 44);
		internalFrame.getContentPane().add(label_6);

		teacherNameUpComboBox = new JComboBox<String>();
		teacherNameUpComboBox.setForeground(Color.BLUE);
		teacherNameUpComboBox.setFont(new Font("宋体", Font.BOLD, 25));
		teacherNameUpComboBox.setBounds(535, 29, 180, 40);
		internalFrame.getContentPane().add(teacherNameUpComboBox);

		JButton findButton = new JButton("\u67E5\u8BE2");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select();
			}
		});
		findButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u641C\u7D22.png")));
		findButton.setForeground(Color.BLUE);
		findButton.setFont(new Font("宋体", Font.BOLD, 25));
		findButton.setBounds(760, 25, 130, 50);
		internalFrame.getContentPane().add(findButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 88, 839, 336);
		internalFrame.getContentPane().add(scrollPane);

		courseTable = new JTable();
		courseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		courseTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		courseTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		courseTable.setRowHeight(51);
		scrollPane.setViewportView(courseTable);

		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u540D\u5B57\uFF1A");
		label_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 25));
		label_2.setBounds(52, 437, 154, 44);
		internalFrame.getContentPane().add(label_2);

		JLabel label_5 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
		label_5.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("宋体", Font.BOLD, 25));
		label_5.setBounds(412, 437, 154, 44);
		internalFrame.getContentPane().add(label_5);

		JLabel label = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD\uFF1A");
		label.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B\u5217\u8868.png")));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 25));
		label.setBounds(412, 490, 154, 44);
		internalFrame.getContentPane().add(label);

		JLabel label_3 = new JLabel("\u5B66\u751F\u4EBA\u6570\uFF1A");
		label_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u4EBA\u6570.png")));
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 25));
		label_3.setBounds(52, 490, 154, 44);
		internalFrame.getContentPane().add(label_3);

		teacherNameDownComboBox = new JComboBox<String>();
		teacherNameDownComboBox.setForeground(Color.BLUE);
		teacherNameDownComboBox.setFont(new Font("宋体", Font.BOLD, 25));
		teacherNameDownComboBox.setBounds(559, 439, 180, 40);
		internalFrame.getContentPane().add(teacherNameDownComboBox);

		courseNameDownText = new JTextField();
		courseNameDownText.setForeground(Color.BLUE);
		courseNameDownText.setFont(new Font("宋体", Font.BOLD, 25));
		courseNameDownText.setColumns(10);
		courseNameDownText.setBounds(192, 439, 180, 40);
		internalFrame.getContentPane().add(courseNameDownText);

		studentNumberText = new JTextField();
		studentNumberText.setForeground(Color.BLUE);
		studentNumberText.setFont(new Font("宋体", Font.BOLD, 25));
		studentNumberText.setColumns(10);
		studentNumberText.setBounds(192, 494, 180, 40);
		internalFrame.getContentPane().add(studentNumberText);

		courseInfoTextArea = new JTextArea();
		courseInfoTextArea.setLineWrap(true);
		courseInfoTextArea.setForeground(Color.BLUE);
		courseInfoTextArea.setFont(new Font("Monospaced", Font.BOLD, 22));
		courseInfoTextArea.setBounds(559, 490, 342, 110);
		internalFrame.getContentPane().add(courseInfoTextArea);

		JButton yesButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify();
			}
		});
		yesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		yesButton.setFont(new Font("宋体", Font.BOLD, 25));
		yesButton.setForeground(Color.BLUE);
		yesButton.setBounds(125, 549, 158, 50);
		internalFrame.getContentPane().add(yesButton);

		JButton removeButton = new JButton("\u5220\u9664\u4FE1\u606F");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
			}
		});
		removeButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5220\u9664.png")));
		removeButton.setForeground(Color.BLUE);
		removeButton.setFont(new Font("宋体", Font.BOLD, 25));
		removeButton.setBounds(348, 549, 158, 50);
		internalFrame.getContentPane().add(removeButton);

		ListSelectionModel rowSelectionModel = courseTable.getSelectionModel();
		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 只处理鼠标释放
				if (e.getValueIsAdjusting()) {
					return;
				}
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				courseSelectedRow = lsm.getMinSelectionIndex();
				if (courseSelectedRow < 0) {
					return;
				}
				S_course course = courseData.get(courseSelectedRow);
				courseNameDownText.setText(course.getName());
				studentNumberText.setText("" + course.getMax_student_num());
				teacherNameDownComboBox.setSelectedItem(course.getTeacherId().getName());
				courseInfoTextArea.setText(course.getInfo());
			}
		});

		if (userType.equals("教师")) {
			teacher = (S_teacher) userObject;
			courseData = courseDao.findAll(null, teacher.getId());
			courseTable.setModel(new CourseTableModel(courseData));
			teacherNameUpComboBox.addItem(teacher.getName());
			teacherNameDownComboBox.addItem(teacher.getName());
			teacherNameUpComboBox.setEnabled(false);
			teacherNameDownComboBox.setEnabled(false);
		} else {
			courseData = courseDao.findAll(null, 0);
			courseTable.setModel(new CourseTableModel(courseData));
			teacherNames = Tools.getTeacherNames(courseData);
			teacherNameUpComboBox.setModel(new DefaultComboBoxModel<String>(teacherNames));
			teacherNameDownComboBox.setModel(new DefaultComboBoxModel<String>(teacherNames));
		}
	}

	private void select() {
		String name = Tools.isEmpty(courseNameUpText.getText());
		String tName = (String) teacherNameUpComboBox.getSelectedItem();
		if (name.equals("") && tName.equals("-请选择-")) {
			courseData = courseDao.findAll(null, 0);
			courseTable.setModel(new CourseTableModel(courseData));
			resetting();
		} else if (!name.equals("") && tName.equals("-请选择-")) {
			courseData = courseDao.findAll(name, 0);
			courseTable.setModel(new CourseTableModel(courseData));
			resetting();
		} else if (name.equals("") && !tName.equals("-请选择-")) {
			courseData = courseDao.findAll(null, teacherDao.findAll(tName).get(0).getId());
			courseTable.setModel(new CourseTableModel(courseData));
			resetting();
		} else {
			courseData = courseDao.findAll(name, teacherDao.findAll(tName).get(0).getId());
			courseTable.setModel(new CourseTableModel(courseData));
			resetting();
		}
	}

	private void resetting() {
		courseNameDownText.setText("");
		studentNumberText.setText("");
		teacherNameDownComboBox.setSelectedIndex(0);
		courseInfoTextArea.setText("");
	}

	private void remove() {
		if (courseSelectedRow != -1) {
			if (JOptionPane.showConfirmDialog(null, Tools.getLable("是否确定要删除该课程？"), "删除课程",
					JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				if (courseDao.remove(courseData.get(courseSelectedRow).getId()) > 0) {
					JOptionPane.showMessageDialog(null, Tools.getLable("删除成功"));
					if (userType.equals("教师")) {
						courseData = courseDao.findAll(null, teacher.getId());
					} else {
						courseData = courseDao.findAll(null, 0);
					}
					courseTable.setModel(new CourseTableModel(courseData));
					resetting();
				} else {
					JOptionPane.showMessageDialog(null, Tools.getLable("删除失败,未知错误"));
				}
			} else {
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, Tools.getLable("请先选择一个你要删除的课程"));
		}
	}

	private void modify() {
		if (courseSelectedRow != -1) {
			if (JOptionPane.showConfirmDialog(null, Tools.getLable("是否确定要删除该课程？"), "删除课程",
					JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				boolean nameFlag = Tools.isName(courseNameDownText.getText());
				if (nameFlag) {
					String name = Tools.isEmpty(courseNameDownText.getText());
					String tName = (String) teacherNameDownComboBox.getSelectedItem();
					if (!tName.equals("-请选择-")) {
						S_course course = courseData.get(courseSelectedRow);
						if (name.equals(course.getName()) && course.getTeacherId().getName().equals(tName)) {
							boolean numberFlag = Tools.isNumber(studentNumberText.getText());
							if (numberFlag) {
								int number = Integer.parseInt(Tools.isEmpty(studentNumberText.getText()));
								String info = courseInfoTextArea.getText();
								course.setMax_student_num(number);
								course.setInfo(info);
								if (courseDao.modify(course) > 0) {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改成功"));
									if (userType.equals("教师")) {
										courseData = courseDao.findAll(null,teacher.getId());
									}else {
										courseData = courseDao.findAll(null, 0);
									}
									courseTable.setModel(new CourseTableModel(courseData));
									resetting();
								} else {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,未知错误"));
								}
							} else {
								JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,学生人数不能为空或格式不正确"));
							}
						} else {
							if (courseDao.findAll(name, course.getTeacherId().getId()).size() == 0) {
								boolean numberFlag = Tools.isNumber(studentNumberText.getText());
								if (numberFlag) {
									int number = Integer.parseInt(Tools.isEmpty(studentNumberText.getText()));
									String info = courseInfoTextArea.getText();
									course.setName(name);
									course.setMax_student_num(number);
									teacher = teacherDao.findAll(tName).get(0);
									course.setTeacherId(teacher);
									course.setInfo(info);
									if (courseDao.modify(course) > 0) {
										JOptionPane.showMessageDialog(null, Tools.getLable("修改成功"));
										if (userType.equals("教师")) {
											courseData = courseDao.findAll(null,teacher.getId());
										}else {
											courseData = courseDao.findAll(null, 0);
										}
										courseTable.setModel(new CourseTableModel(courseData));
										resetting();
									} else {
										JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,未知错误"));
									}
								} else {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,学生人数不能为空或格式不正确"));
								}
							} else {
								JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,该教师已授该课"));
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, Tools.getLable("请先选择一名授课老师"));
					}
				} else {
					JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,课程名称不能为空或课程名称中包含了数字,请输入正确格式的课程名称"));
				}
			}else {
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, Tools.getLable("请先选择一个你要修改的课程"));
		}
	}
}
