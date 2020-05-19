import entity.User;
import entity.UserChange;
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

public class UseChangeTest {
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
        List<UserChange> user = userMapper.findAll();
        System.out.println(user);
    }



}
