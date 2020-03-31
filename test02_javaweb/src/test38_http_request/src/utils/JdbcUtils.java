package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static DataSource dataSource;
    private static String username;
    private static String password;
    private static String url;
    private static Driver driver;

    static {
        try {
            Properties properties = new Properties();
            InputStream stream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(stream);
             username = properties.getProperty("username");
             password = properties.getProperty("password");
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection(){

        try {
            Connection connection = dataSource.getConnection(username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from login ;");
          while (resultSet.next()){
              String name = resultSet.getString("username");
              System.out.println(name);
          }
        }
    }
