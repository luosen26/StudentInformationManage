package com.gy.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.gy.bean.S_admin;
import com.gy.bean.S_student;
import com.gy.bean.S_teacher;
import com.gy.bean.UserType;
import com.gy.dao.SadminDao;
import com.gy.dao.SstudentDao;
import com.gy.dao.SteacherDao;
import com.gy.dao.impl.SadminDaoImpl;
import com.gy.dao.impl.SstudentDaoImpl;
import com.gy.dao.impl.SteacherDaoImpl;
import com.gy.tools.Tools;
import java.awt.Color;

public class LoginFrame extends JFrame {
	private JPanel contentPane;
	private JTextField nameTextField;
	private JPasswordField passwordField;
	private JComboBox userTypeComboBox;
	private JButton loginButton;
	private JButton regButton;
	public UserType userType;
	public Object userObject;
	public SadminDao ad;
	public SteacherDao td;
	public SstudentDao sd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		ad=new SadminDaoImpl();
		td=new SteacherDaoImpl();
		sd=new SstudentDaoImpl();
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,354);
		setLocation(Tools.getPostion(450,550));
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/gy/image/logo.png")));
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u4FE1\u606F\u767B\u5F55\u7CFB\u7EDF\u754C\u9762");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 25));
		
		JLabel label_2 = new JLabel(" \u7528 \u6237 \u540D\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/gy/image/\u7528\u6237\u540D.png")));
		
		JLabel label_3 = new JLabel("\u5BC6       \u7801\uFF1A");
		label_3.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/gy/image/\u5BC6\u7801.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/gy/image/userType.png")));
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("宋体", Font.BOLD, 18));
		nameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.BOLD, 18));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setForeground(new Color(0, 0, 0));
		userTypeComboBox.setFont(new Font("宋体", Font.BOLD, 18));
		userTypeComboBox.setModel(new DefaultComboBoxModel
				(new UserType[]{UserType.ADMIN,UserType.
						TEACHER,UserType.STUDENT}));
		loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginAct(arg0);
			}
		});
		loginButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/gy/image/\u767B\u5F55.png")));
		loginButton.setFont(new Font("宋体", Font.BOLD, 18));
		
		regButton = new JButton("\u91CD\u7F6E");
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValue(arg0);
			}
		});
		regButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/gy/image/\u91CD\u7F6E.png")));
		regButton.setFont(new Font("宋体", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(96)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordField))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userTypeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addComponent(loginButton)
							.addGap(42)
							.addComponent(regButton)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(label_1)))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(regButton))
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void resetValue(ActionEvent arg0) {
		nameTextField.setText("");
		passwordField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}

	protected void loginAct(ActionEvent arg0) {
		String name=nameTextField.getText().toString();
		name=Tools.isEmpty(name);
		String password=new String(passwordField.getPassword());
		password=Tools.isEmpty(password);
		S_admin as=null;
		S_teacher st=null;
		S_student ss=null;
		String type=null;
		userType=(UserType)
				userTypeComboBox.getSelectedItem();
		if(Tools.isNotNull(name) && Tools.isNotNull(password)){
			if("系统管理员".equals(userType.toString())){
				type=userType.toString();
				as=ad.adminLogin(name, password);
				if(as!=null){
					userObject=as;
					JOptionPane.showMessageDialog(this, 
							"欢迎"+type+":"+as.getName()+"登录");
					this.dispose();
					new MainFrame(type,userObject).setVisible(true);
				}else{
					JOptionPane.showMessageDialog(this, "用户名或者密码错误！");
				}
			}else if("教师".equals(userType.toString())){
				type=userType.toString();
				st=td.teacherLogin(name, password);
				if(st!=null){
					userObject=st;
					JOptionPane.showMessageDialog(this, 
							"欢迎"+type+":"+st.getName()+"登录");
					this.dispose();
					new MainFrame(type,userObject).setVisible(true);
				}else{
					JOptionPane.showMessageDialog(this, "用户名或者密码错误！");
				}
			}else{
				type=userType.toString();
				ss=sd.studentLogin(name, password);
				if(ss!=null){
					userObject=ss;
					JOptionPane.showMessageDialog(this, 
							"欢迎"+type+":"+ss.getName()+"登录");
					this.dispose();
					new MainFrame(type,userObject).setVisible(true);
				}else{
					JOptionPane.showMessageDialog(this, "用户名或者密码错误！");
				}
			}
		}else{
			JOptionPane.showMessageDialog(this, "不能为空！");
		}
	}
}
