package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc工具类
 */
public class JdbcUtils {
        private static String driver;
        private static String url;
        private static String username;
        private static String password;

    static{
        try {
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(in);
            driver=properties.getProperty("jdbc.driver");
            url=properties.getProperty("jdbc.url");
            username=properties.getProperty("jdbc.username");
            password=properties.getProperty("jdbc.password");

            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    //获取连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //释放资源
    public static void close(Statement state , Connection conn){
        close(null,state,conn);
    }
    //释放资源
    public static void close(ResultSet resultSet, Statement state , Connection conn){
        try {
            if(resultSet!=null)resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(state!=null)state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
