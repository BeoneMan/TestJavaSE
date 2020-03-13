package jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * 出现sql注入问题
 */
@SuppressWarnings("all")
public class Demo04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = scanner.next();
        System.out.println("请输入密码"); //  a' or 'a' ='a
        String password = scanner.next();
        System.out.println(findAll(name,password)?"登录成功":"登录失败");

    }

    //使用jdbcUtils简化操作
    public static Boolean findAll(String name, String password) {
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        try {
            System.out.println("start...");
            conn = JdbcUtils.getConnection();
            state = conn.createStatement();
            String sql = "select * from login where username = '"+name+"' and password = '"+password+"'";
            result = state.executeQuery(sql);
//            if (result.next()) return true;
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行完毕，关闭资源");
            JdbcUtils.close(result, state, conn);
        }

        return false;


    }

  /*  public static Boolean findAll(String name,String password) {
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        try {
            System.out.println("start...");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/driveman", "root", "");
            state = conn.createStatement();
            String sql = "select * from login where username='+username+' and password = '+password+' ";
            result = state.executeQuery(sql);
            if(result.next())return true;


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
                if (state != null) state.close();
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
