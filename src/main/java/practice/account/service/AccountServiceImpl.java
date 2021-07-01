package practice.account.service;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import practice.account.domain.AccountVO;
import practice.account.mapper.AccountMapper;

public class AccountServiceImpl implements AccountService {
	
	@Setter(onMethod_ = @Autowired)
	private AccountMapper mapper;
	
	@Override
	public boolean register(AccountVO vo) {
		
		return mapper.register(vo) == 1;
	}

	

	@Override
	public void get(AccountVO vo) {
		mapper.get(vo);
		
	}
	
	

}
