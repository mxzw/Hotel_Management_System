/**
 * 
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import GUI_Comply.UserQuery_Emptyroom;
import util.UserJdbc;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月26日下午4:22:31
 */
public class UserQueryGUI extends JFrame {
	private boolean flag;
	public UserQueryGUI(boolean flag) {
		setSize(500,400);
		setLocation(500,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(5,1));		
		UserQueryLayout();
		this.flag = flag;
	}
	public void UserQueryLayout() {
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		JPanel panel_5 = new JPanel();
		
		//1
		JLabel label_1 = new JLabel("<html><h1>Eons宾馆入住登记</h1></html>");
		panel_1.add(label_1);
		
		add(panel_1);
		
		//2
		JButton but2 = new JButton("1. 空房间查询    ");
		panel_2.add(but2);
		
		add(panel_2);
		
		but2.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//跳转到新窗口，连接数据库查询显示对应结果
				
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
				UserQuery_Emptyroom ue = new UserQuery_Emptyroom(data, coluNames,flag);
				dispose();
				ue.setVisible(true);
			}
		});
		
		//3
		JButton but3 = new JButton("2. 按房间号查询 ");
		panel_3.add(but3);
		
		add(panel_3);
		
		but3.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//跳转到按房间号查询页面
				QueryIDRoomGUI queryIDRoomGUI = new QueryIDRoomGUI();
				dispose();
				queryIDRoomGUI.setVisible(true);
				
			}
		});
		
		//4
		JButton but4 = new JButton("3. 显示所有房间  ");
		panel_4.add(but4);
		
		add(panel_4);
		but4.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//跳转到新窗口，连接数据库查询显示对应结果
				String[] coluNames = {"RoomId","RoomName","RoomPrice","RoomState"};
				UserJdbc uj = new UserJdbc();
				List<List<Object>> arg = uj.All_Room();
				Object[][] data = new Object[100][4];
				for(int i= 0;i<arg.size();i++) {
					for(int j = 0;j<arg.get(i).size()-1;j++) {
						//System.out.print(arg.get(i).get(j)+"\t"+"\t");
						data[i][j] = arg.get(i).get(j);
					}
				}
				UserQuery_Emptyroom ue = new UserQuery_Emptyroom(data, coluNames,flag);
				dispose();
				ue.setVisible(true);
				
			}
		});
		
		//5
		JButton but5 = new JButton("返回 ");
		panel_5.add(but5);
		
		add(panel_5);
		
		but5.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//返回上一窗口
				if(flag) {
				UserGUI userGUI = new UserGUI();
				dispose();
				userGUI.setVisible(true);
				}else {
					ManageQueryGUI manageQueryGUI = new ManageQueryGUI();
					dispose();
					manageQueryGUI.setVisible(true);
				}
				
				
			}
		});

	}
}
