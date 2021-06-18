package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex06/*")
public class Ex06Controller {
	
	
	@RequestMapping("/sub01")
	public String method01() {
		
		log.info("ex06 sub01 method");
		return "ex06/sub01"; //servlet-context.xml에서 리턴받은 String 앞에는 /WEB-INF/views를 붙이고, 뒤에는 .jsp를 붙여서 포워드 시킴
		                     // /WEB-INF/views/ex06-sub01.jsp
		
	}
	
	@RequestMapping("/sub02")
	public void method02() {
		log.info("ex06 sub02 method");
		//return 타입이 void이면 view 의 jsp 이름을 요청받은 경로(/ex06/sub02)와 동일하게 해석함(dispatcherServlet)
	}
	
	@RequestMapping("/sub03")
	public String method03() {
		log.info("ex06 sub03 method");
		
		return "forward:/ex06/sub02"; //view이름으로 해석되지 않고 /ex06/sub02로 forward시켜서 일을 시킴
		                              //한번의 요청, 주소창이 바뀌지 않음
	}
	
	
	@RequestMapping("/sub04")
	public String method04() {
		log.info("ex06 sub04 method");
		
		
		//response.sendRedirect(request.getContextPath() + "/~~");
		return "redirect:/ex06/sub02"; //2번의 요청, 주소창이 바뀜
	}
}
