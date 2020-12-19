
package util;

import java.util.List;

/**
 * @Description 登录功能加载
 * @author zw
 * @version
 * @Date 2020年11月24日下午5:14:54
 */

public class BasisJdbc {
	//登录功能的加载
	jdbc j = new jdbc();
	public List<List<Object>> login(List<Object> list){
		try {
		String sql = "select * from HotelManagementSystem.dbo.LoginTable where account=? and passwd=? ";
		List<List<Object>> args = j.query(sql, list);
		return args;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public int User_Regist(List<Object>list) {
		String sql = "insert into HotelManagementSystem.dbo.LoginTable values(0,?,?);";
		int row = j.update(sql, list);
		return row;
	}
}
