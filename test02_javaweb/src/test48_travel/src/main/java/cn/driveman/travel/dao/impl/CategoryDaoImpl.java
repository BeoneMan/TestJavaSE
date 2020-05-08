package cn.driveman.travel.dao.impl;

import cn.driveman.travel.dao.ICategoryDao;
import cn.driveman.travel.entity.Category;
import cn.driveman.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {
        String sql = "select cid,cname from tab_category";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
    }


}
