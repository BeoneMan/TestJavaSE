package mapper;

import dto.AccountDTO;

import java.util.List;

public interface AccountMapper {
    List<AccountDTO> findAllAccountUser();

}
