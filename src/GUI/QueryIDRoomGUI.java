/**
 * 
 */
package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI_Comply.UserQuery_Emptyroom;
import util.UserJdbc;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月26日下午5:31:08
 */
public class QueryIDRoomGUI extends JFrame{
	public QueryIDRoomGUI() {
		setSize(300,200);
		setLocation(500,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		QueryIDRoomLayout();
	}
	public void QueryIDRoomLayout() {
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel(new FlowLayout());
		JPanel panel_3 = new JPanel();
		
		//1
		JLabel label_1 = new JLabel("查询房号:");
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
				UserQueryGUI userQueryGUI = new UserQueryGUI(true);
				dispose();
				userQueryGUI.setVisible(true);
				
			}
		});
		
		//3
		JButton but2 = new JButton("确定");
		panel_3.add(but2);
		panel_2.add(panel_3);
		
		but2.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//返回上一窗口
				String id = text_1.getText();
				//连接数据库进行按房号查询
				UserJdbc uj = new UserJdbc();
				List<List<Object>> arg = uj.QueryID_Room(id);
				if(arg==null||arg.size()==0) {
					JOptionPane.showMessageDialog(null, "房间不存在");
				}else {
				String[] coluNames = {"RoomId","RoomName","RoomPrice","RoomState"};
				Object[][] data = new Object[10][4];
				for(int i= 0;i<arg.size();i++) {
					for(int j = 0;j<arg.get(i).size()-1;j++) {
						//System.out.print(arg.get(i).get(j)+"\t"+"\t");
						data[i][j] = arg.get(i).get(j);
					}
				}
				UserQuery_Emptyroom ue = new UserQuery_Emptyroom(data, coluNames,true);
				dispose();
				ue.setVisible(true);
				}
				
			}
		});
		
		add(panel_2);
		
		
	}
}
