package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RequestMapping("/sample")
@RestController
@Log4j
public class SampleRestController {
	
	@GetMapping(value ="/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN);
		return "안녕하세요";
	}
	
	@RequestMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	@RequestMapping("/getList")
	public List<SampleVO> getList(){
		
		List<SampleVO> list = new ArrayList<>();
		
		for(int i=1; i<10; i++) {
			list.add(new SampleVO(i, i + "First", i +"Last"));
		}
		return list;
	}
	
	@RequestMapping("/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<>();
		map.put("first", new SampleVO(111, "그루트", "주니어"));
		
		return map;
	}
	
	@RequestMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") String pid) {
		return new String[] {"category: " + cat, "productid: " + pid};
	}
}
