package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.gy.bean.S_class;
import com.gy.dao.SclassDao;
import com.gy.dao.impl.SclassDaoImpl;
import com.gy.tools.Tools;

public class AddClassFrame {
	private SclassDao classDao;
	private JTextField classNameText;
	private JTextArea classInfoTextArea;

	public AddClassFrame(JDesktopPane desktopPane) {
		classDao = new SclassDaoImpl();
		JInternalFrame internalFrame = new JInternalFrame("\u6DFB\u52A0\u73ED\u7EA7\u4FE1\u606F");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame.setFrameIcon(
				new ImageIcon(AddClassFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		internalFrame.setBounds(210, 75, 678, 425);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		JLabel label_1 = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label_1.setIcon(new ImageIcon(AddClassFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("宋体", Font.BOLD, 25));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(85, 25, 154, 44);
		internalFrame.getContentPane().add(label_1);

		classNameText = new JTextField();
		classNameText.setForeground(Color.BLUE);
		classNameText.setFont(new Font("宋体", Font.BOLD, 25));
		classNameText.setBounds(231, 30, 240, 40);
		internalFrame.getContentPane().add(classNameText);
		classNameText.setColumns(10);

		JLabel label = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		label.setIcon(new ImageIcon(AddClassFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 25));
		label.setBounds(85, 98, 154, 44);
		internalFrame.getContentPane().add(label);

		classInfoTextArea = new JTextArea();
		classInfoTextArea.setLineWrap(true);
		classInfoTextArea.setForeground(Color.BLUE);
		classInfoTextArea.setFont(new Font("Monospaced", Font.BOLD, 22));
		classInfoTextArea.setBounds(231, 112, 240, 192);
		internalFrame.getContentPane().add(classInfoTextArea);

		JButton yesButton = new JButton("\u63D0\u4EA4");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		yesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		yesButton.setFont(new Font("宋体", Font.BOLD, 25));
		yesButton.setForeground(Color.BLUE);
		yesButton.setBounds(200, 320, 120, 50);
		internalFrame.getContentPane().add(yesButton);

		JButton resettingButton = new JButton("\u91CD\u7F6E");
		resettingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetting();
			}
		});
		resettingButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u91CD\u7F6E.png")));
		resettingButton.setForeground(Color.BLUE);
		resettingButton.setFont(new Font("宋体", Font.BOLD, 25));
		resettingButton.setBounds(385, 320, 120, 50);
		internalFrame.getContentPane().add(resettingButton);
	}

	private void add() {
		String name = Tools.isEmpty(classNameText.getText());
		if (!name.equals("")) {
			if (classDao.findByName(name)==null) {
				String info = Tools.isEmpty(classInfoTextArea.getText());
				if (classDao.create(new S_class(name, info)) > 0) {
					JOptionPane.showMessageDialog(null, Tools.getLable("添加成功"));
					resetting();
				} else {
					JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,未知错误"));
				}
			}else {
				JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,该班级已存在"));
			}
		}else {
			JOptionPane.showMessageDialog(null, Tools.getLable("添加失败,班级名称不能为空"));
		}
	}

	private void resetting() {
		classNameText.setText("");
		classInfoTextArea.setText("");
	}

}
