package jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 练习：
 * 1. account表 添加一条记录
 * 2. account表 修改记录
 * 3. account表 删除一条记录
 */
public class Demo02 {
    private Connection conn;
    private Statement state;


    @Before
    public void testBefore() {
        try {
            System.out.println("启动了...");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/driveman", "root", "");
            state = conn.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // 添加一条记录
    @Test
    public void testAdd() {
        String sql = "insert into test values(null,'driveman12')";
        try {
            int i = state.executeUpdate(sql);
            if(i>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改记录
    @Test
    public void testUpdate(){
        String sql ="update test set myname='No1' where id = 1";
        try {
            int i = state.executeUpdate(sql);
            if (i>0) System.out.println("修改成功");
            else {System.out.println("修改失败");}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //删除记录
    @Test
    public void testDelete(){
        String sql ="delete from test where id =14";
        try {
            int i = state.executeUpdate(sql);
            if (i>0) System.out.println("删除成功");
            else {System.out.println("删除失败");}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        try {
            System.out.println("end...");
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
