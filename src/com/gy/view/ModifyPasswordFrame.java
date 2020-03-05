package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.gy.bean.S_admin;
import com.gy.bean.S_student;
import com.gy.bean.S_teacher;
import com.gy.dao.SadminDao;
import com.gy.dao.SstudentDao;
import com.gy.dao.SteacherDao;
import com.gy.dao.impl.SadminDaoImpl;
import com.gy.dao.impl.SstudentDaoImpl;
import com.gy.dao.impl.SteacherDaoImpl;
import com.gy.tools.Tools;

public class ModifyPasswordFrame {
	private S_admin admin;
	private SadminDao adminDao;
	private S_teacher teacher;
	private SteacherDao teacherDao;
	private S_student student;
	private SstudentDao studentDao;
	private String userType;
	private JTextField teacherNameUpText;
	private JPasswordField passwordText;
	private JPasswordField confirmPasswordText;
	public ModifyPasswordFrame(String userType,Object userObject,JDesktopPane desktopPane) {
		this.userType=userType;
		if (userType.equals("系统管理员")) {
			admin = (S_admin) userObject;
			adminDao =new SadminDaoImpl();
			teacherDao =new SteacherDaoImpl();
			studentDao =new SstudentDaoImpl();
		} else if (userType.equals("教师")) {
			teacher = (S_teacher) userObject;
			teacherDao =new SteacherDaoImpl();
			studentDao =new SstudentDaoImpl();
		} else {
			student = (S_student) userObject;
			studentDao =new SstudentDaoImpl();
		}
		JInternalFrame internalFrame = new JInternalFrame("\u4FEE\u6539\u5BC6\u7801");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame
				.setFrameIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u4FEE\u6539\u5BC6\u7801.png")));
		internalFrame.setBounds(210, 75, 678, 425);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		JLabel label_1 = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7528\u6237\u540D.png")));
		label_1.setFont(new Font("宋体", Font.BOLD, 25));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(85, 25, 154, 44);
		internalFrame.getContentPane().add(label_1);

		JLabel currentUserLabel = new JLabel();
		if (userType.equals("系统管理员")) {
			currentUserLabel.setText("【" + userType + "】" + admin.getName());
		} else if (userType.equals("教师")) {
			currentUserLabel.setText("【" + userType + "】" + teacher.getName());
		} else {
			currentUserLabel.setText("【" + userType + "】" + student.getName());
		}
		currentUserLabel.setForeground(Color.BLUE);
		currentUserLabel.setFont(new Font("宋体", Font.BOLD, 25));
		currentUserLabel.setBounds(231, 25, 314, 44);
		internalFrame.getContentPane().add(currentUserLabel);

		JLabel label_2 = new JLabel("\u539F\u59CB\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/password.png")));
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 25));
		label_2.setBounds(85, 98, 154, 44);
		internalFrame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel(" \u65B0\u5BC6\u7801\uFF1A");
		label_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u4FEE\u6539\u5BC6\u7801.png")));
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 25));
		label_3.setBounds(85, 171, 154, 44);
		internalFrame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_4.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u4FEE\u6539\u5BC6\u7801.png")));
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("宋体", Font.BOLD, 25));
		label_4.setBounds(85, 240, 154, 44);
		internalFrame.getContentPane().add(label_4);

		teacherNameUpText = new JTextField();
		teacherNameUpText.setFont(new Font("宋体", Font.BOLD, 25));
		teacherNameUpText.setBounds(231, 100, 240, 40);
		internalFrame.getContentPane().add(teacherNameUpText);
		teacherNameUpText.setColumns(10);

		passwordText = new JPasswordField();
		passwordText.setFont(new Font("宋体", Font.BOLD, 25));
		passwordText.setBounds(231, 173, 240, 40);
		internalFrame.getContentPane().add(passwordText);

		confirmPasswordText = new JPasswordField();
		confirmPasswordText.setFont(new Font("宋体", Font.BOLD, 25));
		confirmPasswordText.setBounds(231, 242, 240, 40);
		internalFrame.getContentPane().add(confirmPasswordText);

		JButton confirmBankbutton = new JButton("\u786E \u8BA4");
		confirmBankbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifyPassword();
			}
		});

		confirmBankbutton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		confirmBankbutton.setFont(new Font("宋体", Font.BOLD, 25));
		confirmBankbutton.setForeground(Color.BLUE);
		confirmBankbutton.setBounds(167, 307, 130, 50);
		internalFrame.getContentPane().add(confirmBankbutton);

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
	private void modifyPassword() {
		boolean oldPWFlag = Tools.isPassword(teacherNameUpText.getText());
		if (oldPWFlag) {
			boolean newPWFlag = Tools.isPassword(new String(passwordText.getPassword()));
			if (newPWFlag) {
				boolean confirmPWFlag = Tools.isPassword(new String(confirmPasswordText.getPassword()));
				if (confirmPWFlag) {
					String newPW = Tools.isEmpty(new String(passwordText.getPassword()));
					String confirmPW = Tools.isEmpty(new String(confirmPasswordText.getPassword()));
					if (newPW.equals(confirmPW)) {
						String userPW = null;
						String oldPW = Tools.isEmpty(teacherNameUpText.getText());
						if (userType.equals("系统管理员")) {
							userPW = admin.getPassword();
							if (userPW.equals(oldPW)) {
								if (adminDao.modifyPassword(admin.getId(), newPW) > 0) {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改成功"));
									resetting();
								} else {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改失败"));
								}
							} else {
								JOptionPane.showMessageDialog(null, Tools.getLable("修改失败，旧密码不正确"));
							}
						} else if (userType.equals("教师")) {
							userPW = teacher.getPassword();
							if (userPW.equals(oldPW)) {
								if (teacherDao.modifyPassword(teacher.getId(), newPW) > 0) {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改成功"));
									resetting();
								} else {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改失败"));
								}
							} else {
								JOptionPane.showMessageDialog(null, Tools.getLable("修改失败，旧密码和新密码不相同"));
							}
						} else {
							userPW = student.getPassword();
							if (userPW.equals(oldPW)) {
								if (studentDao.modifyPassword(student.getId(), newPW) > 0) {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改成功"));
									resetting();
								} else {
									JOptionPane.showMessageDialog(null, Tools.getLable("修改失败"));
								}
							} else {
								JOptionPane.showMessageDialog(null, Tools.getLable("修改失败，旧密码和新密码不相同"));
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, Tools.getLable("修改失败，新密码和确认密码不相同"));
					}
				} else {
					JOptionPane.showMessageDialog(null,
							Tools.getLable("修改失败，确认密码不能为空或确认密码格式不正确，密码必须是数字或大小写字母"));
				}
			} else {
				JOptionPane.showMessageDialog(null, Tools.getLable("修改失败，新密码不能为空或新密码格式不正确，密码必须是数字或大小写字母"));
			}
		} else {
			JOptionPane.showMessageDialog(null, Tools.getLable("修改失败，旧密码不能为空或旧密码正确"));
		}
	}
	private void resetting() {
		teacherNameUpText.setText("");
		passwordText.setText("");
		confirmPasswordText.setText("");
	}
}
