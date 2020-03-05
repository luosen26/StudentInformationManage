package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
/**
 * @author luosen
 * @version 1.0V
 */
public class MainFrame extends JFrame {
	private S_admin admin;
	private SadminDao adminDao;
	private S_teacher teacher;
	private SteacherDao teacherDao;
	private S_student student;
	private SstudentDao studentDao;
	private String userType;
	private Object userObject;
	private Runtime runtime;
	private JDesktopPane desktopPane;
	/**
	 * 创建主窗口
	 */
	public MainFrame(String userType, Object userObject) {
		this.userType = userType;
		this.userObject=userObject;
		runtime = Runtime.getRuntime();
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
		setTitle("\u5B66\u751F\u4FE1\u606F\u7CFB\u7EDF\u4E3B\u754C\u9762");
		getContentPane().setBackground(SystemColor.menu);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F.png")));
		setSize(1045,768);
		setLocation(Tools.getPostion(1045,850));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1038, 37);
		getContentPane().add(menuBar);

		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setFont(new Font("宋体", Font.BOLD, 20));
		menu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menuBar.add(menu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u5BC6\u7801\u4FEE\u6539");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifyPassword();
			}
		});
		mntmNewMenuItem.setFont(new Font("宋体", Font.BOLD, 18));
		mntmNewMenuItem
				.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u4FEE\u6539\u5BC6\u7801.png")));
		menu.add(mntmNewMenuItem);

		JMenuItem menuItem = new JMenuItem("\u7CFB\u7EDF\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, Tools.getLable("是否确定退出学生信息系统？"), "退出系统",
						JOptionPane.CANCEL_OPTION) == JOptionPane.OK_OPTION) {
					System.exit(0);
				} else {
					return;
				}
			}
		});
		menuItem.setFont(new Font("宋体", Font.BOLD, 18));
		menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u9000\u51FA.png")));
		menu.add(menuItem);

		JMenu mnNewMenu = new JMenu("\u5B66\u751F\u7BA1\u7406");
		mnNewMenu.setFont(new Font("宋体", Font.BOLD, 20));
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		menuBar.add(mnNewMenu);

		JMenuItem addStudentMenuItem = new JMenuItem("\u6DFB\u52A0\u5B66\u751F");
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent();
			}
		});
		addStudentMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7528\u6237\u540D.png")));
		addStudentMenuItem.setFont(new Font("宋体", Font.BOLD, 18));
		mnNewMenu.add(addStudentMenuItem);

		JMenuItem menuItem_2 = new JMenuItem("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentManage();
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		menuItem_2.setFont(new Font("宋体", Font.BOLD, 18));
		mnNewMenu.add(menuItem_2);

		JMenu classMenu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		classMenu.setFont(new Font("宋体", Font.BOLD, 20));
		classMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u7BA1\u7406.png")));
		menuBar.add(classMenu);

		JMenuItem addClassMenuItem = new JMenuItem("\u6DFB\u52A0\u73ED\u7EA7");
		addClassMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClass();
			}
		});
		addClassMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		addClassMenuItem.setFont(new Font("宋体", Font.BOLD, 18));
		classMenu.add(addClassMenuItem);

		JMenuItem classManageMenuItem = new JMenuItem("\u73ED\u7EA7\u4FE1\u606F\u7BA1\u7406");
		classManageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classManage();
			}
		});
		classManageMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u7BA1\u7406.png")));
		classManageMenuItem.setFont(new Font("宋体", Font.BOLD, 18));
		classMenu.add(classManageMenuItem);

		JMenu teacherMenu = new JMenu("\u6559\u5E08\u7BA1\u7406");
		teacherMenu.setFont(new Font("宋体", Font.BOLD, 20));
		teacherMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		menuBar.add(teacherMenu);

		JMenuItem addTeacherMenuItem = new JMenuItem("\u6DFB\u52A0\u6559\u5E08");
		addTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTeacher();
			}
		});
		addTeacherMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7528\u6237\u540D.png")));
		addTeacherMenuItem.setFont(new Font("宋体", Font.BOLD, 18));
		teacherMenu.add(addTeacherMenuItem);

		JMenuItem menuItem_6 = new JMenuItem("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherManage(e);
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		menuItem_6.setFont(new Font("宋体", Font.BOLD, 18));
		teacherMenu.add(menuItem_6);

		JMenu courseMenu = new JMenu("\u8BFE\u7A0B\u7BA1\u7406");
		courseMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		courseMenu.setFont(new Font("宋体", Font.BOLD, 20));
		menuBar.add(courseMenu);

		JMenuItem menuItem_11 = new JMenuItem("\u6DFB\u52A0\u8BFE\u7A0B");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourse();
			}
		});
		menuItem_11.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u65B0\u4EBA\u8BFE\u7A0B.png")));
		menuItem_11.setFont(new Font("宋体", Font.BOLD, 18));
		courseMenu.add(menuItem_11);

		JMenuItem menuItem_12 = new JMenuItem("\u8BFE\u7A0B\u4FE1\u606F\u7BA1\u7406");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseManage();
			}
		});
		menuItem_12.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B\u5217\u8868.png")));
		menuItem_12.setFont(new Font("宋体", Font.BOLD, 18));
		courseMenu.add(menuItem_12);

		JMenu chooseCourseMenu = new JMenu("\u9009\u8BFE\u7BA1\u7406");
		chooseCourseMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u9009\u62E9.png")));
		chooseCourseMenu.setFont(new Font("宋体", Font.BOLD, 20));
		menuBar.add(chooseCourseMenu);
		
		JMenuItem chooseCourseMenuItem = new JMenuItem("\u9009\u62E9\u8BFE\u7A0B");
		chooseCourseMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseCourse();
			}
		});
		chooseCourseMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u9009\u62E9.png")));
		chooseCourseMenuItem.setFont(new Font("宋体", Font.BOLD, 18));
		chooseCourseMenu.add(chooseCourseMenuItem);

		JMenu signMenu = new JMenu("\u7B7E\u5230\u8003\u52E4");
		signMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7B7E\u5230.png")));
		signMenu.setFont(new Font("宋体", Font.BOLD, 20));
		menuBar.add(signMenu);

		JMenuItem studentSignMenuItem = new JMenuItem("\u5B66\u751F\u7B7E\u5230");
		studentSignMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentSign();
			}
		});
		studentSignMenuItem
				.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		studentSignMenuItem.setFont(new Font("宋体", Font.BOLD, 18));
		signMenu.add(studentSignMenuItem);

		JMenuItem signManageMenuItem = new JMenuItem("\u7B7E\u5230\u7BA1\u7406");
		signManageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signManage();
			}
		});
		signManageMenuItem
				.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7B7E\u5230\u5217\u8868.png")));
		signManageMenuItem.setFont(new Font("宋体", Font.BOLD, 18));
		signMenu.add(signManageMenuItem);

		JMenuItem signCountMenuItem = new JMenuItem("\u7B7E\u5230\u7EDF\u8BA1");
		signCountMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signCount();
			}
		});
		signCountMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u67F1\u72B6\u56FE.png")));
		signCountMenuItem.setFont(new Font("宋体", Font.BOLD, 18));
		signMenu.add(signCountMenuItem);

		JMenu menu_1 = new JMenu("\u5E2E\u52A9");
		menu_1.setFont(new Font("宋体", Font.BOLD, 20));
		menu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5E2E\u52A9.png")));
		menuBar.add(menu_1);

		JMenuItem menuItem_7 = new JMenuItem("\u5B66\u751F\u7BA1\u7406\u4ECB\u7ECD");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String path = MainFrame.class.getResource("/").getPath();
					runtime.exec("explorer file://" + path + "com/gy/help/Student_manage_introduce.html");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuItem_7.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		menuItem_7.setFont(new Font("宋体", Font.BOLD, 18));
		menu_1.add(menuItem_7);

		JMenuItem menuItem_8 = new JMenuItem("\u73ED\u7EA7\u7BA1\u7406\u4ECB\u7ECD");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String path = MainFrame.class.getResource("/").getPath();
					runtime.exec("explorer file://" + path + "com/gy/help/Class_manage_introduce.html");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuItem_8.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u7BA1\u7406.png")));
		menuItem_8.setFont(new Font("宋体", Font.BOLD, 18));
		menu_1.add(menuItem_8);

		JMenuItem menuItem_9 = new JMenuItem("\u6559\u5E08\u7BA1\u7406\u4ECB\u7ECD");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String path = MainFrame.class.getResource("/").getPath();
					runtime.exec("explorer file://" + path + "com/gy/help/Teacher_manage_introduce.html");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuItem_9.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		menuItem_9.setFont(new Font("宋体", Font.BOLD, 18));
		menu_1.add(menuItem_9);

		JMenuItem menuItem_10 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String path = MainFrame.class.getResource("/").getPath();
					runtime.exec("explorer file://" + path + "com/gy/help/About_us.html");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JMenuItem menuItem_13 = new JMenuItem("\u8BFE\u7A0B\u7BA1\u7406\u4ECB\u7ECD");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String path = MainFrame.class.getResource("/").getPath();
					runtime.exec("explorer file://" + path + "com/gy/help/Course_manage_introduce.html");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuItem_13.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		menuItem_13.setFont(new Font("宋体", Font.BOLD, 18));
		menu_1.add(menuItem_13);

		JMenuItem menuItem_14 = new JMenuItem("\u9009\u8BFE\u7BA1\u7406\u4ECB\u7ECD");
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String path = MainFrame.class.getResource("/").getPath();
					runtime.exec("explorer file://" + path + "com/gy/help/Choose_course_manage_introduce.html");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuItem_14.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u9009\u62E9.png")));
		menuItem_14.setFont(new Font("宋体", Font.BOLD, 18));
		menu_1.add(menuItem_14);

		JMenuItem menuItem_15 = new JMenuItem("\u7B7E\u5230\u8003\u52E4\u4ECB\u7ECD");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String path = MainFrame.class.getResource("/").getPath();
					runtime.exec("explorer file://" + path + "com/gy/help/Sign_introduce.html");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuItem_15.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7B7E\u5230.png")));
		menuItem_15.setFont(new Font("宋体", Font.BOLD, 18));
		menu_1.add(menuItem_15);
		menuItem_10.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5173\u4E8E\u6211\u4EEC.png")));
		menuItem_10.setFont(new Font("宋体", Font.BOLD, 18));
		menu_1.add(menuItem_10);

		if (userType.equals("系统管理员")) {
			signMenu.setEnabled(false);
		}else if (userType.equals("教师")){
			addTeacherMenuItem.setEnabled(false);
			studentSignMenuItem.setEnabled(false);
		}else {
			addStudentMenuItem.setEnabled(false);
			addClassMenuItem.setEnabled(false);
			teacherMenu.setEnabled(false);
			courseMenu.setEnabled(false);
			signCountMenuItem.setEnabled(false);
			signManageMenuItem.setEnabled(false);
		}

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(72, 209, 204));
		desktopPane.setBounds(0, 34, 1038, 700);
		getContentPane().add(desktopPane);

	}

	private void signCount() {
		new SignCountFrame(desktopPane);
	}

	private void signManage() {
		new SignManageFrame(desktopPane);
	}

	private void studentSign() {
		new StudentSignFrame(userObject,desktopPane);
	}

	private void chooseCourse() {
		new ChooseCourseManageFrame(userType,userObject,desktopPane);
	}

	private void courseManage() {
		new CourseInfoManageFrame(userType,userObject,desktopPane);
	}

	private void addCourse() {
		new AddCourseFrame(userType,userObject,desktopPane);
	}


	private void teacherManage(ActionEvent e) {
		new TeacherInfoManageFrame(userType,userObject,desktopPane);
	}
	
	private void addTeacher() {
		new AddTeacherFrame(desktopPane);
	}
	
	private void classManage() {
		new ClassInfoManageFrame(userType,desktopPane);
	}

	private void addClass() {
		new AddClassFrame(desktopPane);
	}
	
	private void studentManage() {
		new StudentInfoManageFrame(userType,userObject,desktopPane);
	}

	// 添加添加学生窗口
	private void addStudent() {
		new AddStudentFrame(desktopPane);
	}
	
	private void modifyPassword() {
		new ModifyPasswordFrame(userType,userObject,desktopPane);
	}
}
