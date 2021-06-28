package practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/start")
public class StartController {
	
	@RequestMapping("/first")
	public String start() {
		
		return "/practice/startPage";
	}
}
