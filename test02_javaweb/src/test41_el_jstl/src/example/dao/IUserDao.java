package example.dao;

import example.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    Boolean deleteUserById(Integer id);
    Boolean updateUserById(Integer id,User user);
    User findUserById(Integer id);
    Integer findVersionById(Integer id);
    Integer addUser(User user);
}
