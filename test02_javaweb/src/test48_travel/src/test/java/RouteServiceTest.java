import cn.driveman.travel.entity.Route;
import cn.driveman.travel.service.IRouteService;
import cn.driveman.travel.service.impl.RouteServiceImpl;
import org.junit.Test;

public class RouteServiceTest {
    IRouteService routeService = new RouteServiceImpl();
    @Test
    public void testFindRouteById(){
        Route routeById = routeService.findRouteById(1);
        System.out.println(routeById);
    }
}
