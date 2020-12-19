/**
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月27日下午7:41:08
 */
public class ManageQueryGUI extends JFrame{
	public ManageQueryGUI() {
		setSize(500,400);
		setLocation(500,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4,1));
		Management_Query();
	}
	public void Management_Query() {
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		
		//1
		JLabel label_1 = new JLabel("<html><h1>房间/客户信息查询界面</h1></html>");
		panel_1.add(label_1);
		
		add(panel_1);
		
		//2
		JButton but1 = new JButton("1. 房间信息查询");
		panel_2.add(but1);
		
		add(panel_2);
		but1.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//跳转到新窗口
				UserQueryGUI userQueryGUI = new UserQueryGUI(false);
				dispose();
				userQueryGUI.setVisible(true);
				
			}
		});
		
		//3
		JButton but2 = new JButton("2. 客户信息查询");
		panel_3.add(but2);
		add(panel_3);
		
		but2.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//跳转到新窗口
				CustomerQueryGUI customerQueryGUI = new CustomerQueryGUI();
				dispose();
				customerQueryGUI.setVisible(true);

			}
		});
		//4
		JButton but3 = new JButton("返回");
		panel_4.add(but3);
		//panel_4.add(panel_3);
		
		add(panel_4);
		
		but3.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//返回上一窗口
				ManageOperaGUI manageOperaGUI = new ManageOperaGUI();
				dispose();
				manageOperaGUI.setVisible(true);
				
			}
		});
		
	}
}
