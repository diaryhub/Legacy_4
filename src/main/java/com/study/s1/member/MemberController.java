package com.study.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	private MemberService service;

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String Join(MemberDTO memberDTO) throws Exception {
		int result = service.join(memberDTO);
		if (result != 0)
			return "redirect:../";
		return "member/join";
	}

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String Join() throws Exception {
		return "member/join";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login() {}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO) throws Exception {
		memberDTO = service.login(memberDTO);
		if(memberDTO!=null)
		return "redirect:../";
		
		return "redirect:./login";
	}
	
}
