import dto.RoleDTO;
import mapper.RoleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleTest {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private RoleMapper roleMapper;

    @Before
    public void before() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        roleMapper = sqlSession.getMapper(RoleMapper.class);
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
        List<RoleDTO> roleDTOList = roleMapper.findAll();
        System.out.println(roleDTOList);
    }


}
