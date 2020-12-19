
package GUI_Comply;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import GUI.ManageOperaGUI;
import GUI.UserQueryGUI;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月28日下午7:53:35
 */
public class UserQuery_Emptyroom extends JFrame{
	public UserQuery_Emptyroom(Object[][] data,String[] coluNames,boolean flag) {
		setSize(500,400);
		setLocation(500, 50);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTable table = new JTable(data,coluNames);
		JScrollPane scrollPane = new JScrollPane(table);
		JButton butx = new JButton("返回");

		JPanel panel = new JPanel();
		panel.add(butx);
		
		butx.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//返回上一窗口
				UserQueryGUI userQueryGUI = new UserQueryGUI(flag);
				dispose();
				userQueryGUI.setVisible(true);
			}
		});	
		add(panel,BorderLayout.NORTH);
		add(scrollPane,BorderLayout.CENTER);
		
	}
	
}
