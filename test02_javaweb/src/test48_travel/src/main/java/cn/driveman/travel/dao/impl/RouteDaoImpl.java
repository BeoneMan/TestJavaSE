package cn.driveman.travel.dao.impl;

import cn.driveman.travel.dao.IRouteDao;
import cn.driveman.travel.entity.Route;
import cn.driveman.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RouteDaoImpl implements IRouteDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Route> findRouteListByCid(Integer cid) {
        String sql ="select * from tab_route where cid =?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Route>(Route.class),cid);
    }


    @Override
    public Integer findTotalCount(Integer cid) {
        String sql = "select count(rid) from tab_route where cid =?";
        return jdbcTemplate.queryForObject(sql,Integer.class,cid);
    }

    @Override
    public List<Route> findRouteListByPage(Integer cid, Integer startIndex, Integer pageSize) {
        String sql = "select * from tab_route where cid =? limit ?,?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Route>(Route.class),cid,startIndex,pageSize);
    }
}
