package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.gy.bean.S_student;
import com.gy.dao.SclassDao;
import com.gy.dao.SstudentDao;
import com.gy.dao.impl.SclassDaoImpl;
import com.gy.dao.impl.SstudentDaoImpl;
import com.gy.talemodel.StudentTableModel;
import com.gy.tools.Tools;

public class StudentInfoManageFrame {
	private String userType;
	private JTextField studentNameUpText;
	private String[] classNames;
	private S_student student;
	private List<S_student> studentData;
	private SstudentDao studentDao;
	private SclassDao classDao;
	private JTable studentTable;
	private JComboBox<String> classUpComboBox;
	private JComboBox<String> classDownComboBox;
	private JRadioButton manRadioButton;
	private JRadioButton girlRadioButton;
	private JRadioButton noSexRadioButton;
	private JTextField studentNameDownText;
	private JTextField passwordText;
	private int studentSelectedRow = -1;
	private String sex;

	public StudentInfoManageFrame(String userType,Object userObject,JDesktopPane desktopPane) {
		this.userType = userType;
		studentDao = new SstudentDaoImpl();
		classDao = new SclassDaoImpl();
		sex = "保密";
		JInternalFrame internalFrame = new JInternalFrame("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame.setFrameIcon(
				new ImageIcon(StudentInfoManageFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		internalFrame.setBounds(14, 24, 991, 612);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		JLabel label_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		label_1.setFont(new Font("宋体", Font.BOLD, 25));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(52, 25, 154, 44);
		internalFrame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 25));
		label_2.setBounds(52, 500, 154, 44);
		internalFrame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5BC6\u7801.png")));
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 25));
		label_3.setBounds(397, 500, 154, 44);
		internalFrame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		label_4.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u6027\u522B.png")));
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("宋体", Font.BOLD, 25));
		label_4.setBounds(397, 445, 154, 44);
		internalFrame.getContentPane().add(label_4);

		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 25));
		label.setBounds(52, 437, 154, 44);
		internalFrame.getContentPane().add(label);

		JLabel label_5 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_5.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("宋体", Font.BOLD, 25));
		label_5.setBounds(390, 25, 154, 44);
		internalFrame.getContentPane().add(label_5);

		studentNameUpText = new JTextField();
		studentNameUpText.setFont(new Font("宋体", Font.BOLD, 25));
		studentNameUpText.setBounds(195, 29, 180, 40);
		internalFrame.getContentPane().add(studentNameUpText);
		studentNameUpText.setColumns(10);

		classUpComboBox = new JComboBox<String>();
		classUpComboBox.setForeground(Color.BLUE);
		classUpComboBox.setFont(new Font("宋体", Font.BOLD, 22));
		classUpComboBox.setBounds(535, 29, 180, 40);
		internalFrame.getContentPane().add(classUpComboBox);

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

		studentTable = new JTable();
		studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		studentTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		studentTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		studentTable.setRowHeight(51);
		scrollPane.setViewportView(studentTable);

		studentNameDownText = new JTextField();
		studentNameDownText.setFont(new Font("宋体", Font.BOLD, 25));
		studentNameDownText.setColumns(10);
		studentNameDownText.setBounds(195, 440, 180, 40);
		internalFrame.getContentPane().add(studentNameDownText);

		classDownComboBox = new JComboBox<String>();
		classDownComboBox.setForeground(Color.BLUE);
		classDownComboBox.setFont(new Font("宋体", Font.BOLD, 22));
		classDownComboBox.setBounds(195, 506, 180, 40);
		internalFrame.getContentPane().add(classDownComboBox);

		manRadioButton = new JRadioButton("\u7537");
		manRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "男";
			}
		});
		manRadioButton.setFont(new Font("宋体", Font.BOLD, 25));
		manRadioButton.setForeground(Color.BLUE);
		manRadioButton.setBounds(540, 454, 59, 27);
		internalFrame.getContentPane().add(manRadioButton);

		girlRadioButton = new JRadioButton("\u5973");
		girlRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "女";
			}
		});
		girlRadioButton.setForeground(Color.BLUE);
		girlRadioButton.setFont(new Font("宋体", Font.BOLD, 25));
		girlRadioButton.setBounds(600, 454, 57, 27);
		internalFrame.getContentPane().add(girlRadioButton);

		noSexRadioButton = new JRadioButton("\u4FDD\u5BC6");
		noSexRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "保密";
			}
		});
		noSexRadioButton.setSelected(true);
		noSexRadioButton.setForeground(Color.BLUE);
		noSexRadioButton.setFont(new Font("宋体", Font.BOLD, 25));
		noSexRadioButton.setBounds(660, 454, 81, 27);
		internalFrame.getContentPane().add(noSexRadioButton);

		ButtonGroup bg = new ButtonGroup();
		bg.add(manRadioButton);
		bg.add(girlRadioButton);
		bg.add(noSexRadioButton);

		passwordText = new JTextField();
		passwordText.setFont(new Font("宋体", Font.BOLD, 25));
		passwordText.setColumns(10);
		passwordText.setBounds(540, 506, 195, 40);
		internalFrame.getContentPane().add(passwordText);

		JButton yesButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify();
			}
		});
		yesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		yesButton.setFont(new Font("宋体", Font.BOLD, 25));
		yesButton.setForeground(Color.BLUE);
		yesButton.setBounds(750, 434, 158, 50);
		internalFrame.getContentPane().add(yesButton);

		JButton removeButton = new JButton("\u5220\u9664\u5B66\u751F");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
			}
		});
		removeButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5220\u9664.png")));
		removeButton.setForeground(Color.BLUE);
		removeButton.setFont(new Font("宋体", Font.BOLD, 25));
		removeButton.setBounds(750, 497, 158, 50);
		internalFrame.getContentPane().add(removeButton);

		ListSelectionModel rowSelectionModel = studentTable.getSelectionModel();
		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 只处理鼠标释放
				if (e.getValueIsAdjusting()) {
					return;
				}
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				studentSelectedRow = lsm.getMinSelectionIndex();
				if (studentSelectedRow < 0) {
					return;
				}
				S_student student = studentData.get(studentSelectedRow);
				studentNameDownText.setText(student.getName());
				classDownComboBox.setSelectedItem(student.getClassId().getName());
				if (student.getSex().equals("男")) {
					manRadioButton.setSelected(true);
				} else if (student.getSex().equals("女")) {
					girlRadioButton.setSelected(true);
				} else {
					noSexRadioButton.setSelected(true);
				}
				passwordText.setText(student.getPassword());
			}
		});

		if (userType.equals("学生")) {
			student = (S_student) userObject;
			studentData = new ArrayList<S_student>();
			studentData.add(student);
			studentTable.setModel(new StudentTableModel(studentData));
			studentNameUpText.setText(student.getName());
			classUpComboBox.addItem(student.getClassId().getName());
			classDownComboBox.addItem(student.getClassId().getName());
			studentNameUpText.setEditable(false);
			classUpComboBox.setEnabled(false);
			classDownComboBox.setEnabled(false);
			findButton.setEnabled(false);
			removeButton.setEnabled(false);
		} else {
			studentData = studentDao.findAll(null, 0);
			studentTable.setModel(new StudentTableModel(studentData));
			classNames = Tools.getClassNames(classDao.findAll(null));
			classUpComboBox.setModel(new DefaultComboBoxModel<String>(classNames));
			classDownComboBox.setModel(new DefaultComboBoxModel<String>(classNames));
		}
	}

	private void select() {
		String name = Tools.isEmpty(studentNameUpText.getText());
		String className = (String) classUpComboBox.getSelectedItem();
		if (name.equals("") && className.equals("-请选择-")) {
			studentData = studentDao.findAll(null, 0);
			studentTable.setModel(new StudentTableModel(studentData));
			resetting();
		} else if (!name.equals("") && className.equals("-请选择-")) {
			studentData = studentDao.findAll(name, 0);
			studentTable.setModel(new StudentTableModel(studentData));
			resetting();
		} else if (name.equals("") && !className.equals("-请选择-")) {
			studentData = studentDao.findAll(null, classDao.findByName(className).getId());
			studentTable.setModel(new StudentTableModel(studentData));
			resetting();
		} else {
			studentData = studentDao.findAll(name, classDao.findByName(className).getId());
			studentTable.setModel(new StudentTableModel(studentData));
			resetting();
		}
	}

	private void modify() {
		if (studentSelectedRow != -1) {
			boolean nameFlag = Tools.isName(studentNameDownText.getText());
			if (nameFlag) {
				String name = Tools.isEmpty(studentNameDownText.getText());
				String className = (String) classDownComboBox.getSelectedItem();
				if (!className.equals("-请选择-")) {
					boolean PWFlag = Tools.isPassword(new String(passwordText.getText()));
					if (PWFlag) {
						if (JOptionPane.showConfirmDialog(null, Tools.getLable("是否确定要修改该学生的信息？"), "修改学生的信息",
								JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
							String password = new String(passwordText.getText());
							student = studentData.get(studentSelectedRow);
							student.setName(name);
							student.setPassword(password);
							student.setSex(sex);
							if (userType.equals("学生")) {
								if (studentDao.modify(student) > 0) {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改成功"));
									studentData.set(0, student);
									studentTable.setModel(new StudentTableModel(studentData));
									resetting();
								} else {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,未知错误"));
								}
							} else {
								student.setClassId(classDao.findByName(className));
								if (studentDao.modify(student) > 0) {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改成功"));
									studentData = studentDao.findAll(null, 0);
									studentTable.setModel(new StudentTableModel(studentData));
									resetting();
								} else {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,未知错误"));
								}
							}
						} else {
							return;
						}
					} else {
						JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,登录密码不能为空或登录密码格式不正确，登录密码必须是数字或大小写字母"));
					}
				} else {
					JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,请选择一个班级"));
				}
			} else {
				JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,学生姓名不能为空或学生姓名中包含了数字,请输入正确格式的学生姓名"));
			}
		} else {
			JOptionPane.showMessageDialog(null, Tools.getLable("请先选择一名你要修改的学生"));
		}
	}

	private void remove() {
		if (studentSelectedRow != -1) {
			if (JOptionPane.showConfirmDialog(null, Tools.getLable("是否确定要删除该学生？"), "删除学生",
					JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				if (studentDao.remove(studentData.get(studentSelectedRow).getId()) > 0) {
					JOptionPane.showMessageDialog(null, Tools.getLable("删除成功"));
					studentData = studentDao.findAll(null, 0);
					studentTable.setModel(new StudentTableModel(studentData));
					resetting();
				} else {
					JOptionPane.showMessageDialog(null, Tools.getLable("删除失败,未知错误"));
				}
			} else {
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, Tools.getLable("请先选择一名你要删除的学生"));
		}
	}
	
	private void resetting() {
		studentNameDownText.setText("");
		classDownComboBox.setSelectedIndex(0);
		noSexRadioButton.setSelected(true);
		passwordText.setText("");
	}
}
