package com.study.s1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO=service.mypage(memberDTO);
		mv.setViewName("member/mypage");
		mv.addObject("dto", memberDTO);
		return mv;
	}
	
	@RequestMapping(value = "logout" , method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String Join(MemberDTO memberDTO, MultipartFile photo) throws Exception {
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getSize());
		int result = service.join(memberDTO,photo);
		return "redirect:../";
	}

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String Join() throws Exception {
		return "member/join";
	}
	@RequestMapping(value = "joinCheck", method = RequestMethod.GET)
	public void joinCheck() throws Exception{}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(@CookieValue(value = "remember", defaultValue = "")String rememberId, Model model) {
		model.addAttribute("rememberId", rememberId);
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpSession session , MemberDTO memberDTO, Model model) throws Exception {
		memberDTO = service.login(memberDTO);
//		String path = "redirect:./login";
//		if(memberDTO!=null) {
//			session.setAttribute("member", memberDTO);
//			path = "redirect:../";
//		}
		
		String message = "Login Fail";
		String p = "./login";
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			message ="Login Success";
			p="../";
		}
		model.addAttribute("path", p);
		model.addAttribute("message", message);
		String path = "common/result";	
		return path;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO) throws Exception {
		int result = service.update(memberDTO);
		if (result != 0)
			return "redirect:../";
		return "redirect:./update";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(MemberDTO memberDTO, Model model) throws Exception {
		memberDTO = service.mypage(memberDTO);
		model.addAttribute("dto", memberDTO);
		return "member/update";
	}
	
}
