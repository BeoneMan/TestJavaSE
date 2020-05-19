package dto;

import entity.Role;
import entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class RoleDTO extends Role implements Serializable {
    private List<User> userList;

}
