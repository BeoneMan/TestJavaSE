package dao;

import entity.PageBean;
import entity.User;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    List<User> findAll();
    Boolean deleteUserById(Integer id);
    Boolean updateUserById(Integer id, User user);
    User findUserById(Integer id);
    Integer findVersionById(Integer id);
    Integer addUser(User user);
    User findUserByName(String name);
    Integer getCount(Map<String, String[]> parameterMap);
    List<User> findByUserPage(Integer start, Integer rows, Map<String, String[]> parameterMap);
}
