package cn.driveman.travel.service.impl;

import cn.driveman.travel.dao.IFavoriteDao;
import cn.driveman.travel.dao.impl.FavoriteDaoImpl;
import cn.driveman.travel.entity.Favorite;
import cn.driveman.travel.service.IFavoriteService;

public class FavoriteServiceImpl implements IFavoriteService {
    IFavoriteDao favoriteDao = new FavoriteDaoImpl();
    @Override
    public Favorite findFavoriteByRidAndUid(Integer uid, Integer rid) {
        return favoriteDao.findFavoriteByRidAndUid(uid,rid);
    }

    @Override
    public Integer addFavoriteByRidAndUid(Integer uid, Integer rid) {
        return favoriteDao.addFavoriteByRidAndUid(uid,rid);
    }
}
