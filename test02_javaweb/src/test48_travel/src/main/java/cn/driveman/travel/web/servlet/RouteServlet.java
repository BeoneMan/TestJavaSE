package cn.driveman.travel.web.servlet;

import cn.driveman.travel.domain.PageBean;
import cn.driveman.travel.entity.Route;
import cn.driveman.travel.service.IRouteService;
import cn.driveman.travel.service.impl.RouteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    IRouteService routeService = new RouteServiceImpl();
    ObjectMapper objectMapper = new ObjectMapper();
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cidStr = request.getParameter("cid");
        String rname = request.getParameter("rname");

        Integer cid = 1;
        if(!StringUtils.isEmpty(cidStr)){
            cid =  Integer.parseInt(cidStr);
        }
        String currentPageStr = request.getParameter("currentPage");
        Integer currentPage = 1;
        if(!StringUtils.isEmpty(currentPageStr)){
            currentPage =  Integer.parseInt(currentPageStr);
        }

        if(!StringUtils.isEmpty(rname)){
            rname="%"+rname+"%";
        }

        PageBean<Route> pageBean = routeService.queryPage(cid, currentPage, 10,rname);
        response.setContentType("application/json,charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),pageBean);
    }

}
