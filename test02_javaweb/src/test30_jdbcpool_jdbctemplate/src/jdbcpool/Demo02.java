package jdbcpool;

import entity.Emp;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * *需求：
 *             1. 修改1号数据的 salary 为 10000
 *             2. 添加一条记录
 *             3. 删除刚才添加的记录
 *             4. 查询id为1的记录，将其封装为Map集合
 *             5. 查询所有记录，将其封装为List
 *             6. 查询所有记录，将其封装为Emp对象的List集合
 *             7. 查询总记录数
 */
public class Demo02 {
    private JdbcTemplate jdbcTemplate=null;
    @Before
    public void before(){
         jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    }
    //7. 查询总记录数
    @Test
    public void testCount(){
        String sql="select count(1) from emp";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

    //6. 查询所有记录，将其封装为Emp对象的List集合
    @Test
    public  void testQueryForListEmp(){
        String sql="select * from emp";
        List<Emp> empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : empList) {
            System.out.println(emp);

        }
    }

    //5. 查询所有记录，将其封装为List
    @Test
    public void testQueryForList(){
        String sql="select * from emp";
        List<Map<String, Object>> listMaps = jdbcTemplate.queryForList(sql);
        System.out.println(listMaps);
    }
    // 4. 查询id为1的记录，将其封装为Map集合
    @Test
    public void testQueryForMap(){
        String sql="select * from emp where id = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(map);

    }

    //3. 删除刚才添加的记录
    @Test
    public void testDelete(){
        String sql = "delete from emp where id =?";
        int deleteCount = jdbcTemplate.update(sql, 20);
        System.out.println("删除执行了"+deleteCount+"行数");
    }

    // 2. 添加一条记录
    @Test
    public void testAdd(){

        String sql = "insert into emp  values(?,?,?,?,?,?)";
        //特别注意，即使数据库中的性别字段是 char类型，也需要用""表示
        int addCount = jdbcTemplate.update(sql,null,"小邱","男",9999,new Date(),2);
        System.out.println("插入执行了"+addCount+"行数");
    }
    //1. 修改1号数据的 salary 为 10000
    @Test
    public void testUpdate(){
        String sql = "update emp set salary=? where id= ?";
        int updateCount = jdbcTemplate.update(sql, 10000, 1);
        System.out.println("更改执行了"+updateCount+"行数");
    }
}
