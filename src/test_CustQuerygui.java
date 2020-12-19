import java.awt.BorderLayout;
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
 * @Date 2020年11月27日下午7:43:51
 */
public class test_CustQuerygui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,400);
		frame.setLocation(500,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(4,1));
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel(new GridLayout(3,1));
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		JPanel panel_5 = new JPanel(new BorderLayout());
		
		//1
		JLabel label_1 = new JLabel("<html><h1>客户信息查询界面</h1></html>");
	
		panel_1.add(label_1);
		
		frame.add(panel_1);
		//panel_5.add(panel_1,BorderLayout.NORTH);
		
		//2
		JButton but1 = new JButton("电话查询");
		panel_2.add(but1);
		
		//frame.add(panel_2);
		
		//3
		JButton but2 = new JButton("身份证号查询  ");
		panel_2.add(but2);
		
		//frame.add(panel_3);		
		
		//4
		JButton but3 = new JButton("显示所有客户信息 ");
		panel_2.add(but3);
		panel_3.add(panel_2);
		
		panel_5.add(panel_3,BorderLayout.CENTER);
		frame.add(panel_5);
		//5
		JButton but4 = new JButton("返回 ");
		panel_4.add(but4);
		//panel_3.add(panel_4,BorderLayout.SOUTH);
		
		//panel_5.add(panel_3,BorderLayout.CENTER);
		
		frame.add(panel_4);
		frame.setVisible(true);


	}

}
