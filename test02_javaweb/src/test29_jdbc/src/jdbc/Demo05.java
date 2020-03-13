package jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * 解决sql注入问题
 */
@SuppressWarnings("all")
public class Demo05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();
        System.out.println(login(username, password)?"登陆成功":"登陆失败");
    }

    //用jdbcUtils简化
    private static Boolean login(String username, String password) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn=JdbcUtils.getConnection();
            String sql = "select * from login where username = ? and password = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            result = preparedStatement.executeQuery();
           // if (result.next()) return true;
            return result.next();
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行完毕，关闭资源");
         JdbcUtils.close(result,preparedStatement,conn);
        }

        return false;
    }

  /*  private static Boolean login(String username, String password) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///driveman", "root", "");
            String sql = "select * from login where username = ? and password = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            result = preparedStatement.executeQuery();
            //if (result.next()) return true;
              return result.next();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行完毕，关闭资源");
            try {
                if (result != null) result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }*/

}
