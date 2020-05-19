package mapper;

import domain.U;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class LoginDao {
    private JdbcTemplate jdbcTemplate;

    public User login(User user) {
        jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        String sql = "select * from login where username=? and password =? ";
        List<User> listUser = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(User.class),
                user.getUsername(), user.getPassword());
        return listUser.size() > 0 ? listUser.get(0) : null;
    }

    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {

        //BeanUtils 练习
        jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        String sql = "select * from login where username=? and password =? ";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql,
                "lisi", "lisi");
        User u = new User();
        System.out.println(map);
        BeanUtils.populate(u,map);
        System.out.println(u);
        System.out.println("--------");
        U a = new U();
        BeanUtils.setProperty(a,"name",map.get("username"));
        System.out.println(a.getName());
    }
}
