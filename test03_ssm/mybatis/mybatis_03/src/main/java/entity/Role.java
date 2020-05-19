package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 6145899989328005564L;
    private Integer id;
    private String roleName;
    private String roleDesc;
}
