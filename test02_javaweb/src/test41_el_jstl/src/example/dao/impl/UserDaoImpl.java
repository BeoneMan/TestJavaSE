package example.dao.impl;

import example.dao.IUserDao;
import example.entity.User;
import example.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql="select id,name,gender,age,address,qq,email from user where deleted = 0";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        String sql = "update user set deleted =1 where id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update>0?true:false;
    }

    @Override
    public Boolean updateUserById(Integer id, User user) {
        Integer versionById = findVersionById(id);
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=?,version=version+1 where version =? and id=?";
        int update = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(),versionById,id);
        return update>0?true:false;
    }

    @Override
    public User findUserById(Integer id) {
        String sql ="select id,name,gender,age,address,qq,email from user where id = ? and deleted =0";
        return (User) (jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class), id)).get(0);
    }

    @Override
    public Integer findVersionById(Integer id) {
        String sql = " select version from user where id = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,id);
    }

    @Override
    public Integer addUser(User user) {
        String sql="insert into user (name,gender,age,address,qq,email) values (?,?,?,?,?,?)";
        int insertCount = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

        return insertCount;
    }
}
