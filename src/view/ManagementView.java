/**
 * 
 */
package view;

import java.util.List;
import java.util.Scanner;

import util.ManageJdbc;

/**
 * @Description 管理员页面、管理员查询、客户信息查询页面  --- 及其对应功能实现
 * @author zw
 * @version
 * @Date 2020年11月21日下午6:39:11
 */
public class ManagementView {
	Scanner sc = new Scanner(System.in);
	ManageJdbc mj = new ManageJdbc();
	public void ManageOperarte() {
		int manageop_input;
		do {
		// 管理员页面
		System.out.println("**********Eons宾馆管理系统 **********");
		System.out.println("**          1.房间/客户信息查询              **");
		System.out.println("**     	 	2.退房结算                                 **");
		System.out.println("**     	 	3.客房续费                                 **");
		System.out.println("**          0.退出页面                                 **");
		System.out.println("请选择对应选项(0-3)");
		manageop_input = sc.nextInt();
		switch(manageop_input) {
		case 1:
			//信息查询
			ManagerQuery();
		case 2:
			//退房结算
			CheckOut();
			break;
		case 3:
			//客房续费
			RenewRoom();
			break;
		case 0:
			System.exit(0);
			break;
		}
		}while(manageop_input!=0);
	}

	
	public void ManagerQuery() { 
		int managequ_input;
		do {
			// 管理员查询页面
			System.out.println("**********房间/客户信息查询界面 **********");
			System.out.println("**     	 	 1.房间信息查询                             **");
			System.out.println("**     	 	 2.客户信息查询                             **");
			System.out.println("**     	   	 0.返回上一页面                             **");
		System.out.println("请选择对应选项(0-2)");
		managequ_input = sc.nextInt();
		switch(managequ_input) {
		case 1:
			//房间查询
			UserView uv = new UserView();
			uv.UserQuery(false);
			break;
		case 2:
			//客户信息查询
			CustomerQuery();
			break;
		case 0:
			//返回 -- 管理员页面
			ManageOperarte();
			break;
		}
		
		}while(managequ_input!=0);
	}

	public void CustomerQuery() {
		int custqu_input;
		do {
			//客户信息查询界面
			System.out.println("**********客户信息查询界面 **********");
			System.out.println("**     	   1.电话查询                                **");
			System.out.println("**     	   2.身份证号查询                        **");
			System.out.println("**     	   3.显示所有客户信息                **");
			System.out.println("**     	   0.返回上一页面                        **");
		System.out.println("请选择对应选项(0-3)");
		custqu_input = sc.nextInt();
		switch(custqu_input) {
		case 1:
			//电话查询
			QueryPhone();
			break;
		case 2:
			//身份证号查询
			QueryID();
			break;
		case 3:
			//显示所有客户信息
			QueryUser();
			break;
		case 0:
			//返回 -- 管理员查询页面
			ManagerQuery();
			break;
		}
		
		}while(custqu_input!=0);
	}
	
	public void CheckOut() {
		//退房结算
		System.out.println("请输入用户身份证号：");
		String id = sc.next();
		//查询数据库中对应用户所住天数，以及对应房间价格---（返回总价格）
		//连接数据库删除对应身份证号房间信息，并修改房间状态
		int row = mj.Check_out(id);
		if(row>=0) {
			System.out.println("退房成功");
		}
		
		
	}
	
	public void RenewRoom() {
		//客房续费
		System.out.println("请输入需要续费的房间号：");
		String id = sc.next();
		System.out.println("请输入需要增加对应入住天数：");
		int time = sc.nextInt();
		//连接数据库并修改对应入住天数
		int row = mj.Renew_Room(id, time);
		if(row>=0) {
			System.out.println("续费成功");
		}
	}
	
	public void QueryPhone() {
		//电话查询
		System.out.println("请输入需要查询的手机号：");
		String phone = sc.next();
		//连接数据库并查询对应信息
		List<List<Object>> arg = mj.Query_phone(phone);
		if(arg==null||arg.size()==0) {
			System.out.println("房间不存在!");
		}else {
		/*	System.out.println("房号\t\t房间名\t\t房间价格\t\t房间居住状态");
			for(int i= 0;i<arg.size();i++) {
				for(int j = 0;j<arg.get(i).size();j++) {
					System.out.print(arg.get(i).get(j)+"\t"+"\t");
				}
				System.out.println();
			}*/
			System.out.println(arg);
		}
	}
	
	public void QueryID() {
		//身份证查询
		System.out.println("请输入需要查询的身份证号：");
		String Id = sc.next();
		//连接数据库并查询对应信息
		List<List<Object>> arg = mj.Query_phoneOrId(Id);
		if(arg==null||arg.size()==0) {
			System.out.println("房间不存在!");
		}else {
		/*	System.out.println("房号\t\t房间名\t\t房间价格\t\t房间居住状态");
			for(int i= 0;i<arg.size();i++) {
				for(int j = 0;j<arg.get(i).size();j++) {
					System.out.print(arg.get(i).get(j)+"\t"+"\t");
				}
				System.out.println();
			}*/
			System.out.println(arg);
		}
	}
	
	public void QueryUser() {
		//显示所有客户信息
		//查询数据库并返回所有客户信息
		List<List<Object>> arg = mj.All_User();
		if(arg==null||arg.size()==0) {
			System.out.println("房间不存在!");
		}else {
		/*	System.out.println("房号\t\t房间名\t\t房间价格\t\t房间居住状态");
			for(int i= 0;i<arg.size();i++) {
				for(int j = 0;j<arg.get(i).size();j++) {
					System.out.print(arg.get(i).get(j)+"\t"+"\t");
				}
				System.out.println();
			}*/
			System.out.println(arg);
		}
	}
	
}
