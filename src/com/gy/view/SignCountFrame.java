package com.gy.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.VerticalAlignment;

import com.gy.bean.S_attendance;
import com.gy.dao.SattendanceDao;
import com.gy.dao.ScourseDao;
import com.gy.dao.impl.SattendanceDaoImpl;
import com.gy.dao.impl.ScourseDaoImpl;
import com.gy.talemodel.SignCountTableModel;
import com.gy.tools.Chooser;
import com.gy.tools.Tools;

public class SignCountFrame {
	private SattendanceDao attendanceDao;
	private ScourseDao courseDao;
	private String[] courseNames;
	private JTable signCountTable;
	private int signCountSelectedRow = -1;
	private List<S_attendance> signCountData;
	private JComboBox<String> courseComboBox;
	private JTextField dateText;
	private JScrollPane scrollPane;
	
	public SignCountFrame(JDesktopPane desktopPane) {
		attendanceDao=new SattendanceDaoImpl();
		courseDao=new ScourseDaoImpl();
		JInternalFrame internalFrame = new JInternalFrame("\u7B7E\u5230\u4FE1\u606F\u7EDF\u8BA1\u60C5\u51B5");
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		internalFrame
				.setFrameIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7B7E\u5230.png")));
		internalFrame.setBounds(14, 13, 987, 661);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);
		
		JLabel label_6 = new JLabel("\u8BFE\u7A0B\u540D\u5B57\uFF1A");
		label_6.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u65B0\u4EBA\u8BFE\u7A0B.png")));
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("宋体", Font.BOLD, 25));
		label_6.setBounds(52, 25, 154, 44);
		internalFrame.getContentPane().add(label_6);
		
		JLabel label = new JLabel("\u65E5\u671F\uFF1A");
		label.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u65E5\u671F.png")));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 25));
		label.setBounds(452, 25, 110, 44);
		internalFrame.getContentPane().add(label);
		
		courseNames=Tools.getCourseNames(courseDao.findAll(null,0));
		courseComboBox = new JComboBox(courseNames);
		courseComboBox.setForeground(Color.BLUE);
		courseComboBox.setFont(new Font("宋体", Font.BOLD, 22));
		courseComboBox.setBounds(195, 28, 200, 40);
		internalFrame.getContentPane().add(courseComboBox);
		
		Chooser chooser=Chooser.getInstance();
		dateText = new JTextField();
		chooser.register(dateText);
		dateText.setForeground(Color.BLUE);
		dateText.setFont(new Font("宋体", Font.BOLD, 22));
		dateText.setColumns(10);
		dateText.setBounds(540, 29, 200, 40);
		internalFrame.getContentPane().add(dateText);
		

		JButton findButton = new JButton("\u67E5 \u8BE2");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select();
			}
		});
		findButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u641C\u7D22.png")));
		findButton.setForeground(Color.BLUE);
		findButton.setFont(new Font("宋体", Font.BOLD, 25));
		findButton.setBounds(760, 25, 158, 50);
		internalFrame.getContentPane().add(findButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 88, 856, 414);
		internalFrame.getContentPane().add(scrollPane);

		signCountData=attendanceDao.findAll(null,null,null);
		signCountTable = new JTable(new SignCountTableModel(attendanceDao,signCountData));
		signCountTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		signCountTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		signCountTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		signCountTable.setRowHeight(51);
		scrollPane.setViewportView(signCountTable);
		

		JButton listButton = new JButton("\u5217\u8868\u663E\u793A");
		listButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(signCountTable);
			}
		});
		listButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5217\u8868.png")));
		listButton.setForeground(Color.BLUE);
		listButton.setFont(new Font("宋体", Font.BOLD, 25));
		listButton.setBounds(95, 548, 190, 50);
		internalFrame.getContentPane().add(listButton);
		
		JButton ZZTButton = new JButton("\u67F1\u72B6\u56FE\u663E\u793A");
		ZZTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zzt();
			}
		});
		ZZTButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u67F1\u72B6\u56FE.png")));
		ZZTButton.setForeground(Color.BLUE);
		ZZTButton.setFont(new Font("宋体", Font.BOLD, 25));
		ZZTButton.setBounds(390, 548, 190, 50);
		internalFrame.getContentPane().add(ZZTButton);
		
		JButton BZTButton = new JButton("\u997C\u72B6\u56FE\u663E\u793A");
		BZTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bzt();
			}
		});
		BZTButton.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u997C\u72B6\u56FE.png")));
		BZTButton.setForeground(Color.BLUE);
		BZTButton.setFont(new Font("宋体", Font.BOLD, 25));
		BZTButton.setBounds(688, 548, 190, 50);
		internalFrame.getContentPane().add(BZTButton);
		
		ListSelectionModel rowSelectionModel = signCountTable.getSelectionModel();
		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 只处理鼠标释放
				if (e.getValueIsAdjusting()) {
					return;
				}
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				signCountSelectedRow = lsm.getMinSelectionIndex();
				if (signCountSelectedRow < 0) {
					return;
				}
			}
		});
	}

	private void select() {
		String cname=(String) courseComboBox.getSelectedItem();
		String date=Tools.isEmpty(dateText.getText());
		if (cname.equals("-请选择-")&&date.equals("")) {
			signCountData=attendanceDao.findAll(null,null,null);
			signCountTable.setModel(new SignCountTableModel(attendanceDao,signCountData));
			courseComboBox.setSelectedIndex(0);
			dateText.setText("");
		}else if (!cname.equals("-请选择-")&&date.equals("")) {
			signCountData=attendanceDao.findAll(cname,null,null);
			signCountTable.setModel(new SignCountTableModel(attendanceDao,signCountData));
			courseComboBox.setSelectedIndex(0);
			dateText.setText("");
		}else if (cname.equals("-请选择-")&&!date.equals("")) {
			signCountData=attendanceDao.findAll(null,date,null);
			signCountTable.setModel(new SignCountTableModel(attendanceDao,signCountData));
			courseComboBox.setSelectedIndex(0);
			dateText.setText("");
		}else {
			signCountData=attendanceDao.findAll(cname,date,null);
			signCountTable.setModel(new SignCountTableModel(attendanceDao,signCountData));
			courseComboBox.setSelectedIndex(0);
			dateText.setText("");
		}
	}

	private void zzt() {
		if (signCountSelectedRow!=-1) {
			SignCountTableModel sctm=(SignCountTableModel) signCountTable.getModel();
			DefaultCategoryDataset cd=new DefaultCategoryDataset();
			cd.addValue((int)sctm.getValueAt(signCountSelectedRow,1),"签到人数","签到人数");
			cd.addValue((int)sctm.getValueAt(signCountSelectedRow,2),"缺席人数","缺席人数");
			cd.addValue((int)sctm.getValueAt(signCountSelectedRow,3),"选课人数","选课人数");
			JFreeChart chart=ChartFactory.createBarChart3D("签到统计管理","签到统计","人数（个）",cd,PlotOrientation.VERTICAL,true,true,false);
			chart.getTitle().setFont(new Font("宋体",Font.BOLD,25));
			chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,25));
			chart.setBorderVisible(true);
			String date=Tools.changeDate((String)sctm.getValueAt(signCountSelectedRow,4));
			TextTitle subTitle=new TextTitle(date+","+(String)sctm.getValueAt(signCountSelectedRow,0)+"课程的签到情况统计(签到人数，缺席人数，选课人数)");
			subTitle.setFont(new Font("宋体",Font.BOLD,20));
			subTitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
			chart.addSubtitle(subTitle);
			CategoryAxis categoryAxis=chart.getCategoryPlot().getDomainAxis();
			categoryAxis.setLabelFont(new Font("微软雅黑",Font.PLAIN,20));
			categoryAxis.setTickLabelFont(new Font("微软雅黑",Font.PLAIN,20));
			chart.getCategoryPlot().getRangeAxis().setLabelFont(new Font("微软雅黑",Font.PLAIN,20));
			ChartPanel panel=new ChartPanel(chart);
			scrollPane.setViewportView(panel);
		}else {
			JOptionPane.showMessageDialog(null, Tools.getLable("请先选择一条你要查看的签到记录"));
		}
	}

	private void bzt() {
		if (signCountSelectedRow!=-1) {
			SignCountTableModel sctm=(SignCountTableModel) signCountTable.getModel();
			DefaultPieDataset pd=new DefaultPieDataset();
			pd.setValue("签到人数",(int)sctm.getValueAt(signCountSelectedRow,1));
			pd.setValue("缺勤人数",(int)sctm.getValueAt(signCountSelectedRow,2));
			pd.setValue("选课人数",(int)sctm.getValueAt(signCountSelectedRow,3));
			JFreeChart chart=ChartFactory.createPieChart3D("签到统计管理",pd,true,true,false);
			chart.getTitle().setFont(new Font("宋体",Font.BOLD,25));
			chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,25));
			chart.setBorderVisible(true);
			String date=Tools.changeDate((String)sctm.getValueAt(signCountSelectedRow,4));
			TextTitle subTitle=new TextTitle(date+","+(String)sctm.getValueAt(signCountSelectedRow,0)+"课程的签到情况统计(签到人数，缺席人数，选课人数)");
			subTitle.setFont(new Font("宋体",Font.BOLD,20));
			subTitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
			chart.addSubtitle(subTitle);
			PiePlot plot=(PiePlot) chart.getPlot();
			plot.setLabelFont(new Font("微软雅黑",Font.PLAIN,20));
			ChartPanel panel=new ChartPanel(chart);
			scrollPane.setViewportView(panel);
		}else {
			JOptionPane.showMessageDialog(null, Tools.getLable("请先选择一条你要查看的签到记录"));
		}
	}
}
