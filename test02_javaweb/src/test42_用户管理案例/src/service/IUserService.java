package service;

import entity.PageBean;
import entity.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<User> findAll();

    Boolean deleteUserById(Integer id);

    Boolean updateUserById(Integer id, User user);

    User findUserById(Integer id);

    Integer addUser(User user);

    User findUserByName(String name);

    Integer getCount(Map<String, String[]> parameterMap);

    PageBean<User> findByUserPage(String currentPage, String rows, Map<String, String[]> parameterMap);
}
