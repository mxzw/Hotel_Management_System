import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月27日下午7:49:03
 */
public class test_phoneQuerygui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300,200);
		frame.setLocation(600,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(1,1));
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		
		//1
		JLabel label_1 = new JLabel("电话查询:");
		JPanel temp_1 = new JPanel();
		temp_1.add(label_1);
		JTextField text_1 = new JTextField(18);
		panel_1.add(temp_1);
		panel_1.add(text_1);
		
		//frame.add(panel_1);
		
		//2
		JButton but1 = new JButton("返回");
		panel_2.add(but1);
		panel_1.add(panel_2);
		
		frame.add(panel_1);
		
		frame.setVisible(true);


	}

}
