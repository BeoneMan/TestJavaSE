import mapper.UserAnnotationMapper;
import mapper.UserMapper;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test01() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserAnnotationMapper userDao = sqlSession.getMapper(UserAnnotationMapper.class);
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.findAll();
        System.out.println(userList);

    }
}
