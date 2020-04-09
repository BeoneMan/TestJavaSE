package example.service;

import example.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    Boolean deleteUserById(Integer id);

    Boolean updateUserById(Integer id, User user);

    User findUserById(Integer id);

    Integer addUser(User user);
}
