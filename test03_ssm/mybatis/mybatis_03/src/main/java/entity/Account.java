package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = -7692252879405579572L;
    private Integer id;
    private Integer uid;
    private Double money;
}
