import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月26日下午4:14:55
 */
public class userQuery_gui {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,400);
		frame.setLocation(500,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(5,1));
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		JPanel panel_5 = new JPanel();
		
		//1
		JLabel label_1 = new JLabel("<html><h1>Eons宾馆入住登记</h1></html>");
		panel_1.add(label_1);
		
		frame.add(panel_1);
		
		//2
		JButton but2 = new JButton("1. 空房间查询    ");
		panel_2.add(but2);
		
		frame.add(panel_2);
		
		//3
		JButton but3 = new JButton("2. 按房间号查询 ");
		panel_3.add(but3);
		
		frame.add(panel_3);
		
		//4
		JButton but4 = new JButton("3. 显示所有房间  ");
		panel_4.add(but4);
		
		frame.add(panel_4);
		
		//5
		JButton but5 = new JButton("返回 ");
		panel_5.add(but5);
		
		frame.add(panel_5);
		
		frame.setVisible(true);
	}

}
