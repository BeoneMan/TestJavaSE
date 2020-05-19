package mapper;

import entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface UserAnnotationMapper {
    @Select("select * from user")
    List<User> findAll();
}
