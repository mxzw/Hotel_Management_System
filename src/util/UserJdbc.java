
package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 入住登记功能加载，空房间功能加载,按房号id查找信息,所有房间显示
 * @author zw
 * @version
 * @Date 2020年11月24日上午9:38:33
 */
public class UserJdbc {
	jdbc j = new jdbc();
	public int Check_In(String userName,String userId,String userPhone,String selectRoomID,int checkTime) {
		//入住登记
		List<Object>list = new ArrayList<Object>();
		list.add(userId);
		list.add(userName);
		list.add(userPhone);
		list.add(checkTime);
		list.add(selectRoomID);
		String sql = "insert into HotelManagementSystem.dbo.UserTable values(?,?,?,?,?);";
		int row = j.update(sql, list);
		return row;
	}
	
	public List<List<Object>> Empty_Room(){
		//空房间显示
		String sql = "select * from HotelManagementSystem.dbo.RoomTable where roomState=0";
		return j.query(sql, null);
				
	}

	public List<List<Object>> QueryID_Room(String id){
		//按房号id查找信息
		List<Object>list = new ArrayList<Object>();
		list.add(id);
		String sql = "select * from HotelManagementSystem.dbo.RoomTable where roomId=?";
		return j.query(sql, list);
	}

	public List<List<Object>> All_Room(){
		//所有房间显示
		String sql = "select * from HotelManagementSystem.dbo.RoomTable";
		return j.query(sql, null);
	}
}
