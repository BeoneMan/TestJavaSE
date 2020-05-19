package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 2082693648820630554L;

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;


}
