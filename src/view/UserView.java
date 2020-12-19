/**
 * 
 */
package view;

import java.util.List;
import java.util.Scanner;

import util.UserJdbc;

/**
 * @Description 用户界面、用户查询页面 --- 及其对应功能实现
 * @author zw
 * @version
 * @Date 2020年11月21日下午6:33:32
 */
public class UserView {
	Scanner sc = new Scanner(System.in);
	UserJdbc uj = new UserJdbc();
	public void UserOperate() {
		int userop_input;
		do {
		// 用户界面
		System.out.println("**********欢迎访问Eons宾馆**********");
		System.out.println("**     	    1.房间查询                                **");
		System.out.println("**     	    2.入住登记                                **");
		System.out.println("**          0.退出系统                                **");
		System.out.println("请选择对应选项(0-2)");
		userop_input = sc.nextInt();
		switch(userop_input) {
		case 1:
			// 房间查询
			UserQuery(true);
			break;
		case 2:
			// 入住登记
			CheckIn();
			break;
		case 0:
			System.exit(0);
			break;
		}
		}while(userop_input!=0);
	}

	public void CheckIn() {
		//入住登记
		String userName,userId,userPhone,selectRoomID;
		System.out.println("请输入姓名：");
		userName = sc.next();
		System.out.println("请输入身份证：");
		userId = sc.next();
		System.out.println("请输入电话：");
		userPhone = sc.next();
		System.out.println("请输入入住天数：");
		int checkTime = sc.nextInt();
		System.out.println("根据空房间选择需要入住的房间");
		EmptyRoom();
		System.out.println("请输入需要入住的房间号");
		selectRoomID = sc.next();
		//加载到数据库
		UserJdbc uj = new UserJdbc();
		int row = uj.Check_In(userName, userId, userPhone, selectRoomID, checkTime);
		if(row!=0) {
			System.out.println("入住成功!");
		}else {
			System.out.println("入住失败!");
		}
		
	}

	
	public void UserQuery(boolean flag) {
		int userqu_input;
		do {
		// 客户查询页面
		System.out.println("**********房间信息查询界面 **********");
		System.out.println("**     	   1.空房间查询                            **");
		System.out.println("**     	   2.按房间号查询                        **");
		System.out.println("**     	   3.显示所有房间                        **");
		System.out.println("**     	   0.返回上一页面                        **");
		System.out.println("请选择对应选项(0-3)");
		userqu_input = sc.nextInt();
		switch(userqu_input) {
		case 1:
			//空房查询
			EmptyRoom();
			break;
		case 2:
			//房间号查询
			QueryIDRoom();
			break;
		case 3:
			//所有房间
			AllRoom();
			break;
		case 0:
			if(flag) {
				//返回 -- 用户页面
				UserOperate();
			}else {
				ManagementView mv = new ManagementView();
				mv.ManageOperarte();
			}
			
			break;
		}
		
		}while(userqu_input!=0);
	}
	
	public void EmptyRoom() {
		//空房查询
		//查询数据库中所有房间状态为0的房间
		
		List<List<Object>> row = uj.Empty_Room();
		if(row==null||row.size()==0) {
			System.out.println("房间已满!");
		}else {
			System.out.println(row);
		}
	}
	
	public void QueryIDRoom() {
		//按房间号查询
		System.out.println("请输入所要查询的房间号：");
		String id = sc.next();
		//按对应房号id查询数据库
		List<List<Object>> arg = uj.QueryID_Room(id);
		if(arg==null||arg.size()==0) {
			System.out.println("房间不存在!");
		}else {
			System.out.println("房号\t\t房间名\t\t房间价格\t\t房间居住状态");
			for(int i= 0;i<arg.size();i++) {
				for(int j = 0;j<arg.get(i).size();j++) {
					System.out.print(arg.get(i).get(j)+"\t"+"\t");
				}
				System.out.println();
			}
			//System.out.println(arg);
		}
	}

	public void AllRoom() {
		//显示所有房间
		//连接数据库显示所有房间信息
		List<List<Object>> arg = uj.All_Room();
		System.out.println("房号\t\t房间名\t\t房间价格\t\t房间居住状态");
		for(int i= 0;i<arg.size();i++) {
			for(int j = 0;j<arg.get(i).size();j++) {
				System.out.print(arg.get(i).get(j)+"\t"+"\t");
			}
			System.out.println();
		}
	}
}
