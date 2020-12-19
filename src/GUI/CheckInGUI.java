/**
 * 
 */
package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI_Comply.ChickIn_Empty;
import GUI_Comply.UserQuery_Emptyroom;
import util.UserJdbc;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月26日下午4:09:52
 */
public class CheckInGUI extends JFrame {
	public CheckInGUI() {
		setSize(500,400);
		setLocation(500,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(7,1));
		CheckInLayout();
		
	}
	public void CheckInLayout() {
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel(new FlowLayout());
		JPanel panel_3 = new JPanel(new FlowLayout());
		JPanel panel_4 = new JPanel(new FlowLayout());
		JPanel panel_5 = new JPanel(new FlowLayout());
		JPanel panel_51 = new JPanel(new FlowLayout());
		JPanel panel_52 = new JPanel();
		JPanel panel_6 = new JPanel(new FlowLayout());
		JPanel panel_7 = new JPanel(new FlowLayout());
		//1
		JLabel label_1 = new JLabel("<html><h1>Eons宾馆入住登记</h1></html>");
		panel_1.add(label_1);
		
		add(panel_1);
		
		//2
		JLabel label_2 = new JLabel("姓        名:");
		JPanel temp_2 = new JPanel();
		temp_2.add(label_2);
		JTextField text_2 = new JTextField(18);
		panel_2.add(temp_2);
		panel_2.add(text_2);
		
		add(panel_2);
		
		//3
		JLabel label_3 = new JLabel("身份证号:");
		JPanel temp_3 = new JPanel();
		temp_3.add(label_3);
		JTextField text_3 = new JTextField(18);
		panel_3.add(temp_3);
		panel_3.add(text_3);
		
		add(panel_3);
		
		//4
		JLabel label_4 = new JLabel("电话号码:");
		JPanel temp_4 = new JPanel();
		temp_4.add(label_4);
		JTextField text_4 = new JTextField(18);
		panel_4.add(temp_4);
		panel_4.add(text_4);
		
		add(panel_4);
		
		//5
		JLabel label_5 = new JLabel("入住天数:");
		JPanel temp_5 = new JPanel();
		temp_5.add(label_5);
		JTextField text_5 = new JTextField(9);
		panel_51.add(temp_5);
		panel_51.add(text_5);
		
		JButton but5 = new JButton("空房查看");
		panel_52.add(but5);
		
		panel_5.add(panel_51);
		panel_5.add(panel_52);
		
		add(panel_5);
		
		but5.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//跳转到新窗口
				String[] coluNames = {"RoomId","RoomName","RoomPrice","RoomState"};
				UserJdbc uj = new UserJdbc();
				List<List<Object>> arg = uj.Empty_Room();
				Object[][] data = new Object[100][4];
				for(int i= 0;i<arg.size();i++) {
					for(int j = 0;j<arg.get(i).size()-1;j++) {
						//System.out.print(arg.get(i).get(j)+"\t"+"\t");
						data[i][j] = arg.get(i).get(j);
					}
				}
				ChickIn_Empty ue = new ChickIn_Empty(data, coluNames);
				//dispose();
				ue.setVisible(true);
				
			}
		});
		
		//设置入住天数只能为数字
		text_5.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// 首先得获取到键盘按下的字符
				// 然后进行判断是否是数字键，如果不是，则取消这次操作
				// public void consume()使用此事件，以便不会按照默认的方式由产生此事件的源代码来处理此事件。
				char c = e.getKeyChar();
				if (!(c >= '0' && c <= '9')) {
					e.consume();
				}
			}
		});
		
		//6
		JLabel label_6 = new JLabel("入住房号:");
		JPanel temp_6 = new JPanel();
		temp_6.add(label_6);
		JTextField text_6 = new JTextField(18);
		panel_6.add(temp_6);
		panel_6.add(text_6);
		
		add(panel_6);
		
		//7
		JButton but71 = new JButton("返回");
		JButton but72 = new JButton("完成");
		panel_7.add(but71);
		panel_7.add(but72);
		
		add(panel_7);
		
		but71.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				//返回上一页面
				UserGUI userGUI = new UserGUI();
				dispose();
				userGUI.setVisible(true);
			}
		});
		
		but72.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//入住登记
				String name = text_2.getText();
				String id = text_3.getText();
				String phone = text_4.getText();
				int checktime = Integer.parseInt(text_5.getText());
				String roomID = text_6.getText();
				//加载到数据库
				UserJdbc uj = new UserJdbc();
				int row = uj.Check_In(name, id, phone, roomID, checktime);
				if(row != 0) {
					JOptionPane.showMessageDialog(null, "入住成功");
					UserGUI userGUI = new UserGUI();
					dispose();
					userGUI.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "入住失败");
				}
				
			}
		});
		
	}
}
