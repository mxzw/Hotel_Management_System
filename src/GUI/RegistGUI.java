
package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import util.BasisJdbc;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月26日下午3:13:56
 */
public class RegistGUI extends JFrame{
	public RegistGUI() {
		setSize(500,400);
		//设置窗口位置
		setLocation(500,50);
		//设置窗口默认关闭方式
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RegistLayout();
		
	}
	public void RegistLayout() {
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
		JLabel label = new JLabel("<html><h1>Eon宾馆注册页面</h1></html>");
		panel_11.add(label);
		panel_2.add(panel_11);
		
		
		//2.1
		JLabel label_1 = new JLabel("账号:");
		JPanel temp_1 = new JPanel();
		temp_1.add(label_1);
		JTextField text_1 = new JTextField(18);
		panel_21.add(temp_1);
		panel_21.add(text_1);
		
		panel_21_22.add(panel_21);
		
		//2.2
		JLabel label_2 = new JLabel("密码:");
		JPanel temp_2 = new JPanel();
		temp_2.add(label_2);
		JPasswordField text_2 = new JPasswordField(18);
		panel_22.add(temp_2);
		panel_22.add(text_2);
		
		panel_21_22.add(panel_22);
		
		panel_2.add(panel_21_22);
		
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
		
		//事件监听--注册
		but2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("完成")) {
					String account = text_1.getText();
					String passwd = new String(text_2.getPassword());
					System.out.println("完成");
					//连接数据库进行注册登记
					List<Object> list = new ArrayList();
					list.add(account);
					list.add(passwd);
					int row = new BasisJdbc().User_Regist(list);
					if(row<=0) {
						JOptionPane.showMessageDialog(null, "注册失败");
					}else {
						JOptionPane.showMessageDialog(null, "注册成功");
						LoginGUI loginGUI = new LoginGUI();
						dispose();
						loginGUI.setVisible(true);
					}
				}
				
			}
		});		
		
		//2.4
		JLabel label_3 = new JLabel("<html><u>返回</u><html>");
		panel_24.add(label_3);
		
		panel_23_24.add(panel_24);
		
		panel_2.add(panel_23_24);
		
		add(panel_2);
		
		label_3.addMouseListener(new MouseAdapter()	 {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//单击了该标签
				//转到注册页面
				LoginGUI loginGUI = new LoginGUI();
				dispose();
				loginGUI.setVisible(true);
			}
		});
		
	}
}
