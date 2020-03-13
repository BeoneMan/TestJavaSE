package jdbc;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.List;

/**
 * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 * 					1. 定义Emp类
 * 					2. 定义方法 public List<Emp> findAll(){}
 * 					3. 实现方法 select * from emp;
 */
public class Demo03 {
    public static void main(String[] args) {
     List<Emp> list= findAll();
        System.out.println(list);

    }
    public static List<Emp> findAll(){
        Connection conn=null;
        Statement state = null;
        ResultSet result=null;
        List<Emp> list = new ArrayList<>();
        try {
            System.out.println("start...");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/driveman", "root", "");
            state = conn.createStatement();
            String sql="select * from emp ";
            result = state.executeQuery(sql);

            Emp emp = null;
            while(result.next()){
                emp=new Emp();
                emp.setId(result.getInt("id"));
                emp.setName(result.getString("name"));
                emp.setGender((result.getString("gender").charAt(0)));
                emp.setJoin_date(new Date());
                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行完毕，关闭资源");
            try {
                if(result!=null)result.close();
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

        return list==null?new ArrayList<>():list;


    }

}
