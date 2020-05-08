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
        List<Route> routeList = template.query("select * from tab_route", new BeanPropertyRowMapper<Route>(Route.class));
        for (Route route : routeList) {
            System.out.println(route);
        }
    }
}
