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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.ManageJdbc;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月27日下午8:00:07
 */
public class RenewRoomGUI extends JFrame{
	public RenewRoomGUI() {
		setSize(500,400);
		//设置窗口位置
		setLocation(500,50);
		//设置窗口默认关闭方式
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Renew_Room();
		
	}
	public void Renew_Room() {
		setLayout(new GridLayout(1,1));
		//一个大面板，5个小面板,11单独为一个面板，21，22组成一个面板，23，24组成一个面板
		JPanel panel_11 = new JPanel();
		JPanel panel_2 = new JPanel(new GridLayout(3,1));
		JPanel panel_21 = new JPanel(new FlowLayout());
		JPanel panel_22 = new JPanel(new FlowLayout());
		JPanel panel_21_22 = new JPanel(new GridLayout(2,1));
		JPanel panel_23 = new JPanel(new FlowLayout());
		JPanel panel_24 = new JPanel(new FlowLayout());
		JPanel panel_23_24 = new JPanel(new GridLayout(2,1));
		
		//1.1 显示
		JLabel label = new JLabel("<html><h1>客房续费页面</h1></html>");
		panel_11.add(label);
		panel_2.add(panel_11);
		
		
		//2.1
		JLabel label_1 = new JLabel("续费房号:");
		JPanel temp_1 = new JPanel();
		temp_1.add(label_1);
		JTextField text_1 = new JTextField(18);
		panel_21.add(temp_1);
		panel_21.add(text_1);
		
		panel_21_22.add(panel_21);
		
		//2.2
		JLabel label_2 = new JLabel("增加天数:");
		JPanel temp_2 = new JPanel();
		temp_2.add(label_2);
		JTextField text_2 = new JTextField(18);
		panel_22.add(temp_2);
		panel_22.add(text_2);
		
		panel_21_22.add(panel_22);
		
		panel_2.add(panel_21_22);
		
		//设置入住天数只能为数字
		text_2.addKeyListener(new KeyAdapter() {
			
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
		
		//2.3
		JButton but1 = new JButton("重置");
		JButton but2 = new JButton("完成");
		panel_23.add(but1);
		panel_23.add(but2);

		panel_23_24.add(panel_23);
		
		//事件监听--重置
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("重置")) {
					text_1.setText(null);
					text_2.setText(null);
					System.out.println("重置");
				}
			}
		});	
		
		but2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//入住登记
				String id = text_1.getText();
				int checktime = Integer.parseInt(text_2.getText());
				//加载到数据库
				ManageJdbc mj = new ManageJdbc();
				int row = mj.Renew_Room(id, checktime);
				if(row>=0) {
					JOptionPane.showMessageDialog(null, "续费成功");
					ManageOperaGUI manageOperaGUI = new ManageOperaGUI();
					dispose();
					manageOperaGUI.setVisible(true);
				}
				
			}
		});
		
		//2.4
		JLabel label_3 = new JLabel("<html><u>返回</u><html>");
		panel_24.add(label_3);
		
		panel_23_24.add(panel_24);
		
		panel_2.add(panel_23_24);
		
		add(panel_2);
		
		label_3.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//返回上一窗口
				ManageQueryGUI manageQueryGUI = new ManageQueryGUI();
				dispose();
				manageQueryGUI.setVisible(true);
				
			}
		});
	}
}
