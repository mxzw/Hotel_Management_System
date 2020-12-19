/**
 * 
 */
package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.BasisJdbc;

/**
 * @Description 开始页面、登录页面、注册页面
 * @author zw
 * @version
 * @Date 2020年11月21日下午6:44:40
 */
public class BasisView {
	Scanner sc = new Scanner(System.in);
	// List<Object> account_list = new ArrayList<Object>();
	
	UserView uv = new UserView();

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
				//System.out.println("注册页面");
				UserRegist();
				break;
			case 0:
				break;
		}
		}while(login_input!=0);				
	}

	public void UserLogin() {
		//登录页面
		List<Object> list = new ArrayList<Object>();
		System.out.println("请输入您的账号：");
		String account = sc.next();
		System.out.println("请输入您的密码：");
		String passwd = sc.next();
		list.add(account);
		list.add(passwd);
		//连接数据库查询账户是否存在
		List<List<Object>> arg = new BasisJdbc().login(list);
		if(arg==null||arg.size()==0) {
			System.out.println("登录失败");
		}else {
			System.out.println("登录成功");
			if((int)arg.get(0).get(0)==0) {
				//用户界面
				new UserView().UserOperate();
			}else {
				//管理员页面
				new ManagementView().ManageOperarte();
			}
		}
		
	}
	
	public void UserRegist() {
		//注册页面
		List<Object> list = new ArrayList<Object>();
		System.out.println("请输入要注册的用户名：");
		String name = sc.next();
		System.out.println("请输入密码：");
		String passwd = sc.next();
		list.add(name);
		list.add(passwd);
		//数据库信息增加
		int row = new BasisJdbc().User_Regist(list);
		if(row==0) {
			System.out.println("注册失败");
		}
		System.out.println("注册成功,请重新登录");
	}
	
}
