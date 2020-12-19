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

import GUI_Comply.Mananger_Empty;
import GUI_Comply.UserQuery_Emptyroom;
import util.ManageJdbc;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月27日下午7:50:29
 */
public class QueryPhoneGUI extends JFrame {
	public QueryPhoneGUI() {
		setSize(500,400);
		setLocation(500,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,1));	
		Query_Phone();
	}
	public void Query_Phone() {
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel(new FlowLayout());
		
		
		//1
		JLabel label_1 = new JLabel("电话查询:");
		JPanel temp_1 = new JPanel();
		temp_1.add(label_1);
		JTextField text_1 = new JTextField(18);
		panel_1.add(temp_1);
		panel_1.add(text_1);
		
		
		//2
		JButton but1 = new JButton("返回");
		panel_2.add(but1);
		
		but1.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//返回上一窗口
				CustomerQueryGUI customerQueryGUI = new CustomerQueryGUI();
				dispose();
				customerQueryGUI.setVisible(true);
				
			}
		});
		
		//3
		JButton but2 = new JButton("完成");
		panel_2.add(but2);
		panel_1.add(panel_2);
		
		add(panel_1);
		but2.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//返回上一窗口
				String phone = text_1.getText();
				//连接数据库查询相应结果
				String[] coluNames = {"UserNo","UserId","UserName","UserPhone","CheckInTime","RoomId"};
				ManageJdbc mj = new ManageJdbc();
				List<List<Object>> arg = mj.Query_phone(phone);
				if(arg==null||arg.size()==0) {
					JOptionPane.showMessageDialog(null, "用户不存在");
				}else {
					Object[][] data = new Object[10][6];
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
	}
}
