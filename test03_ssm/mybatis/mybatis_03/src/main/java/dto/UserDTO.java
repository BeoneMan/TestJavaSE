package dto;

import entity.Account;
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
public class UserDTO extends User implements Serializable {
    private List<Account> accountList;
    private List<Role> roleList;

}
