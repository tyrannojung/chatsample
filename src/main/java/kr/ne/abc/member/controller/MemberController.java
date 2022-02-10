package kr.ne.abc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.ne.abc.member.dto.MemberDTO;
import kr.ne.abc.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@PostMapping("/user")
	public ModelAndView user(MemberDTO memberDTO) {
		
		memberService.signUp(memberDTO);
		
		ModelAndView mav = new ModelAndView("/login");
		return mav;
    }
	
	  @GetMapping(value = "/logout")
	  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
	    new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
	    
	    return "redirect:/login";
	  }
	  
}
