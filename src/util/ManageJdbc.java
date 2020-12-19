/**
 * 
 */
package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 电话查询功能和身份证查询，所有客户信息查询，退房结算，客户状态修改，客房续费
 * @author zw
 * @version
 * @Date 2020年11月24日下午6:32:29
 */
public class ManageJdbc {
	jdbc j = new jdbc();
	public List<List<Object>> Query_phoneOrId(String temp){
		//按房号id查找信息
		List<Object>list = new ArrayList<Object>();
		list.add(temp);
		String sql = "select * from HotelManagementSystem.dbo.UserTable where userId=?";
		return j.query(sql, list);
	}
	
	public List<List<Object>> Query_phone(String temp){
		//按房号id查找信息
		List<Object>list = new ArrayList<Object>();
		list.add(temp);
		String sql = "select * from HotelManagementSystem.dbo.UserTable where userPhone=?";
		return j.query(sql, list);
	}
	
	public List<List<Object>> All_User(){
		//所有房间显示
		String sql = "select * from HotelManagementSystem.dbo.UserTable";
		return j.query(sql, null);
	}
	
	public int Check_out(String id){
		//退房结算
		List<Object>list = new ArrayList<Object>();
		list.add(id);
		String sql = "select checkInTime,roomId from HotelManagementSystem.dbo.UserTable where userId=?";
		//获取该用户对应的checkInTime,roomId
		List<List<Object>> arg = j.query(sql, list);
		list.remove(0);
		//将roomId放到列表中
		/*System.out.println(arg);
		System.out.println(arg.get(0).get(1));*/
		list.add(arg.get(0).get(1));
		String sql2 = "select roomPrice from HotelManagementSystem.dbo.RoomTable where roomId=?";
		List<List<Object>> arg1 = j.query(sql2, list);
		System.out.println("退房结算费用为"+(int)arg.get(0).get(0)*(int)arg1.get(0).get(0)+"元");
		String sql3 = "delete from HotelManagementSystem.dbo.UserTable where userId=?";
		list.remove(0);
		list.add(id);
		return j.update(sql3, list);
	}
	
	public int Renew_Room(String id,int time) {
		//客房续费
		List<Object>list = new ArrayList<Object>();
		list.add(time);
		list.add(id);
		String sql = "update HotelManagementSystem.dbo.UserTable set checkInTime=checkInTime+? where roomId = ? ";
		return j.update(sql, list);
	}	
}
