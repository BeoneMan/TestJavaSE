package cn.driveman.travel.dao;

import cn.driveman.travel.domain.User;

public interface IUserDao {
    User findUserByName(String username);
    int save(User user);
    User findUserByCode(String code);
    int updateUserActive(Integer userId);
    User findUserByUsernameAndPassword(String username,String password);
}
