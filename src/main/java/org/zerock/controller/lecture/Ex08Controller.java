package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex08/*")
public class Ex08Controller {

	@RequestMapping("/sub01")
	public void method01(Model model) {
		//dispatcher servlet으로부터 model을 받음(parameter로)
		log.info("ex08 sub01 method");
		
		model.addAttribute("name", "donghu");
		model.addAttribute("age", 29);
		//jsp에서 ${}로 꺼내서 쓸 수 있음
		
		
	}
	
	@RequestMapping("/sub02")
	public void method02(Model model) {
		
		log.info("ex08 sub02 method");
		
		User user = new User(); 
		user.setId("lee");
		user.setAge(29);
		
		
		model.addAttribute("user", user);
	}
	
	@RequestMapping("/sub03")
	public String method03(Model model) {
		log.info("ex08 sub03 method");
		
		User user = new User();
		user.setId("good");
		user.setAge(100);
		
		model.addAttribute(user);
		//attribute 이름을 생략하면 클래스 이름(User)를 attribute 이름으로 사용
		//다만 클래스 이름의 첫글자를 대문자가 아닌 소문자로
		//model.addAttribute(user); 와  model.addAttribute("user", user); 는 같음
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub04")
	public String method04(User user, Model model) {
		log.info("ex08 sub04 method");
		
		model.addAttribute("user", user);
		//request parameter의 값을 적절히 user bean에 넣어주고 
		//그 user bean을 다시 model에 넣어줌
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub05")
	public String method05(@ModelAttribute("user") User user, Model model) {
		//@ModelAttribute() 어노테이션을 붙여서 자동으로 model에 들어가게 끔 함
		
		log.info("ex08 sub05 method");
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub06")
	public String method06(@ModelAttribute User user) {
		//어노테이션의 attribute명을 생략하면 class, type명으로 대시함
		//메소드에서 model을 쓰지 않으면 파라미터에서 쓰지 않아도 됨
		log.info("ex08 sub06 method");
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub07")
	public String method07(User user, Model model) {
		//어노테이션을 생략해도 위의 메소드와 같은 일을 함
		//자동으로 model로 들어감
		log.info("ex08 sub07 method");
		
		model.addAttribute("hello world"); //attribute 명이 생략되어있으면 type명이 대신함 (string)
		
		return "ex08/sub02";
	}
}
