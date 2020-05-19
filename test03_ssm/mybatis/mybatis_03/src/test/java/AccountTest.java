import dto.AccountDTO;
import mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private AccountMapper accountMapper;

    @Before
    public void before() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        accountMapper = sqlSession.getMapper(AccountMapper.class);
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
        List<AccountDTO> accountUserDTOList = accountMapper.findAllAccountUser();
        System.out.println(accountUserDTOList);
    }


}
