package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.gy.bean.S_student;
import com.gy.dao.SclassDao;
import com.gy.dao.SstudentDao;
import com.gy.dao.impl.SclassDaoImpl;
import com.gy.dao.impl.SstudentDaoImpl;
import com.gy.tools.Tools;

public class AddStudentFrame {
	private SstudentDao studentDao;
	private SclassDao classDao;
	private JComboBox classComboBox;
	private String sex;
	private JTextField studentNameText;
	private JPasswordField passwordText;
	private JRadioButton noSexRadioButton;

	public AddStudentFrame(JDesktopPane desktopPane) {
		studentDao = new SstudentDaoImpl();
		classDao = new SclassDaoImpl();
		sex = "保密";
		JInternalFrame internalFrame = new JInternalFrame("\u6DFB\u52A0\u5B66\u751F");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame.setFrameIcon(
				new ImageIcon(AddStudentFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		internalFrame.setBounds(210, 75, 678, 425);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		JLabel label_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		label_1.setFont(new Font("宋体", Font.BOLD, 25));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(85, 25, 154, 44);
		internalFrame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 25));
		label_2.setBounds(85, 98, 154, 44);
		internalFrame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5BC6\u7801.png")));
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 25));
		label_3.setBounds(85, 171, 154, 44);
		internalFrame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		label_4.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u6027\u522B.png")));
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("宋体", Font.BOLD, 25));
		label_4.setBounds(85, 240, 154, 44);
		internalFrame.getContentPane().add(label_4);

		studentNameText = new JTextField();
		studentNameText.setFont(new Font("宋体", Font.BOLD, 25));
		studentNameText.setBounds(231, 30, 240, 40);
		internalFrame.getContentPane().add(studentNameText);
		studentNameText.setColumns(10);

		String[] classNames = Tools.getClassNames(classDao.findAll(null));
		classComboBox = new JComboBox(classNames);
		classComboBox.setFont(new Font("宋体", Font.BOLD, 25));
		classComboBox.setForeground(Color.BLUE);
		classComboBox.setBounds(231, 104, 240, 40);
		internalFrame.getContentPane().add(classComboBox);

		passwordText = new JPasswordField();
		passwordText.setFont(new Font("宋体", Font.BOLD, 25));
		passwordText.setBounds(231, 173, 240, 40);
		internalFrame.getContentPane().add(passwordText);

		JRadioButton manRadioButton = new JRadioButton("\u7537");
		manRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "男";
			}
		});
		manRadioButton.setFont(new Font("宋体", Font.BOLD, 25));
		manRadioButton.setForeground(Color.BLUE);
		manRadioButton.setBounds(234, 253, 68, 27);
		internalFrame.getContentPane().add(manRadioButton);

		JRadioButton girlRadioButton = new JRadioButton("\u5973");
		girlRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "女";
			}
		});
		girlRadioButton.setForeground(Color.BLUE);
		girlRadioButton.setFont(new Font("宋体", Font.BOLD, 25));
		girlRadioButton.setBounds(305, 253, 68, 27);
		internalFrame.getContentPane().add(girlRadioButton);

		noSexRadioButton = new JRadioButton("\u4FDD\u5BC6");
		noSexRadioButton.setSelected(true);
		noSexRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "保密";
			}
		});
		noSexRadioButton.setForeground(Color.BLUE);
		noSexRadioButton.setFont(new Font("宋体", Font.BOLD, 25));
		noSexRadioButton.setBounds(371, 253, 97, 27);
		internalFrame.getContentPane().add(noSexRadioButton);

		ButtonGroup bg = new ButtonGroup();
		bg.add(manRadioButton);
		bg.add(girlRadioButton);
		bg.add(noSexRadioButton);

		JButton yesButton = new JButton("\u786E \u8BA4");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		yesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		yesButton.setFont(new Font("宋体", Font.BOLD, 25));
		yesButton.setForeground(Color.BLUE);
		yesButton.setBounds(167, 307, 130, 50);
		internalFrame.getContentPane().add(yesButton);

		JButton resettingButton = new JButton("\u91CD \u7F6E");
		resettingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetting();
			}
		});
		resettingButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u91CD\u7F6E.png")));
		resettingButton.setForeground(Color.BLUE);
		resettingButton.setFont(new Font("宋体", Font.BOLD, 25));
		resettingButton.setBounds(371, 307, 130, 50);
		internalFrame.getContentPane().add(resettingButton);
	}

	private void add() {
		boolean nameFlag = Tools.isName(studentNameText.getText());
		if (nameFlag) {
			String name = Tools.isEmpty(studentNameText.getText());
			String className = (String) classComboBox.getSelectedItem();
			if (!className.equals("-请选择-")) {
				boolean PWFlag = Tools.isPassword(new String(passwordText.getPassword()));
				if (PWFlag) {
					String password = new String(passwordText.getPassword());
					if (studentDao.create(new S_student(name, classDao.findByName(className), password, sex)) > 0) {
						JOptionPane.showMessageDialog(null, Tools.getLable("添加成功"));
						resetting();
					} else {
						JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,未知错误"));
					}
				} else {
					JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,登录密码不能为空或登录密码格式不正确，登录密码必须是数字或大小写字母"));
				}
			} else {
				JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,请选择一个班级"));
			}
		} else {
			JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,姓名不能为空或你的姓名中包含了数字,请输入正确格式的姓名"));
		}
	}

	private void resetting() {
		studentNameText.setText("");
		classComboBox.setSelectedIndex(0);
		passwordText.setText("");
		noSexRadioButton.setSelected(true);
	}
}
