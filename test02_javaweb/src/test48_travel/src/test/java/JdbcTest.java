import cn.driveman.travel.dao.impl.RouteDaoImpl;
import cn.driveman.travel.entity.Route;
import cn.driveman.travel.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public class JdbcTest {
    @Test
    public void test01() throws SQLException {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        RouteDaoImpl routeDao = new RouteDaoImpl();
//        Integer totalCount = routeDao.findTotalCount(5, "");
//        System.out.println(totalCount);
        List<Route> routeListByPage = routeDao.findRouteListByPage(5, 0, 10, "");
        System.out.println(routeListByPage.size());
    }

}
