package mapper;


import dto.UserDTO;
import entity.User;
import vo.QueryVO;

import java.util.List;

public interface UserMapper {

    List<User> findAll();
    List<User> findByUser(User user);
    List<User> findByQueryVoIds(QueryVO queryVo);
    List<UserDTO> findUserAccount();
    List<UserDTO> findUserRole();
}
