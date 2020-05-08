package cn.driveman.travel.service;

import cn.driveman.travel.domain.PageBean;
import cn.driveman.travel.entity.Route;

public interface IRouteService {
    PageBean<Route> queryPage(Integer cid, Integer currentPage, Integer pageSize,String rname);
}
