package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.gy.bean.S_course;
import com.gy.bean.S_teacher;
import com.gy.dao.ScourseDao;
import com.gy.dao.SteacherDao;
import com.gy.dao.impl.ScourseDaoImpl;
import com.gy.dao.impl.SteacherDaoImpl;
import com.gy.tools.Tools;

import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class AddCourseFrame {
	private String userType;
	private S_teacher teacher;
	private ScourseDao courseDao;
	private SteacherDao teacherDao;
	private JTextField courseText;
	private JComboBox<String> teacherNameComboBox;
	private JTextField studentNumberText;
	private JTextArea classInfoTextArea;

	public AddCourseFrame(String userType,Object userObject,JDesktopPane desktopPane) {
		this.userType = userType;
		courseDao = new ScourseDaoImpl();
		teacherDao = new SteacherDaoImpl();

		JInternalFrame internalFrame = new JInternalFrame("\u6DFB\u52A0\u8BFE\u7A0B");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame.setFrameIcon(new ImageIcon(AddCourseFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		internalFrame.setBounds(210, 75, 678, 425);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		label_1.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		label_1.setFont(new Font("宋体", Font.BOLD, 25));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(85, 25, 154, 44);
		internalFrame.getContentPane().add(label_1);

		JLabel label_3 = new JLabel("\u5B66\u751F\u4EBA\u6570\uFF1A");
		label_3.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/com/gy/image/\u4EBA\u6570.png")));
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 25));
		label_3.setBounds(85, 139, 154, 44);
		internalFrame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
		label_4.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("宋体", Font.BOLD, 25));
		label_4.setBounds(85, 82, 154, 44);
		internalFrame.getContentPane().add(label_4);

		JLabel label = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD\uFF1A");
		label.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B\u5217\u8868.png")));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 25));
		label.setBounds(85, 193, 154, 44);
		internalFrame.getContentPane().add(label);

		courseText = new JTextField();
		courseText.setFont(new Font("宋体", Font.BOLD, 25));
		courseText.setBounds(231, 30, 240, 40);
		internalFrame.getContentPane().add(courseText);
		courseText.setColumns(10);

		teacherNameComboBox = new JComboBox<String>();
		teacherNameComboBox.setForeground(Color.BLUE);
		teacherNameComboBox.setFont(new Font("宋体", Font.BOLD, 25));
		teacherNameComboBox.setBounds(231, 86, 240, 40);
		internalFrame.getContentPane().add(teacherNameComboBox);

		studentNumberText = new JTextField();
		studentNumberText.setFont(new Font("宋体", Font.BOLD, 25));
		studentNumberText.setColumns(10);
		studentNumberText.setBounds(231, 143, 240, 40);
		internalFrame.getContentPane().add(studentNumberText);

		classInfoTextArea = new JTextArea();
		classInfoTextArea.setLineWrap(true);
		classInfoTextArea.setForeground(Color.BLUE);
		classInfoTextArea.setFont(new Font("Monospaced", Font.BOLD, 22));
		classInfoTextArea.setBounds(231, 196, 240, 108);
		internalFrame.getContentPane().add(classInfoTextArea);

		JButton yesButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		yesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		yesButton.setFont(new Font("宋体", Font.BOLD, 25));
		yesButton.setForeground(Color.BLUE);
		yesButton.setBounds(169, 320, 170, 50);
		internalFrame.getContentPane().add(yesButton);

		JButton resettingButton = new JButton("\u91CD\u7F6E\u4FE1\u606F");
		resettingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetting();
			}
		});
		resettingButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u91CD\u7F6E.png")));
		resettingButton.setForeground(Color.BLUE);
		resettingButton.setFont(new Font("宋体", Font.BOLD, 25));
		resettingButton.setBounds(371, 320, 170, 50);
		internalFrame.getContentPane().add(resettingButton);

		if (userType.equals("教师")) {
			teacher = (S_teacher) userObject;
			teacherNameComboBox.addItem(teacher.getName());
			teacherNameComboBox.setEnabled(false);
		} else {
			String[] teacherNames = Tools.getteacherNames(teacherDao.findAll(null));
			teacherNameComboBox.setModel(new DefaultComboBoxModel<String>(teacherNames));
		}
	}

	private void resetting() {
		courseText.setText("");
		teacherNameComboBox.setSelectedIndex(0);
		studentNumberText.setText("");
		classInfoTextArea.setText("");
	}

	private void add() {
		boolean nameFlag = Tools.isName(courseText.getText());
		if (nameFlag) {
			String name = Tools.isEmpty(courseText.getText());
			String teacherName = (String) teacherNameComboBox.getSelectedItem();
			if (!teacherName.equals("-请选择-")) {
				if (userType.equals("教师")) {
					if (courseDao.findAll(name,teacher.getId()).size()==0) {
						boolean numberFlage = Tools.isNumber(studentNumberText.getText());
						if (numberFlage) {
							String number = Tools.isEmpty(studentNumberText.getText());
							String info = classInfoTextArea.getText();
							if (courseDao.create(new S_course(name,teacher,Integer.parseInt(number),info,0)) > 0) {
								JOptionPane.showMessageDialog(null, Tools.getLable("添加成功"));
								resetting();
							} else {
								JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,未知错误"));
							}
						} else {
							JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,学生人数不能为空或格式不正确"));
						}
					} else {
						JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,该教师已授该课"));
					}
				}else {
					S_teacher tid=teacherDao.findAll(teacherName).get(0);
					if (courseDao.findAll(name,tid.getId()).size()==0) {
						boolean numberFlage = Tools.isNumber(studentNumberText.getText());
						if (numberFlage) {
							String number = Tools.isEmpty(studentNumberText.getText());
							String info= classInfoTextArea.getText();
							if (courseDao.create(new S_course(name,tid,Integer.parseInt(number),info,0)) > 0) {
								JOptionPane.showMessageDialog(null, Tools.getLable("添加成功"));
								resetting();
							} else {
								JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,未知错误"));
							}
						} else {
							JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,学生人数不能为空或格式不正确"));
						}
					} else {
						JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,该教师已授该课"));
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,请先选择一名授课老师"));
			}
		} else {
			JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,课程名字不能为空或含有数字"));
		}
	}
}
