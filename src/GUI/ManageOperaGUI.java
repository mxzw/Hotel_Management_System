/**
 * 
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
 * @Date 2020年11月27日下午6:51:04
 */
public class ManageOperaGUI extends JFrame {
	public  ManageOperaGUI() {
		setSize(500,400);
		setLocation(500,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));	
		Manage_Operarte();
	}
	public void Manage_Operarte() {
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel(new GridLayout(3,1));
		JPanel panel_3 = new JPanel();
		JPanel panel_5 = new JPanel(new BorderLayout());
		
		//1
		JLabel label_1 = new JLabel("<html><h1>Eons宾馆管理系统</h1></html>");
	
		panel_1.add(label_1);
		
		add(panel_1);	
		
		//2
		JButton but1 = new JButton("1. 房间/客户信息查询");
		panel_2.add(but1);
		
		but1.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//跳转到新窗口
				ManageQueryGUI manageQueryGUI = new ManageQueryGUI();
				dispose();
				manageQueryGUI.setVisible(true);
				
			}
		});
		
		
		//3
		JButton but2 = new JButton("2. 退房结算 ");
		panel_2.add(but2);
		
		but2.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//跳转到新窗口
				CheckOutGUI checkOutGUI = new CheckOutGUI();
				dispose();
				checkOutGUI.setVisible(true);
				
			}
		});
		
		//4
		JButton but3 = new JButton("3. 客房续费 ");
		panel_2.add(but3);
		panel_3.add(panel_2);
		
		panel_5.add(panel_3,BorderLayout.CENTER);
		add(panel_5);
		
		but3.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//跳转到新窗口
				RenewRoomGUI renewRoomGUI = new RenewRoomGUI();
				dispose();
				renewRoomGUI.setVisible(true);
			}
		});
		
		

	}
	
}
