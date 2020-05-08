package cn.driveman.travel.dao;

import cn.driveman.travel.entity.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> findAll();

}
