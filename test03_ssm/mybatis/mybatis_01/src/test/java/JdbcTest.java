import entity.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcTest {
    @Test
    public void test() {
        Connection conn = null;
        PreparedStatement prepsTate = null;
        ResultSet resultSet = null;
        List<User> list = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///mybatis_01", "root", "root");
            prepsTate = conn.prepareStatement("select * from user where id = ?");
            prepsTate.setInt(1, 41);
            resultSet = prepsTate.executeQuery();
            list = new ArrayList<User>();
            if (resultSet != null) {

                while (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    Date birthday = resultSet.getDate("birthday");
                    String sex = resultSet.getString("sex");
                    String address = resultSet.getString("address");
                    User user = new User(id, username, birthday, sex, address);
                    list.add(user);

                }
            }
            System.out.println(list);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(null!=resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=prepsTate){
                try {
                    prepsTate.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
