package entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -7275753651525337465L;

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public User(){}
    public User(String username, Date birthday, String sex, String address) {
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }
}
