package dto;

import entity.Account;
import entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class AccountDTO extends Account implements Serializable {
    private User user;
}
