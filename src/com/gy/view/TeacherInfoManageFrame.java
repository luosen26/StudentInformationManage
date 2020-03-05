package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import com.gy.bean.S_teacher;
import com.gy.dao.SteacherDao;
import com.gy.dao.impl.SteacherDaoImpl;
import com.gy.talemodel.TeacherTableModel;
import com.gy.tools.Tools;

public class TeacherInfoManageFrame {
	private String sex;
	private JTextField teacherNameUpText;
	private int teacherSelectedRow = -1;
	private List<S_teacher> teacherData;
	private JTable teacherTable;
	private SteacherDao teacherDao;
	private JTextField teacherAgeText;
	private JTextField teacherNameDownText;
	private JRadioButton manRadioButton;
	private JRadioButton girlRadioButton;
	private JTextField teacherTileText;
	private JTextField teacherPWText;

	public TeacherInfoManageFrame(String userType,Object userObject,JDesktopPane desktopPane) {
		teacherDao = new SteacherDaoImpl();
		sex="��";
		JInternalFrame internalFrame = new JInternalFrame("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame.setFrameIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		internalFrame.setBounds(14, 13, 987, 661);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		JLabel label_1 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		label_1.setFont(new Font("����", Font.BOLD, 25));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(176, 25, 154, 44);
		internalFrame.getContentPane().add(label_1);

		teacherNameUpText = new JTextField();
		teacherNameUpText.setForeground(Color.BLUE);
		teacherNameUpText.setFont(new Font("����", Font.BOLD, 25));
		teacherNameUpText.setBounds(318, 27, 339, 40);
		internalFrame.getContentPane().add(teacherNameUpText);
		teacherNameUpText.setColumns(10);

		JButton findButton = new JButton("\u67E5\u8BE2");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select();
			}
		});
		findButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u641C\u7D22.png")));
		findButton.setForeground(Color.BLUE);
		findButton.setFont(new Font("����", Font.BOLD, 25));
		findButton.setBounds(684, 22, 130, 50);
		internalFrame.getContentPane().add(findButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 88, 839, 336);
		internalFrame.getContentPane().add(scrollPane);

		teacherTable = new JTable();
		teacherTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		teacherTable.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		teacherTable.getTableHeader().setFont(new Font("΢���ź�", Font.BOLD, 16));
		teacherTable.setRowHeight(51);
		scrollPane.setViewportView(teacherTable);

		JLabel label_2 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("����", Font.BOLD, 25));
		label_2.setBounds(52, 437, 154, 44);
		internalFrame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		label_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u804C\u79F0\u8BC4\u5B9A.png")));
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("����", Font.BOLD, 25));
		label_3.setBounds(52, 490, 154, 44);
		internalFrame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_4.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/password.png")));
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("����", Font.BOLD, 25));
		label_4.setBounds(52, 547, 154, 44);
		internalFrame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		label_5.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u6027\u522B.png")));
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("����", Font.BOLD, 25));
		label_5.setBounds(412, 437, 154, 44);
		internalFrame.getContentPane().add(label_5);

		JLabel label = new JLabel("\u6559\u5E08\u5E74\u9F84\uFF1A");
		label.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5E74\u9F84.png")));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("����", Font.BOLD, 25));
		label.setBounds(412, 490, 154, 44);
		internalFrame.getContentPane().add(label);

		teacherNameDownText = new JTextField();
		teacherNameDownText.setForeground(Color.BLUE);
		teacherNameDownText.setFont(new Font("����", Font.BOLD, 25));
		teacherNameDownText.setColumns(10);
		teacherNameDownText.setBounds(192, 439, 180, 40);
		internalFrame.getContentPane().add(teacherNameDownText);

		teacherTileText = new JTextField();
		teacherTileText.setForeground(Color.BLUE);
		teacherTileText.setFont(new Font("����", Font.BOLD, 25));
		teacherTileText.setColumns(10);
		teacherTileText.setBounds(192, 494, 180, 40);
		internalFrame.getContentPane().add(teacherTileText);

		teacherPWText = new JTextField();
		teacherPWText.setForeground(Color.BLUE);
		teacherPWText.setFont(new Font("����", Font.BOLD, 25));
		teacherPWText.setColumns(10);
		teacherPWText.setBounds(192, 554, 180, 40);
		internalFrame.getContentPane().add(teacherPWText);

		manRadioButton = new JRadioButton("\u7537");
		manRadioButton.setSelected(true);
		manRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex="��";
			}
		});
		manRadioButton.setFont(new Font("����", Font.BOLD, 25));
		manRadioButton.setForeground(Color.BLUE);
		manRadioButton.setBounds(562, 446, 59, 27);
		internalFrame.getContentPane().add(manRadioButton);

		girlRadioButton = new JRadioButton("\u5973");
		girlRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex="Ů";
			}
		});
		girlRadioButton.setForeground(Color.BLUE);
		girlRadioButton.setFont(new Font("����", Font.BOLD, 25));
		girlRadioButton.setBounds(652, 446, 57, 27);
		internalFrame.getContentPane().add(girlRadioButton);

		ButtonGroup bg = new ButtonGroup();
		bg.add(manRadioButton);
		bg.add(girlRadioButton);

		teacherAgeText = new JTextField();
		teacherAgeText.setForeground(Color.BLUE);
		teacherAgeText.setFont(new Font("����", Font.BOLD, 25));
		teacherAgeText.setColumns(10);
		teacherAgeText.setBounds(556, 495, 180, 40);
		internalFrame.getContentPane().add(teacherAgeText);

		JButton yesButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify();
			}
		});
		yesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		yesButton.setFont(new Font("����", Font.BOLD, 25));
		yesButton.setForeground(Color.BLUE);
		yesButton.setBounds(422, 544, 158, 50);
		internalFrame.getContentPane().add(yesButton);

		JButton removeButton = new JButton("\u5220\u9664\u4FE1\u606F");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
			}
		});
		removeButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5220\u9664.png")));
		removeButton.setForeground(Color.BLUE);
		removeButton.setFont(new Font("����", Font.BOLD, 25));
		removeButton.setBounds(656, 544, 158, 50);
		internalFrame.getContentPane().add(removeButton);

		ListSelectionModel rowSelectionModel = teacherTable.getSelectionModel();
		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// ֻ��������ͷ�
				if (e.getValueIsAdjusting()) {
					return;
				}
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				teacherSelectedRow = lsm.getMinSelectionIndex();
				if (teacherSelectedRow < 0) {
					return;
				}
				S_teacher teacher = teacherData.get(teacherSelectedRow);
				teacherNameDownText.setText(teacher.getName());
				teacherTileText.setText(teacher.getTitle());
				teacherPWText.setText(teacher.getPassword());
				if (teacher.getSex().equals("��")) {
					manRadioButton.setSelected(true);
				} else {
					girlRadioButton.setSelected(true);
				}
				teacherAgeText.setText("" + teacher.getAge());
			}
		});
		
		if (userType.equals("��ʦ")) {
			S_teacher teacher=(S_teacher) userObject;
			teacherData=new ArrayList<S_teacher>();
			teacherData.add(teacher);
			teacherTable.setModel(new TeacherTableModel(teacherData));
			teacherNameUpText.setText(teacher.getName());
			teacherNameUpText.setEditable(false);
			findButton.setEnabled(false);
			removeButton.setEnabled(false);
		}else {
			teacherData = teacherDao.findAll(null);
			teacherTable.setModel(new TeacherTableModel(teacherData));
		}
	}
	private void resetting() {
		teacherNameDownText.setText("");
		teacherTileText.setText("");
		teacherPWText.setText("");
		manRadioButton.setSelected(true);
		teacherAgeText.setText("");
	}
	private void remove() {
		if (teacherSelectedRow!=-1) {
			if (JOptionPane.showConfirmDialog(null, Tools.getLable("�Ƿ�ȷ��Ҫɾ���ý�ʦ��"), "ɾ����ʦ",
					JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				if (teacherDao.remove(teacherData.get(teacherSelectedRow).getId())>0) {
					JOptionPane.showMessageDialog(null, Tools.getLable("ɾ���ɹ�"));
					teacherData=teacherDao.findAll(null);
					teacherTable.setModel(new TeacherTableModel(teacherData));
					resetting();
				}else {
					JOptionPane.showMessageDialog(null, Tools.getLable("ɾ��ʧ��,δ֪����"));
				}
			}else {
				return;
			}
		}else {
			JOptionPane.showMessageDialog(null, Tools.getLable("����ѡ��һ����Ҫɾ���Ľ�ʦ"));
		}
	}
	private void select() {
		String name=Tools.isEmpty(teacherNameUpText.getText());
		if (name.equals("")) {
			teacherData=teacherDao.findAll(null);
			teacherTable.setModel(new TeacherTableModel(teacherData));
			resetting();
		}else {
			teacherData=teacherDao.findAll(name);
			teacherTable.setModel(new TeacherTableModel(teacherData));
			resetting();
		}
	}
	private void modify() {
		if (teacherSelectedRow!=-1) {
			boolean nameFlag = Tools.isName(teacherNameDownText.getText());
			if (nameFlag) {
				String name=Tools.isEmpty(teacherNameDownText.getText());
				boolean titleFlag = Tools.isName(teacherTileText.getText());
				if (titleFlag) {
					String title = Tools.isEmpty(teacherTileText.getText());
					boolean PWFlag = Tools.isPassword(teacherPWText.getText());
					if (PWFlag) {
						String password = Tools.isEmpty(teacherPWText.getText());
						boolean ageFlag = Tools.isNumber(teacherAgeText.getText());
						if (ageFlag) {
							if (JOptionPane.showConfirmDialog(null, Tools.getLable("�Ƿ�ȷ��Ҫ�޸ĸý�ʦ����Ϣ��"), "�޸Ľ�ʦ��Ϣ",
									JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
								String age = Tools.isEmpty(teacherAgeText.getText());
								S_teacher teacher=teacherData.get(teacherSelectedRow);
								teacher.setName(name);
								teacher.setTitle(title);
								teacher.setPassword(password);
								teacher.setSex(sex);
								teacher.setAge(Integer.parseInt(age));
								if (teacherDao.modify(teacher)>0) {
									JOptionPane.showMessageDialog(null, Tools.getLable("�޸ĳɹ�"));
									teacherData.set(0,teacher);
									teacherTable.setModel(new TeacherTableModel(teacherData));
									resetting();
								}else {
									JOptionPane.showMessageDialog(null, Tools.getLable("�޸�ʧ��,δ֪����"));
								}
							}else {
								return;
							}
						}else {
							JOptionPane.showMessageDialog(null, Tools.getLable("�޸�ʧ��,��ʦ���䲻��Ϊ�ջ��ʽ����ȷ"));
						}
					}else {
						JOptionPane.showMessageDialog(null,
								Tools.getLable("�޸�ʧ��,��¼���벻��Ϊ�ջ��¼�����ʽ����ȷ����¼������������ֻ��Сд��ĸ"));
					}
				}else {
					JOptionPane.showMessageDialog(null, Tools.getLable("�޸�ʧ��,��ʦְ�Ʋ���Ϊ�ջ��ʽ����ȷ"));
				}
			}else {
				JOptionPane.showMessageDialog(null, Tools.getLable("�޸�ʧ��,��ʦ��������Ϊ�ջ��ʦ�����а���������,��������ȷ��ʽ�Ľ�ʦ����"));
			}
		}else {
			JOptionPane.showMessageDialog(null, Tools.getLable("����ѡ��һ����Ҫ�޸ĵĽ�ʦ"));
		}
	}
}
