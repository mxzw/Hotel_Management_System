
package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月26日下午3:21:12
 */
public class UserGUI extends JFrame{
	public UserGUI() {	
		//设置窗口大小
		setSize(500,400);
		//设置窗口位置
		setLocation(500,50);
		//设置窗口默认关闭方式
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//规定布局方式为2行一列
		setLayout(new GridLayout(3,1));
		UserLayout();
	}
	public void UserLayout() {
		//1个大面板，3个小面板
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel(new FlowLayout());
		JPanel panel_3 = new JPanel(new FlowLayout());
		
		//1
		JLabel label_1 = new JLabel("<html><h1>欢迎访问Eons宾馆</h1></html>");
		JPanel panel_11 = new JPanel();
		panel_11.add(label_1);
		
		add(panel_11);
		
		//2
		JButton but1 = new JButton("1. 房间信息查询");
		panel_2.add(but1);
		
		add(panel_2);
		
		//事件监听-1
		but1.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				//单击房间查询按钮
				//跳转到对应页面
				UserQueryGUI userQueryGUI = new UserQueryGUI(true);
				dispose();
				userQueryGUI.setVisible(true);
				
			}
		});
		
		//3
		JButton but2 = new JButton("2. 入住房间登记");
		panel_3.add(but2);
		
		add(panel_3);	
		
		//事件监听-1
		but2.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				//单击房间查询按钮
				//跳转到对应页面
				CheckInGUI checkInGUI = new CheckInGUI();
				dispose();
				checkInGUI.setVisible(true);
			}
		});		
		
	}
}

	
