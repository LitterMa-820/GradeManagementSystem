package method;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ProjectName: StudentAchievementManagementSystem
 * @Package: PACKAGE_NAME
 * @ClassName: JDBCUtils
 * @Author: 82042
 * @Description: 该类是jdbc的工具类为数据库连接池druid所准备
 * @Date: 2020/8/14 23:16
 * @Version: 1.0
 */
public class JDBCUtils {
    //定义成员变量DataSource
    private static DataSource ds;
    //静态代码块用于加载配置文件
    static{
        Properties pro=new Properties();
        try {
            //通过反射加载配置文件
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("method/druid.properties"));
            //通过Druid的静态工厂获取DataSource
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    //释放资源
    public static void close(Statement stmt,Connection conn){
        close(null,stmt,conn);
    }
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //获取连接池
    public static DataSource getDataSource(){
        return ds;
    }
}