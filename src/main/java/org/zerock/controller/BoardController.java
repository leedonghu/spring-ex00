package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j
public class BoardController {
	
	private BoardService service;
	
	/*
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	*/

	@GetMapping("/list")
	public void list(@ModelAttribute("cri") Criteria cri, Model model) {
		//파라미터로 들어가있는 Criteria는 @ModelAttribute. 즉, model에 criteria라는 이름으로 들어가있음 
		//타입명이 attribute 명이 됨
		log.info("board/list method.....");
		int total = service.getTotal(cri); //TODO : 나중에 구하는 코드 작성해야 함
		
		// service getList() 실행 결과를
		List<BoardVO> list = service.getList(cri);
		
		// model에 attribute로 넣고
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		// view로 포워드
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		// service에게 등록업무 시키고
		service.register(board); // title, content, writer가 파라미터의 bean에 들어감
		
		// redirect 목적지로 정보 전달
		rttr.addFlashAttribute("result", board.getBno());
		rttr.addFlashAttribute("messageTitle", "등록성공");
		rttr.addFlashAttribute("messageBody", board.getBno()+"등록되었습니다.");
		
		// /board/list redirect
		return "redirect:/board/list";
	}
	
	
	//하나만 조회하는 메소드
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno,@ModelAttribute("cri") Criteria cri, Model model) {
		
		log.info("board/get method");
		
		//service에게 일 시킴
		BoardVO vo = service.get(bno);
		
		//결과를 모델에 넣음
		model.addAttribute("board", vo);
		
		//forward
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		//request parameter 수집
		
		//service 일 시킴
		boolean success = service.modify(board);
		
		//결과를 모델(또는 FlashMap)에 넣고
		if(success) {
			
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("messageTitle", "수정성공");
			rttr.addFlashAttribute("messageBody", "수정되었습니다.");
			
		}
		
		//쿼리스트링으로 넘길때는 addAttribute
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		//forward or redirect
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, Criteria cri, RedirectAttributes rttr) {
		//parameter 수집
		
		//service 일
		boolean success = service.remove(bno);
		//결과 담고
		if(success) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("messageTitle", "삭제성공");
			rttr.addFlashAttribute("messageBody", "삭제되었습니다.");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		//forward or redirect
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register(@ModelAttribute("cri") Criteria cri) {
		// WEB-INF/views/board/register.jsp로 forward
	}
	
	
}
