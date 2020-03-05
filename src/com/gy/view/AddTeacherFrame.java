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

import com.gy.bean.S_teacher;
import com.gy.dao.SteacherDao;
import com.gy.dao.impl.SclassDaoImpl;
import com.gy.dao.impl.SteacherDaoImpl;
import com.gy.tools.Tools;

public class AddTeacherFrame {
	private SteacherDao teacherDao;
	private JTextField teacherNameText;
	private String sex;
	private JRadioButton manRadioButton;
	private JTextField teachertitleText;
	private JTextField teacherAgeText;
	private JPasswordField passwordText;

	public AddTeacherFrame(JDesktopPane desktopPane) {
		teacherDao = new SteacherDaoImpl();
		sex = "男";
		JInternalFrame internalFrame = new JInternalFrame("\u6DFB\u52A0\u6559\u5E08");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame.setFrameIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		internalFrame.setBounds(210, 75, 678, 425);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		JLabel label_1 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		label_1.setFont(new Font("宋体", Font.BOLD, 25));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(85, 25, 154, 44);
		internalFrame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u5BC6\u7801.png")));
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 25));
		label_2.setBounds(85, 250, 154, 44);
		internalFrame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		label_3.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u804C\u79F0\u8BC4\u5B9A.png")));
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 25));
		label_3.setBounds(85, 139, 154, 44);
		internalFrame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		label_4.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u6027\u522B.png")));
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("宋体", Font.BOLD, 25));
		label_4.setBounds(85, 82, 154, 44);
		internalFrame.getContentPane().add(label_4);

		JLabel label = new JLabel("\u6559\u5E08\u5E74\u9F84\uFF1A");
		label.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u5E74\u9F84.png")));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 25));
		label.setBounds(85, 193, 154, 44);
		internalFrame.getContentPane().add(label);

		teacherNameText = new JTextField();
		teacherNameText.setFont(new Font("宋体", Font.BOLD, 25));
		teacherNameText.setBounds(231, 30, 240, 40);
		internalFrame.getContentPane().add(teacherNameText);
		teacherNameText.setColumns(10);

		manRadioButton = new JRadioButton("\u7537");
		manRadioButton.setSelected(true);
		manRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "男";
			}
		});
		manRadioButton.setFont(new Font("宋体", Font.BOLD, 25));
		manRadioButton.setForeground(Color.BLUE);
		manRadioButton.setBounds(249, 91, 68, 27);
		internalFrame.getContentPane().add(manRadioButton);

		JRadioButton girlRadioButton = new JRadioButton("\u5973");
		girlRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "女";
			}
		});
		girlRadioButton.setForeground(Color.BLUE);
		girlRadioButton.setFont(new Font("宋体", Font.BOLD, 25));
		girlRadioButton.setBounds(344, 91, 68, 27);
		internalFrame.getContentPane().add(girlRadioButton);

		ButtonGroup bg = new ButtonGroup();
		bg.add(manRadioButton);
		bg.add(girlRadioButton);

		teachertitleText = new JTextField();
		teachertitleText.setFont(new Font("宋体", Font.BOLD, 25));
		teachertitleText.setColumns(10);
		teachertitleText.setBounds(231, 143, 240, 40);
		internalFrame.getContentPane().add(teachertitleText);

		teacherAgeText = new JTextField();
		teacherAgeText.setFont(new Font("宋体", Font.BOLD, 25));
		teacherAgeText.setColumns(10);
		teacherAgeText.setBounds(231, 199, 240, 40);
		internalFrame.getContentPane().add(teacherAgeText);

		passwordText = new JPasswordField();
		passwordText.setFont(new Font("宋体", Font.BOLD, 25));
		passwordText.setBounds(231, 252, 240, 40);
		internalFrame.getContentPane().add(passwordText);

		JButton yesButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		yesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		yesButton.setFont(new Font("宋体", Font.BOLD, 25));
		yesButton.setForeground(Color.BLUE);
		yesButton.setBounds(167, 307, 170, 50);
		internalFrame.getContentPane().add(yesButton);

		JButton resettingButton = new JButton("\u91CD\u7F6E\u83DC\u5355");
		resettingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetting();
			}
		});
		resettingButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u91CD\u7F6E.png")));
		resettingButton.setForeground(Color.BLUE);
		resettingButton.setFont(new Font("宋体", Font.BOLD, 25));
		resettingButton.setBounds(371, 307, 170, 50);
		internalFrame.getContentPane().add(resettingButton);
	}

	private void resetting() {
		teacherNameText.setText("");
		manRadioButton.setSelected(true);
		teachertitleText.setText("");
		teacherAgeText.setText("");
		passwordText.setText("");
	}

	private void add() {
		boolean nameFlag = Tools.isName(teacherNameText.getText());
		if (nameFlag) {
			String name = Tools.isEmpty(teacherNameText.getText());
			boolean titleFlag = Tools.isName(teachertitleText.getText());
			if (titleFlag) {
				String title = Tools.isEmpty(teachertitleText.getText());
				boolean ageFlag = Tools.isNumber(teacherAgeText.getText());
				if (ageFlag) {
					String age = Tools.isEmpty(teacherAgeText.getText());
					boolean PWFlag = Tools.isPassword(new String(passwordText.getPassword()));
					if (PWFlag) {
						String password = Tools.isEmpty(new String(passwordText.getPassword()));
						if (teacherDao.create(new S_teacher(name, sex, title, Integer.parseInt(age), password)) > 0) {
							JOptionPane.showMessageDialog(null, Tools.getLable("添加成功"));
							resetting();
						} else {
							JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,未知错误"));
						}
					} else {
						JOptionPane.showMessageDialog(null,
								Tools.getLable("添加失败,登录密码不能为空或登录密码格式不正确，登录密码必须是数字或大小写字母"));
					}
				} else {
					JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,教师年龄不能为空或格式不正确"));
				}
			} else {
				JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,教师职称不能为空或格式不正确"));
			}
		} else {
			JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,姓名不能为空或你的姓名中包含了数字,请输入正确格式的姓名"));
		}
	}
}
