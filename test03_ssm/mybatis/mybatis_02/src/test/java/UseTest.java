import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import vo.QueryVo;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UseTest {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void before() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void close() throws Exception {
        sqlSession.commit();
        if (null != sqlSession) {
            sqlSession.close();
        }
        if (null != in) {
            in.close();
        }
    }


    @Test
    public void testFindUserById() throws Exception {
        User user = userMapper.findUserById(41);
        System.out.println(user);
    }

    @Test
    public void testAddUser() throws Exception {
        User u = new User("小源",new Date(),"男","广州");
        int i = userMapper.addUser(u);
        System.out.println(i);
    }
    @Test
    public void testUpdateUser() throws Exception {
        User u = new User(52,"小源源",new Date(),"女","小广州");
        int i = userMapper.updateUser(u);
        System.out.println(i);
    }
    @Test
    public void testDeleteUserById() throws Exception {
        int i = userMapper.deleteUserById(50);
    }
    @Test
    public void testFindUserByLikeName() throws Exception {
        List<User> userList = userMapper.findUserListByLikeName("%王%");
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindTotal() throws Exception {
        int total = userMapper.findTotal();
        System.out.println("============== "+total +"  ==========");
    }

    @Test
    public void testFindUserListByQueryVo() throws Exception {
        User user = new User();
        user.setUsername("%王%");
        QueryVo queryVo = new QueryVo(user);
        List<User> userList = userMapper.findUserListByQueryVo(queryVo);
        System.out.println("============== "+userList +"  ==========");
    }

}
