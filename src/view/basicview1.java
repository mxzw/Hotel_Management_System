/**
 * 
 */
package view;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description 开始页面、登录页面、注册页面
 * @author zw
 * @version
 * @Date 2020年11月21日下午6:44:40
 */
public class basicview1 {
	Scanner sc = new Scanner(System.in);
	Map<String, String> UserAccountList = new HashMap<String,String>();
	Map<String, String> ManaAccountList = new HashMap<String,String>();
	// List<Object> account_list = new ArrayList<Object>();
	
	UserView uv = new UserView();
	ManagementView mv = new ManagementView();

	public void login() {
		int login_input;
		do {
		// 开始页面
		System.out.println("**********欢迎访问Eons宾馆**********");
		System.out.println("**            1.登录                                  **");
		System.out.println("**            2.注册                                  **");
		System.out.println("**            0.退出系统                          **");
		System.out.println("********************************");
		System.out.println("请选择对应选项(0-2)");
		login_input = sc.nextInt();
		switch(login_input) {
			case 1:
				//System.out.println("登录页面");
				UserLogin();
				break;
			case 2:
				System.out.println("注册页面");
				break;
			case 0:
				break;
		}
		}while(login_input!=0);				
	}

	public void UserLogin() {
		//登录页面
		
		boolean flag = false;
		UserAccountList.put("u1","123456");
		UserAccountList.put("u2", "zbc123");
		ManaAccountList.put("m1", "147258369");
		
			
		System.out.println("请输入您的账号：");
		String account = sc.next();
		System.out.println("请输入您的密码：");
		String passwd = sc.next();
		
		for(String i:UserAccountList.keySet()){	
			//*****复合数据类型不能使用 == 来做比较，要用equals方法来做比较*******
			if( i.equals(account)) {
				if(UserAccountList.get(i).equals(passwd)) {	
					//检测到账号为用户
					System.out.println("登录成功");
					flag = true;
					uv.UserOperate();
					break;
				}
			}

			for(String j:ManaAccountList.keySet()) {
				
				if(j.equals(account)) {
					if(ManaAccountList.get(j).equals(passwd)) {
						//检测到账户为管理员
						System.out.println("登录成功");
						flag = true;
						mv.ManageOperarte();
						break;
					}	
				}
			}		
		}
		if(flag == false) {
			System.out.println("输入的账户不存在或密码错误");
		}
			
	}
	
	public void UserRegist() {
		//注册页面
		System.out.println("请输入要注册的用户名：");
		String name = sc.next();
		System.out.println("请输入密码：");
		String passwd = sc.next();
		UserAccountList.put(name, passwd);
		System.out.println("注册成功");
	}
	
}
