package example.service.impl;

import example.dao.IUserDao;
import example.dao.impl.UserDaoImpl;
import example.entity.User;
import example.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return dao.deleteUserById(id);
    }

    @Override
    public Boolean updateUserById(Integer id, User user) {
        return dao.updateUserById(id, user);
    }

    @Override
    public User findUserById(Integer id) {
        return dao.findUserById(id);
    }

    @Override
    public Integer addUser(User user) {
        return dao.addUser(user);
    }
}
