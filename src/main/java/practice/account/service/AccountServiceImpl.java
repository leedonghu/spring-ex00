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
	
	@Override
	public boolean checkId(String id) {
		
		boolean check = mapper.checkId(id);
		String idForm = "^[a-zA-Z0-9]{5,10}$";
		
		if(check) {
			if(id.matches(idForm)) {
				return true;
			}else {
				return false;
			}
		}else {
			
			return false;
		}
		
		
	}
	

}
