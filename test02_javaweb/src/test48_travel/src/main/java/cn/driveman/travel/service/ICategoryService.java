package cn.driveman.travel.service;

import cn.driveman.travel.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
