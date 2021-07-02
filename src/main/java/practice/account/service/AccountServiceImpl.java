package practice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import practice.account.domain.AccountVO;
import practice.account.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Setter(onMethod_ = @Autowired)
	private AccountMapper mapper;
	
	@Override
	public void register(AccountVO vo) {
		
		mapper.register(vo);
	}

	

	@Override
	public void get(AccountVO vo) {
		
		
	}
	
	

}
