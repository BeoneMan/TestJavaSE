package jdbc;

import java.sql.*;

//快速入门
public class Demo01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/driveman", "root", "");
            state = conn.createStatement();
            String sql = "select * from dept";
            result = state.executeQuery(sql);
            while (result.next()) {
                System.out.println(result.getInt("id"));
                System.out.println(result.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (state != null) {
                try {
                    state.close();
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
    }
}
