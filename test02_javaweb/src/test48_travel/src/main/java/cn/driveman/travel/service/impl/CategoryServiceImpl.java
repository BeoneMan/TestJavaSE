package cn.driveman.travel.service.impl;

import cn.driveman.travel.dao.ICategoryDao;
import cn.driveman.travel.dao.impl.CategoryDaoImpl;
import cn.driveman.travel.entity.Category;
import cn.driveman.travel.service.ICategoryService;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
