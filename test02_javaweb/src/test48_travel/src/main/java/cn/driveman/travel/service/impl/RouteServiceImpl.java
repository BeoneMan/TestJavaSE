package cn.driveman.travel.service.impl;

import cn.driveman.travel.dao.IRouteDao;
import cn.driveman.travel.dao.impl.RouteDaoImpl;
import cn.driveman.travel.domain.PageBean;
import cn.driveman.travel.entity.Route;
import cn.driveman.travel.service.IRouteService;

import java.util.List;

public class RouteServiceImpl implements IRouteService {
    IRouteDao routeDao = new RouteDaoImpl();
    @Override
    public PageBean<Route> queryPage(Integer cid, Integer currentPage, Integer pageSize,String rname) {

        PageBean<Route> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        Integer totalCount = routeDao.findTotalCount(cid,rname);
        pageBean.setTotalCount(totalCount);
        int totalPage=totalCount%pageSize!=0?totalCount/pageSize+1:totalCount/pageSize;
        pageBean.setTotalPage(totalPage);
        Integer startIndex=(currentPage-1)*pageSize;
        List<Route> routeList = routeDao.findRouteListByPage(cid, startIndex, pageSize,rname);
        pageBean.setList(routeList);
        return pageBean;
    }
}
