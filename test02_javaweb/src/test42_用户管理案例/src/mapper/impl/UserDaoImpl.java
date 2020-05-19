package mapper.impl;

import mapper.IUserDao;
import entity.User;
import utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("all")
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
        String sql="update user set name=?,password=?,gender=?,age=?,address=?,qq=?,email=?,version=version+1 where version =? and id=?";
        int update = jdbcTemplate.update(sql, user.getName(),user.getPassword(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(),versionById,id);
        return update>0?true:false;
    }

    @Override
    public User findUserById(Integer id) {
        String sql ="select id,name,password,gender,age,address,qq,email from user where id = ? and deleted =0";
        return (User) (jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class), id)).get(0);
    }

    @Override
    public Integer findVersionById(Integer id) {
        String sql = " select version from user where id = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,id);
    }

    @Override
    public Integer addUser(User user) {
        String sql="insert into user (name,password,gender,age,address,qq,email) values (?,?,?,?,?,?,?)";
        int insertCount = jdbcTemplate.update(sql, user.getName(),user.getPassword(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

        return insertCount;
    }

    @Override
    public User findUserByName(String name) {
        String sql = "select * from user where name=? ";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), name);

        return (users!=null&&users.size()>0)?users.get(0):null;
    }

    @Override
    public Integer getCount(Map<String, String[]> parameterMap) {
        StringBuffer stringBuffer = new StringBuffer();
        String sql = " select count(1) from user where deleted = 0 ";
        stringBuffer.append(sql);
        List<Object> list = new ArrayList<>();
        if(parameterMap.size()>0){
            Set<String> ketSet = parameterMap.keySet();
            for (String s : ketSet) {
                if("currentPage".equals(s)||"rows".equals(s))continue;
                String value = parameterMap.get(s)[0];
                if (value!=null && value.length()>0){
                    stringBuffer.append(" and "+s+" like ? ");
                    list.add("%"+value+"%");
                }
            }
            return jdbcTemplate.queryForObject(stringBuffer.toString(),Integer.class,list.toArray());
        }


        return jdbcTemplate.queryForObject(stringBuffer.toString(),Integer.class);
    }

    @Override
    public List<User> findByUserPage(Integer start, Integer rows, Map<String, String[]> parameterMap) {
        String sql = "select * from user where deleted=0 ";
        StringBuffer sb = new StringBuffer();
        sb.append(sql);
        List<Object> list=new ArrayList();
        if(parameterMap!=null&&parameterMap.size()>0){
            Set<String> set = parameterMap.keySet();
            for (String s : set) {
                if("currentPage".equals(s)||"rows".equals(s))continue;
                String value = parameterMap.get(s)[0];
                if(value!=null&&!"".equals(value)){
                   sb.append("and "+s+" like ?");
                    list.add("%"+value+"%");
                }
            }

        }
        //分页
        sb.append(" limit ?,?");
        list.add(start);
        list.add(rows);

        return jdbcTemplate.query(sb.toString(),new BeanPropertyRowMapper(User.class),list.toArray());
    }
}
