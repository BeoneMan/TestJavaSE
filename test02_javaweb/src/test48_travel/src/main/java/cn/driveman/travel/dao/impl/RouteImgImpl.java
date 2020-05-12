package cn.driveman.travel.dao.impl;

import cn.driveman.travel.dao.IRouteImgDao;
import cn.driveman.travel.entity.RouteImg;
import cn.driveman.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RouteImgImpl implements IRouteImgDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<RouteImg> findRouteImgListByRid(Integer sourceId) {
        String sql = "select * from tab_route_img where rid = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<RouteImg>(RouteImg.class),sourceId);
    }
}
