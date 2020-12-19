/**
 * 
 */
package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI_Comply.UserQuery_Emptyroom;
import util.ManageJdbc;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月27日下午7:56:42
 */
public class CheckOutGUI extends JFrame{
	public CheckOutGUI() {
		setSize(300,200);
		setLocation(500,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		Check_Out();
	}
	public void Check_Out() {
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel(new FlowLayout());
		
		//1
		JLabel label_1 = new JLabel("身份证号:");
		JPanel temp_1 = new JPanel();
		temp_1.add(label_1);
		JTextField text_1 = new JTextField(18);
		panel_1.add(temp_1);
		panel_1.add(text_1);
		
		add(panel_1);
		
		//2
		JButton but1 = new JButton("返回");
		panel_2.add(but1);
		
		
		but1.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//返回上一窗口
				ManageOperaGUI manageOperaGUI = new ManageOperaGUI();
				dispose();
				manageOperaGUI.setVisible(true);
				
			}
		});
		//3
		JButton but2 = new JButton("完成");
		panel_2.add(but2);
		
		add(panel_2);
		but2.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//返回上一窗口
				String id = text_1.getText();
				//连接数据库查询相应结果
				ManageJdbc mj = new ManageJdbc();
				int row = mj.Check_out(id);
				if(row>=0) {
					JOptionPane.showMessageDialog(null, "退房成功");
					ManageOperaGUI manageOperaGUI = new ManageOperaGUI();
					dispose();
					manageOperaGUI.setVisible(true);
				}
				
			}
		});
	}
}
