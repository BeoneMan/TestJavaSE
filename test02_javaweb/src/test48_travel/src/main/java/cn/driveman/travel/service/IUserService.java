package cn.driveman.travel.service;

import cn.driveman.travel.entity.User;

public interface IUserService {
    User findUserByName(String username);
    Integer save(User user);
    Boolean activeUser(String code);
    User findUserByUsernameAndPassword(String username,String password);
}
