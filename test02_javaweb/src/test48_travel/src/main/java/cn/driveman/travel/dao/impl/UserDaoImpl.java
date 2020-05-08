package cn.driveman.travel.dao.impl;

import cn.driveman.travel.dao.IUserDao;
import cn.driveman.travel.domain.User;
import cn.driveman.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private static JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findUserByName(String username) {
        String sql = "select * from tab_user where username =?";
        List<User> routeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),username);
        return routeList.size() > 0 ? routeList.get(0) : null;
    }

    @Override
    public int save(User user) {
        String sql = "insert into tab_user (username,password,email,code,status) values ( ?,?,?,?,?)";
        int updateCount = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),  user.getEmail(),user.getCode(),user.getStatus());
        return updateCount;
    }

    @Override
    public User findUserByCode(String code) {
        String sql = "select * from tab_user where code = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
    }

    @Override
    public int updateUserActive(Integer userId) {
        String sql = "update tab_user set status = 'Y' where uid = ?";
        return jdbcTemplate.update(sql,userId);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String sql ="select * from tab_user where username =? and password =?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
    }
}
