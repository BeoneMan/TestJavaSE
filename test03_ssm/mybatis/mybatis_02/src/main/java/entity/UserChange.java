package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserChange implements Serializable {
    private static final long serialVersionUID = 2843406099718995354L;
    private Integer userId;
    private String userName;
    private Date userBirthday;
    private String userSex;
    private String userAddress;

}
