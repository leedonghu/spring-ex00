package org.zerock.controller;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.security.domain.CustomUser;
import org.zerock.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@RequestMapping("/login")
	public void login() {
		log.info("member login method");
	}
	
	@GetMapping("/signup")
	public void signup(Criteria cri) {
		
	}
	
	@PostMapping("/signup")
	public String signupPost(MemberVO vo, RedirectAttributes rttr) {
		log.info(vo);
		
		boolean ok = service.insert(vo);
		
		if(ok) {
			return "redirect:/board/list";
		}else {
			return "redirect:/member/signup?error";
		}
	}
	
	@GetMapping("/info")
	@PreAuthorize("isAuthenticated()")
	public void info(Criteria cri, Principal principal, Model model) {
		//Principal을 파라미터에 넣어주면 로그인된 사용자의 정보를 보내줌
		log.info(principal.getName());
		
		MemberVO member = service.read(principal.getName());
		
		model.addAttribute("member", member);
	}
	
	
	@PostMapping("/modify")
	@PreAuthorize("principal.username == #vo.userid")
	public String modify(MemberVO vo, RedirectAttributes rttr, Authentication auth) {
		boolean ok = service.modify(vo);
		
		if(ok) {
			rttr.addAttribute("status", "success");
			
			//session의 authentication 수정
			//글쓰기에서 글쓴이의 값을 업데이트 해줘야 해서
			CustomUser user = (CustomUser)auth.getPrincipal();
			user.setMember(vo);
			
		}else {
			rttr.addAttribute("status", "error");
		}
		return "redirect:/member/info";
	}
	
	@PostMapping("/remove")
	@PreAuthorize("principal.username == #vo.userid")
	public String remove(MemberVO vo, RedirectAttributes rttr, HttpServletRequest req) throws ServletException {
		boolean ok = service.remove(vo);
		
		if(ok) {
			req.logout();
			return "redirect:/borad/list";
		}else {
			rttr.addAttribute("status", "error");
			return "redirect:/member/info";
		}
	}
}
