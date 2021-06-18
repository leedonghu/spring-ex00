package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex09/*")
public class Ex09Controller {
	
	@RequestMapping("/sub01")
	public String method01(RedirectAttributes rttr) {
		//RedirectAttributes rttr : redirect용 attribute 
		//redirect에 붙여서 보냄
		
		log.info("ex09 sub01 method");
		
		//redirect하는 경로에 쿼리스트링으로 보냄
		rttr.addAttribute("name", "lee");
		rttr.addAttribute("id", 300);
		
		return ("redirect:sub02");//상대경로
//		return ("redirect:/ex09/sub02"); 절대경로
	}
	
	@RequestMapping("/sub02")
	public void method02() {
		log.info("ex09 sub02 method");
	}
	
	@RequestMapping("/sub03")
	public String method03(RedirectAttributes rttr) {
		log.info("ex09 sub03 method");
		
		
		User user = new User();
		user.setAge(29);
		user.setId("donghu");
		//rttr.addAttribute("user", new User()); 객체를 쿼리스트링으로 넘길 수 없음
		rttr.addFlashAttribute("user", user); //내부 세션에 저장해놓았다가 받으면 세션에서 사라지게하는 메소드
		
		return "redirect:sub04";
	}
	
	@RequestMapping("/sub04")
	public void method04(Model model) {
		log.info("ex09 sub04 method");
		
		log.info(model.asMap().get("user"));
	}
}
