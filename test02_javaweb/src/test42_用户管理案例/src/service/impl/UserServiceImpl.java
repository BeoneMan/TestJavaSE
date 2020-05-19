package service.impl;

import mapper.IUserDao;
import mapper.impl.UserDaoImpl;
import entity.PageBean;
import entity.User;
import service.IUserService;

import java.util.List;
import java.util.Map;

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

    @Override
    public User findUserByName(String name) {
        return dao.findUserByName(name);
    }

    @Override
    public Integer getCount(Map<String, String[]> parameterMap) {
        return dao.getCount(parameterMap);
    }

    @Override
    public PageBean<User> findByUserPage(String currentPage, String rows, Map<String, String[]> parameterMap) {
        PageBean<User> pb = new PageBean<>();
        Integer cp = Integer.valueOf(currentPage);
        Integer r = Integer.valueOf(rows);
        pb.setCurrentPage(cp);
        pb.setRows(r);
        Integer start=(cp-1)*r;
        List<User> users = dao.findByUserPage(start, r, parameterMap);
        pb.setList(users);
        Integer count = getCount(parameterMap);
        pb.setTotalCount(count);
        System.out.println(Math.ceil(1.5));
        pb.setTotalPage(count%r==0?count/r:count/r+1);
        return pb;
    }
}
