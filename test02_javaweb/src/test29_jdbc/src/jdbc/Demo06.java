package jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 转账事务问题
 */
public class Demo06 {
    public static void main(String[] args) throws SQLException {
        transfer(1, 2, BigDecimal.valueOf(100.00));
    }

    private static void transfer(Integer id1, Integer id2, BigDecimal money) {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try {
            connection = JdbcUtils.getConnection();
            //手动设置事务
            connection.setAutoCommit(false);
            //id1减钱
            String sql1 = "update login set money=money-? where id =? ";
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setBigDecimal(1, money);
            preparedStatement1.setInt(2, id1);
            preparedStatement1.executeUpdate();

            //中间发生异常
            //int i = 3 / 0;

            //id2加钱
            String sql2 = "update login set money=money+? where id =? ";
            preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setBigDecimal(1, money);
            preparedStatement2.setInt(2, id2);
            preparedStatement2.executeUpdate();

            //提交事务
            connection.commit();
        } catch (Exception e) {
            try {
                if (connection != null) connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close(preparedStatement2, connection);
            JdbcUtils.close(preparedStatement1, connection);
        }


    }

}
