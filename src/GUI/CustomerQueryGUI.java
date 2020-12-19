/**
 * 
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI_Comply.Mananger_Empty;
import GUI_Comply.UserQuery_Emptyroom;
import util.ManageJdbc;
import util.UserJdbc;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月27日下午7:46:01
 */
public class CustomerQueryGUI extends JFrame {
	public CustomerQueryGUI() {
		setSize(500,400);
		setLocation(500,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4,1));	
		Customer_Query();
	}
	public void Customer_Query() {
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel(new GridLayout(3,1));
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		JPanel panel_5 = new JPanel(new BorderLayout());
		
		//1
		JLabel label_1 = new JLabel("<html><h1>客户信息查询界面</h1></html>");
	
		panel_1.add(label_1);
		
		add(panel_1);

		
		//2
		JButton but1 = new JButton("电话查询");
		panel_2.add(but1);
		
		but1.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//跳转到新窗口
				QueryPhoneGUI queryPhoneGUI = new QueryPhoneGUI();
				dispose();
				queryPhoneGUI.setVisible(true);
				
			}
		});
		
		//3
		JButton but2 = new JButton("身份证号查询  ");
		panel_2.add(but2);
		
		but2.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//跳转到新窗口
				QueryIdGUI queryIdGUI = new QueryIdGUI();
				dispose();
				queryIdGUI.setVisible(true);
				
			}
		});
		
		//4
		JButton but3 = new JButton("显示所有客户信息 ");
		panel_2.add(but3);
		panel_3.add(panel_2);
		
		panel_5.add(panel_3,BorderLayout.CENTER);
		add(panel_5);
		
		but3.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//连接数据库查询对应数据
				String[] coluNames = {"UserNo","UserId","UserName","UserPhone","CheckInTime","RoomId"};
				ManageJdbc mj = new ManageJdbc();
				List<List<Object>> arg = mj.All_User();
				if(arg==null||arg.size()==0) {
					JOptionPane.showMessageDialog(null, "无用户");
				}else {
					Object[][] data = new Object[100][6];
					for(int i= 0;i<arg.size();i++) {
						for(int j = 0;j<arg.get(i).size();j++) {
							//System.out.print(arg.get(i).get(j)+"\t"+"\t");
							data[i][j] = arg.get(i).get(j);
						}
					}
					Mananger_Empty ue = new Mananger_Empty(data, coluNames);
					dispose();
					ue.setVisible(true);
				}
			}
		});
		
		//5
		JButton but4 = new JButton("返回 ");
		panel_4.add(but4);

		add(panel_4);
		
		but4.addMouseListener(new MouseAdapter()  {
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
