package cn.driveman.travel.service.impl;

import cn.driveman.travel.dao.IFavoriteDao;
import cn.driveman.travel.dao.IRouteDao;
import cn.driveman.travel.dao.IRouteImgDao;
import cn.driveman.travel.dao.ISellerDao;
import cn.driveman.travel.dao.impl.FavoriteDaoImpl;
import cn.driveman.travel.dao.impl.RouteDaoImpl;
import cn.driveman.travel.dao.impl.RouteImgImpl;
import cn.driveman.travel.dao.impl.SellerDaoImpl;
import cn.driveman.travel.domain.PageBean;
import cn.driveman.travel.entity.Route;
import cn.driveman.travel.entity.RouteImg;
import cn.driveman.travel.entity.Seller;
import cn.driveman.travel.service.IRouteService;
import org.springframework.util.StringUtils;

import java.util.List;

public class RouteServiceImpl implements IRouteService {
    IRouteDao routeDao = new RouteDaoImpl();
    ISellerDao sellerDao =  new SellerDaoImpl();
    IRouteImgDao routeImgDao =  new RouteImgImpl();
    IFavoriteDao favoriteDao = new FavoriteDaoImpl();

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
    // 根据id查找详情页
    @Override
    public Route findRouteById(Integer id) {
        Route route = routeDao.findRouteById(id);
        if(!StringUtils.isEmpty(route)){
            Seller seller = sellerDao.findSellerById(route.getSid());
            List<RouteImg> routeImgListByRid = routeImgDao.findRouteImgListByRid(route.getRid());
            route.setSeller(seller);
            route.setRouteImgList(routeImgListByRid);
        }
        return route;
    }

    @Override
    public Integer findCountByRid(Integer rid) {
        return favoriteDao.findCountByRid(rid);
    }
}
