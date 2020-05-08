package cn.driveman.travel.service.impl;

import cn.driveman.travel.dao.IUserDao;
import cn.driveman.travel.dao.impl.UserDaoImpl;
import cn.driveman.travel.domain.User;
import cn.driveman.travel.service.IUserService;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao= new UserDaoImpl();
    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public Integer save(User user) {
        return userDao.save(user);
    }

    @Override
    public Boolean activeUser(String code) {
        User userByCode = userDao.findUserByCode(code);
        if(userByCode!=null){
            userDao.updateUserActive(userByCode.getUid());
            return true;
        }
        return false;
    }
}
