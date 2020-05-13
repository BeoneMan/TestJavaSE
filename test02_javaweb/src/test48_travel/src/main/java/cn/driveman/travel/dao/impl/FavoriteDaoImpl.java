package cn.driveman.travel.dao.impl;

import cn.driveman.travel.dao.IFavoriteDao;
import cn.driveman.travel.entity.Favorite;
import cn.driveman.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class FavoriteDaoImpl implements IFavoriteDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Favorite findFavoriteByRidAndUid(Integer uid, Integer rid) {
        String sql ="select * from tab_favorite where uid =? and rid =?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Favorite>(Favorite.class),uid,rid);
    }

    @Override
    public Integer findCountByRid(Integer rid) {
        String sql ="select count(*) from tab_favorite where rid = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,rid);
    }

    @Override
    public Integer addFavoriteByRidAndUid(Integer uid, Integer rid) {
        String sql ="insert into tab_favorite (rid,uid) values(?,?)";
        return jdbcTemplate.update(sql,uid,rid);
    }
}
