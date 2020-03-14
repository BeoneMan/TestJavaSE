package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 *   定义工具类
 *         1. 定义一个类 JDBCUtils
 *         2. 提供静态代码块加载配置文件，初始化连接池对象
 *         3. 提供方法
 *             1. 获取连接方法：通过数据库连接池获取连接
 *             2. 释放资源
 *             3. 获取连接池的方法
 */
public class JdbcUtils {

        private static DataSource dataSource;

    static{
        try {
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(in);

             dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取连接池方法
    public static DataSource getDataSource(){
        return dataSource;
    }
    //获取连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
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
