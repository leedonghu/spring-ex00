package practice.account.service;

import practice.account.domain.AccountVO;

public interface AccountService {
	
	public void register(AccountVO vo);
	
	public void get(AccountVO vo);
	
	public boolean checkId(String id);
}
