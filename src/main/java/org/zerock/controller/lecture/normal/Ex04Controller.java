package org.zerock.controller.lecture.normal;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex04/*")
@Log4j
public class Ex04Controller {
	
	@RequestMapping("/sub01")
	public void method01(@RequestParam String date) {
		log.info("ex04 sub01 method");
		
		log.info(date);
	}
	
	@RequestMapping("/sub02")
	public void method02(@RequestParam Date date) {
		log.info("ex04 sub02 method");
		
		//String이 Date로 자동변환되지 않음
		log.info(date);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//다른 메소드가 실행되기 전에 실행
		log.info("init binder");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
		
		//String을 Date(첫 번째 파라미터)로 변환해야 한다면 CustomDateEditor()(두 번째 파라미터)를 써라
		//binder가 그 일을 함
		
	}
}
