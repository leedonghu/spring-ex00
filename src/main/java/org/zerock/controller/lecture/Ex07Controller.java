package org.zerock.controller.lecture;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@RequestMapping("/ex07/*")
@Log4j
@Controller
public class Ex07Controller {
	
	
	@RequestMapping("/sub01")
	public @ResponseBody String method01() {
		log.info("ex07 sub01 method");
		
		return "zzzzzz";
		//리턴타입 앞에 @ResponseBody를 붙이면 return값이 응답 자체가 됨
	}
	
	@RequestMapping("/sub02")
	public @ResponseBody String method02() {
		log.info("ex07 sub02 method");
		
		User user = new User();
		user.setId("donghu");
		user.setAge(29);
		
		return user.toString();
		//객체를 넘기고 싶을때
	}
	
	@RequestMapping("/sub03")
	public @ResponseBody String method03() {
		log.info("ex07 sub03 method");
		
		User user = new User();
		user.setId("donghu");
		user.setAge(29);
		
		return "{\"id\":" +"\"" +user.getId() + "\", " + "\"age\":" + user.getAge() + "}" ;
		//json (자바스크립트)식 객체 표현
	}
	
	@RequestMapping("/sub04")
	public @ResponseBody User method04() {
		log.info("ex07 sub04 method");
		
		User user = new User();
		user.setId("lee");
		user.setAge(29);
		
		return user;
		//라이브러리 등록 후에는 method03의 return값처럼 복잡하게 작성하지 않아도 됨
	}
	
	@RequestMapping("/sub05")
	public ResponseEntity<String> method05() {
		log.info("ex07 sub05 method");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=utf-8");
		headers.add("my-header", "my-value");
		String body = "<h1>Hello Entity</h1>";
		
		
//		ResponseEntity<String> entity
		//본문(body), 부가정보(header), 상태코드, 값 을 entity가 가짐
		
		return new ResponseEntity<String>(body, headers, HttpStatus.OK);
		//응답 자체를 보냄
	}
}
