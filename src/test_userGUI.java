
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月26日下午12:11:07
 */
public class test_userGUI{
	public static void main(String []args) {
		//顶层
		JFrame frame = new JFrame();
		//设置窗口大小
		frame.setSize(500,400);
		//设置窗口位置
		frame.setLocation(500,50);
		//设置窗口默认关闭方式
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//规定布局方式为2行一列
		//frame.setLayout(new FlowLayout());
		frame.setLayout(new GridLayout(3,1));
		//frame.setLayout(new BorderLayout());
		
		//1个大面板，3个小面板
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		
		//1
		JLabel label_1 = new JLabel("<html><h1>欢迎访问Eons宾馆</h1></html>");
		JPanel panel_11 = new JPanel();
		panel_11.add(label_1);
		
		frame.add(panel_11);
		
		//2
		JButton but1 = new JButton("1. 房间信息查询");
		panel_2.add(but1);
		
		frame.add(panel_2);
		
		//3
		JButton but2 = new JButton("2. 入住房间登记");
		panel_3.add(but2);
		
		frame.add(panel_3);
		
		
		//显示窗口设置
		frame.setVisible(true);
		
	}
}
