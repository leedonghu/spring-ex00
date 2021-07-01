package practice.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Setter;
import practice.account.domain.AccountVO;
import practice.account.service.AccountService;

@Controller
@RequestMapping("/acc")
public class AccountController {
	
	@Setter(onMethod_ = @Autowired)
	private AccountService service;
	
	@RequestMapping("/register")
	public String register(AccountVO vo) {
		service.register(vo);
		
		return "redirect:/start/first";
	}
	
	@RequestMapping("/login")
	public String login(AccountVO vo) {
		
		
		return "";
	}
	
}
