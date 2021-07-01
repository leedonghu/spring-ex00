package practice.account.mapper;

import practice.account.domain.AccountVO;

public interface AccountMapper {
	
	public int register(AccountVO vo);
	
	public AccountVO get(String id);
}
