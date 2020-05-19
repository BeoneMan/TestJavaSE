package mapper;

import entity.User;
import entity.UserChange;
import org.apache.ibatis.annotations.Param;
import vo.QueryVo;

import java.util.List;

public interface UserMapper {
    User findUserById(@Param("id") Integer id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(@Param("id") Integer id);
    List<User> findUserListByLikeName(@Param("name") String name);
    int findTotal();
    List<User> findUserListByQueryVo(QueryVo queryVo);
    //结果集封装有所不同
    List<UserChange> findAll();
}
