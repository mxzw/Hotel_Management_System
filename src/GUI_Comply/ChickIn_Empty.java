/**
 * 
 */
package GUI_Comply;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import GUI.CheckInGUI;
import GUI.UserQueryGUI;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月29日下午2:51:50
 */
public class ChickIn_Empty extends JFrame{
	public ChickIn_Empty(Object[][] data,String[] coluNames) {
		setSize(500,400);
		setLocation(500, 500);
		setLayout(new BorderLayout());
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTable table = new JTable(data,coluNames);
		JScrollPane scrollPane = new JScrollPane(table);
		//JButton butx = new JButton("返回");

		JPanel panel = new JPanel();
		//panel.add(butx);
		/*
		butx.addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
				//返回上一窗口
				CheckInGUI checkInGUI = new CheckInGUI();
				
				checkInGUI.setVisible(true);
				
			}
		});	*/
		add(panel,BorderLayout.NORTH);
		add(scrollPane,BorderLayout.CENTER);
		
	}
}
