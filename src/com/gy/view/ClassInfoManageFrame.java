package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import com.gy.bean.S_class;
import com.gy.dao.SclassDao;
import com.gy.dao.impl.SclassDaoImpl;
import com.gy.talemodel.ClassTableModel;
import com.gy.tools.Tools;

public class ClassInfoManageFrame {
	private SclassDao classDao;
	private JTextField classNameDownText;
	private JTextArea classInfoTextArea;
	private JTable classTable;
	private JTextField classNameUpText;
	private List<S_class> classData;
	private int classSelectedRow = -1;
	public ClassInfoManageFrame(String userType,JDesktopPane desktopPane) {
		classDao=new SclassDaoImpl();
		JInternalFrame internalFrame = new JInternalFrame("\u73ED\u7EA7\u4FE1\u606F\u7BA1\u7406");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame
				.setFrameIcon(new ImageIcon(ClassInfoManageFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u7BA1\u7406.png")));
		internalFrame.setBounds(14, 24, 991, 612);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		JLabel label_1 = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("宋体", Font.BOLD, 25));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(176, 25, 154, 44);
		internalFrame.getContentPane().add(label_1);

		classNameUpText = new JTextField();
		classNameUpText.setForeground(Color.BLUE);
		classNameUpText.setFont(new Font("宋体", Font.BOLD, 25));
		classNameUpText.setBounds(318, 27, 339, 40);
		internalFrame.getContentPane().add(classNameUpText);
		classNameUpText.setColumns(10);

		JButton findButton = new JButton("\u67E5\u8BE2");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select();
			}
		});
		findButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u641C\u7D22.png")));
		findButton.setForeground(Color.BLUE);
		findButton.setFont(new Font("宋体", Font.BOLD, 25));
		findButton.setBounds(684, 22, 130, 50);
		internalFrame.getContentPane().add(findButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 88, 839, 336);
		internalFrame.getContentPane().add(scrollPane);

		classData = classDao.findAll(null);
		classTable = new JTable(new ClassTableModel(classData));
		classTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		classTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		classTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		classTable.setRowHeight(51);
		scrollPane.setViewportView(classTable);

		JLabel label_2 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		label_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 25));
		label_2.setBounds(52, 437, 154, 44);
		internalFrame.getContentPane().add(label_2);

		classInfoTextArea = new JTextArea();
		classInfoTextArea.setForeground(Color.BLUE);
		classInfoTextArea.setLineWrap(true);
		classInfoTextArea.setFont(new Font("Monospaced", Font.BOLD, 22));
		classInfoTextArea.setBounds(195, 437, 211, 126);
		internalFrame.getContentPane().add(classInfoTextArea);

		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 25));
		label.setBounds(412, 437, 154, 44);
		internalFrame.getContentPane().add(label);

		classNameDownText = new JTextField();
		classNameDownText.setForeground(Color.BLUE);
		classNameDownText.setFont(new Font("宋体", Font.BOLD, 25));
		classNameDownText.setColumns(10);
		classNameDownText.setBounds(556, 439, 180, 40);
		internalFrame.getContentPane().add(classNameDownText);

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

		JButton removeButton = new JButton("\u5220  \u9664");
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

		ListSelectionModel rowSelectionModel = classTable.getSelectionModel();
		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 只处理鼠标释放
				if (e.getValueIsAdjusting()) {
					return;
				}
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				classSelectedRow = lsm.getMinSelectionIndex();
				if (classSelectedRow < 0) {
					return;
				}
				S_class clazz=classData.get(classSelectedRow);
				classInfoTextArea.setText(clazz.getInfo());
				classNameDownText.setText(clazz.getName());
			}
		});
		
		if (userType.equals("学生")) {
			classNameDownText.setEditable(false);
			classInfoTextArea.setEditable(false);
			yesButton.setEnabled(false);
			removeButton.setEnabled(false);
		}
	}
	private void resetting() {
		classNameDownText.setText("");
		classInfoTextArea.setText("");
	}
	private void select() {
		String name=Tools.isEmpty(classNameUpText.getText());
		if (name.equals("")) {
			classData=classDao.findAll(null);
			classTable.setModel(new ClassTableModel(classData));
			resetting();
		}else {
			classData=classDao.findAll(name);
			classTable.setModel(new ClassTableModel(classData));
			resetting();
		}
	}
	private void remove() {
		if (classSelectedRow!=-1) {
			if (JOptionPane.showConfirmDialog(null, Tools.getLable("是否确定要删除该班级？"), "删除班级",
					JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				if (classDao.remove(classData.get(classSelectedRow).getId())>0) {
					JOptionPane.showMessageDialog(null, Tools.getLable("删除成功"));
					classData=classDao.findAll(null);
					classTable.setModel(new ClassTableModel(classData));
					resetting();
				}else {
					JOptionPane.showMessageDialog(null, Tools.getLable("删除失败,未知错误"));
				}
			}else {
				return;
			}
		}else {
			JOptionPane.showMessageDialog(null, Tools.getLable("请先选择一个你要删除的班级"));
		}
	}
	private void modify() {
		if (classSelectedRow!=-1) {
			String name=Tools.isEmpty(classNameDownText.getText());
			if (!name.equals("")) {
				if (JOptionPane.showConfirmDialog(null, Tools.getLable("是否确定要修改该班级？"), "修改班级",
						JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
					if (classDao.findByName(name)==null) {
						String info = Tools.isEmpty(classInfoTextArea.getText());
						S_class clazz=classData.get(classSelectedRow);
						clazz.setName(name);
						clazz.setInfo(info);
						if (classDao.modify(clazz)>0) {
							JOptionPane.showMessageDialog(null, Tools.getLable("修改成功"));
							classData=classDao.findAll(null);
							classTable.setModel(new ClassTableModel(classData));
							resetting();
						} else {
							JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,未知错误"));
						}
					}else {
						JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,该班级已存在"));
					}
				}else {
					return;
				}
			}else {
				JOptionPane.showMessageDialog(null, Tools.getLable("修改失败,班级名称不能为空"));
			}
		}else {
			JOptionPane.showMessageDialog(null, Tools.getLable("请先选择一个你要修改的班级"));
		}
	}
}
