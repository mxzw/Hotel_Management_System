import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月26日下午3:46:24
 */
public class checkin_test {

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,400);
		frame.setLocation(500,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(7,1));
		
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel(new FlowLayout());
		JPanel panel_3 = new JPanel(new FlowLayout());
		JPanel panel_4 = new JPanel(new FlowLayout());
		JPanel panel_5 = new JPanel(new FlowLayout());
		JPanel panel_51 = new JPanel(new FlowLayout());
		JPanel panel_52 = new JPanel();
		JPanel panel_6 = new JPanel(new FlowLayout());
		JPanel panel_7 = new JPanel(new FlowLayout());
		JPanel panel_71 = new JPanel();
		JPanel panel_72 = new JPanel();
		
		//1
		JLabel label_1 = new JLabel("<html><h1>Eons宾馆入住登记</h1></html>");
		panel_1.add(label_1);
		
		frame.add(panel_1);
		
		//2
		JLabel label_2 = new JLabel("姓        名:");
		JPanel temp_2 = new JPanel();
		temp_2.add(label_2);
		JTextField text_2 = new JTextField(18);
		panel_2.add(temp_2);
		panel_2.add(text_2);
		
		frame.add(panel_2);
		
		//3
		JLabel label_3 = new JLabel("身份证号:");
		JPanel temp_3 = new JPanel();
		temp_3.add(label_3);
		JTextField text_3 = new JTextField(18);
		panel_3.add(temp_3);
		panel_3.add(text_3);
		
		frame.add(panel_3);
		
		//4
		JLabel label_4 = new JLabel("电话号码:");
		JPanel temp_4 = new JPanel();
		temp_4.add(label_4);
		JTextField text_4 = new JTextField(18);
		panel_4.add(temp_4);
		panel_4.add(text_4);
		
		frame.add(panel_4);
		
		//5
		JLabel label_5 = new JLabel("入住天数:");
		JPanel temp_5 = new JPanel();
		temp_5.add(label_5);
		JTextField text_5 = new JTextField(9);
		panel_51.add(temp_5);
		panel_51.add(text_5);
		
		JButton but5 = new JButton("空房查看");
		panel_52.add(but5);
		
		panel_5.add(panel_51);
		panel_5.add(panel_52);
		
		frame.add(panel_5);
		
		//6
		JLabel label_6 = new JLabel("入住房号:");
		JPanel temp_6 = new JPanel();
		temp_6.add(label_6);
		JTextField text_6 = new JTextField(18);
		panel_6.add(temp_6);
		panel_6.add(text_6);
		
		frame.add(panel_6);
		
		//7
		JButton but71 = new JButton("返回");
		JButton but72 = new JButton("完成");
		panel_7.add(but71);
		panel_7.add(but72);
		
		frame.add(panel_7);
		
		frame.setVisible(true);

	}

}
