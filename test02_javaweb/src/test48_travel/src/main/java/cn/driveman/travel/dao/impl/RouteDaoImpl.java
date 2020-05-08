package cn.driveman.travel.dao.impl;

import cn.driveman.travel.dao.IRouteDao;
import cn.driveman.travel.entity.Route;
import cn.driveman.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements IRouteDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Route> findRouteListByCid(Integer cid) {
        String sql = "select * from tab_route where cid =?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Route>(Route.class), cid);
    }


    @Override
    public Integer findTotalCount(Integer cid, String rname) {
        StringBuilder sb = new StringBuilder();
        List<Object> paramList = new ArrayList<>();
        String sql = "select count(rid) from tab_route where cid =? ";
        sb.append(sql);
        paramList.add(cid);
        if (!StringUtils.isEmpty(rname)) {
            String rnameSql = " and rname like ? ";
            sb.append(rnameSql);
            paramList.add(rname);
        }
        return jdbcTemplate.queryForObject(sb.toString(), Integer.class, paramList.toArray());
    }

    @Override
    public List<Route> findRouteListByPage(Integer cid, Integer startIndex, Integer pageSize, String rname) {
        StringBuilder sb = new StringBuilder();
        List<Object> paramList = new ArrayList<>();
        String sql = "select * from tab_route where cid =? ";
        sb.append(sql);
        paramList.add(cid);
        if (!StringUtils.isEmpty(rname)) {
            String rnameSql = " and rname like ? ";
            sb.append(rnameSql);
            paramList.add(rname);
        }
        String limitSql=" limit ?,?";
        sb.append(limitSql);
        paramList.add(startIndex);
        paramList.add(pageSize);
        return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<Route>(Route.class), paramList.toArray());
    }
}
