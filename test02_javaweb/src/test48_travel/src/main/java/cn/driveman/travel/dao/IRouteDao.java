package cn.driveman.travel.dao;

import cn.driveman.travel.entity.Route;

import java.util.List;

public interface IRouteDao {
    List<Route> findRouteListByCid(Integer cid);
    Integer findTotalCount(Integer cid,String rname);
    List<Route> findRouteListByPage(Integer cid,Integer startIndex,Integer pageSize,String rname);
}
