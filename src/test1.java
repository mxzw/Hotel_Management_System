import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Description
 * @author zw
 * @version
 * @Date 2020年11月24日下午3:30:12
 */
public class test1 {
	//驱动路径
    private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1434;DatebaseName=HotelManagementSystem";
    //程序入口函数
    public static void main(String[] args) {
        try {
            //加载驱动程序
            Class.forName(DBDRIVER);
            Connection con = DriverManager.getConnection(url,"sa","1476950779");
            
            System.out.println("测试成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
