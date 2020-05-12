package cn.driveman.travel.dao;

import cn.driveman.travel.entity.RouteImg;

import java.util.List;

public interface IRouteImgDao {
    List<RouteImg> findRouteImgListByRid(Integer sourceId);
}
