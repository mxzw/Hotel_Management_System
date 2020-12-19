


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import GUI.RegistGUI;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月26日下午12:11:07
 */
public class test_gui extends JFrame{
	public test_gui(){
		setSize(800,600);
	}
	public static void main(String []args) {
		//顶层
		JFrame frame = new JFrame();
		//设置窗口大小
		frame.setSize(500,400);
		//设置窗口位置
		frame.setLocation(500,50);
		//frame.pack();
		//设置窗口默认关闭方式
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//规定布局方式为2行一列
		//frame.setLayout(new FlowLayout());
		frame.setLayout(new GridLayout(1,1));
		//frame.setLayout(new BorderLayout());
		
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
		JLabel label = new JLabel("<html><h1>Eon宾馆管理系统</h1></html>");
		//label.setSize(200,100);
		//label.setLocation(350,10);
		
		panel_11.add(label);
		//frame.add(panel_1);
		panel_2.add(panel_11);
		
		
		//2.1
		JLabel label_1 = new JLabel("账号:");
		JPanel temp_1 = new JPanel();
		temp_1.add(label_1);
		JTextField text_1 = new JTextField(18);
		/*
		//获取用户事件（匿名类）
		text_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获得文本框中的内容
				//System.out.println(e.getSource());  返回的是一个包含信息的对象
				JTextField source =(JTextField)e.getSource();
				//System.out.println(source.getText());
				String account  = source.getText();
				
			}
		});
		*/
		panel_21.add(temp_1);
		panel_21.add(text_1);
		
		panel_21_22.add(panel_21);
		
		//2.2
		JLabel label_2 = new JLabel("密码:");
		JPanel temp_2 = new JPanel();
		temp_2.add(label_2);
		//定义密码框
		JPasswordField text_2 = new JPasswordField(18);
	
		/*
		//获取用户事件（匿名类）
		text_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取账号文本框中的内容
				String account = text_1.getText();
				//获取密码框中的内容
				JPasswordField source =(JPasswordField) e.getSource();
				String passwd = new String(source.getPassword());
				System.out.println(account+"+"+passwd);
				
				//连接数据库，实现登录查询
				
			}
		});
		*/
		panel_22.add(temp_2);
		panel_22.add(text_2);
		
		panel_21_22.add(panel_22);
		
		panel_2.add(panel_21_22);
		
		//2.3
		JButton but1 = new JButton("重置");
		JButton but2 = new JButton("登录");
		panel_23.add(but1);
		panel_23.add(but2);
			
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
		
		//事件监听--登录
		but2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("登录")) {
					String account = text_1.getText();
					String passwd = new String(text_2.getPassword());
					System.out.println("登录");
					//连接数据库进行登录验证
				}
				
			}
		});
		
		
		panel_23_24.add(panel_23);
		
		//2.4
		JLabel label_3 = new JLabel("<html><u>注册</u><html>");
		panel_24.add(label_3);
		
		panel_23_24.add(panel_24);
		
		panel_2.add(panel_23_24);
		
		frame.add(panel_2);
		
		label_3.addMouseListener(new MouseAdapter()	 {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//单击了该标签
				//转到注册页面
				RegistGUI registGUI = new RegistGUI();
				frame.dispose();
				registGUI.setVisible(true);
			}
		});
		
		//显示窗口设置
		frame.setVisible(true);
		
	}
	
}


/*
but1.setActionCommand("重置");
but2.setActionCommand("登录");
MyActionListener myActionListener1 = new MyActionListener();
MyActionListener myActionListener2 = new MyActionListener();

but1.addActionListener(myActionListener1);
but2.addActionListener(myActionListener2);
*/

// class MyActionListener implements ActionListener{
/*设置按键的信息
		but1.setActionCommand("重置");
		but2.setActionCommand("登录");*/
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */

/*	@Override
	public void actionPerformed(ActionEvent e) {
		//JButton temp_but = (JButton) e.getSource();
		
		if(e.getActionCommand().equals("登录")) {
			System.out.println("登录");
		}else if(e.getActionCommand().equals("重置")) {
			
			System.out.println(e.getActionCommand());
		}
		
	}
	
	
}
*/