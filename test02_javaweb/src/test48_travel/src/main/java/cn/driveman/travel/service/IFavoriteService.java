package cn.driveman.travel.service;

import cn.driveman.travel.entity.Favorite;

public interface IFavoriteService {
    Favorite findFavoriteByRidAndUid(Integer uid, Integer rid);
    Integer addFavoriteByRidAndUid(Integer uid,Integer rid);
}
