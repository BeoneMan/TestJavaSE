package cn.driveman.travel.dao;

import cn.driveman.travel.entity.Favorite;

public interface IFavoriteDao {
    Favorite findFavoriteByRidAndUid(Integer uid,Integer rid);
    Integer findCountByRid(Integer rid);
    Integer addFavoriteByRidAndUid(Integer uid,Integer rid);
}
