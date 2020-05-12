package cn.driveman.travel.dao.impl;

import cn.driveman.travel.dao.ISellerDao;
import cn.driveman.travel.entity.Seller;
import cn.driveman.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SellerDaoImpl implements ISellerDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Seller findSellerById(Integer id) {
        String sql ="select * from tab_seller where sid =?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Seller>(Seller.class),id);
    }
}
