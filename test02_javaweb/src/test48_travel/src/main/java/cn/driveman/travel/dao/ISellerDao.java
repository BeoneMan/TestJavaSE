package cn.driveman.travel.dao;

import cn.driveman.travel.entity.Seller;

public interface ISellerDao {
    Seller findSellerById(Integer id);
}
