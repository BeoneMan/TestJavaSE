import dto.UserDTO;
import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import vo.QueryVO;

import java.io.InputStream;
import java.util.Arrays;
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
    public void testFindAll() throws Exception {
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }


    @Test
    public void testFindByUser() throws Exception {
        User u = new User();
//        u.setUsername("老王");
        u.setAddress("北京");
        List<User> userList = userMapper.findByUser(u);
        System.out.println(userList);
    }

    @Test
    public void testFindByQueryVoIds() throws Exception {
        QueryVO queryVo = new QueryVO();
        Integer[] ids= {41,43,46};
//        Integer[] ids= {};
        queryVo.setIds(Arrays.asList(ids));
        List<User> userList = userMapper.findByQueryVoIds(queryVo);
        System.out.println(userList);
    }


    @Test
    public void TestfindUserAccount() throws Exception {
        List<UserDTO> userAccountList = userMapper.findUserAccount();
        System.out.println(userAccountList);
    }
    @Test
    public void TestfindUserRole() throws Exception {
        List<UserDTO> userRoleList = userMapper.findUserRole();
        for (UserDTO userDTO : userRoleList) {
            System.out.println(userDTO);
        }
    }


}
