
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description sql server数据库的连接（本地端口号为1434）并实现数据库的增删改查功能
 * @author zw
 * @version
 * @Date 2020年11月24日上午8:50:14
 */
public class jdbc {
	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1434;DatebaseName=HotelManagementSystem";
	public int update(String sql,List<Object>list) //增删改功能
	{
	//加连预执释
	try {
	//1.加载驱动
	Class.forName(driver);
	//2.连接
	Connection con = DriverManager.getConnection(url,"sa","1476950779");
	//3.预执行
	PreparedStatement ps = con.prepareStatement(sql);
	if(list!=null) {
		for(int i = 0;i<list.size();i++) {
			ps.setObject(i+1, list.get(i));
		}
	}
	//4.执行
	int row = ps.executeUpdate();
	//5.释放
	con.close();
	ps.close();
	//返回值
	return row;
	
	}catch(Exception e) {
		e.printStackTrace();
		return 0;
	}
	
	}
	
	public List<List<Object>> query(String sql,List<Object>list) {
		//加连预执释
		try {
		//1.加载驱动
		Class.forName(driver);
		//2.连接
		Connection con = DriverManager.getConnection(url,"sa","1476950779");
		//3.预执行
		PreparedStatement ps = con.prepareStatement(sql);
		if(list!=null) {
			for(int i = 0;i<list.size();i++) {
				ps.setObject(i+1, list.get(i));
			}
		}
		//4.执行
		ResultSet res = ps.executeQuery();
		//查询到数据为表，用二维列表来表示对应的行和列(一列为一个结果)
		List<List<Object>> args = new ArrayList<List<Object>>();
		while(res.next()) { //res开始指向第一行
			List<Object> temp = new ArrayList<Object>();
			int ColumnCount = res.getMetaData().getColumnCount();//获取列数
			for(int i = 1; i <= ColumnCount;i++) {
				temp.add(res.getObject(i)); //将res中返回的值的一列值存放到temp列表中
			}
			args.add(temp);//
		}
		//5.释放
		con.close();
		ps.close();
		res.close();
		//返回值
		return args;
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
