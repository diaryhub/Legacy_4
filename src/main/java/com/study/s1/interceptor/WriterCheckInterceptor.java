package com.study.s1.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.study.s1.board.BoardDTO;
import com.study.s1.member.MemberDTO;
@Component
public class WriterCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("WriterCheck Interceptor PostHandle");
		String method = request.getMethod();
		System.out.println("method:"+method);
		if (method.equals("POST")) {
			return;
		}
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		Map<String, Object> map = modelAndView.getModel();
		BoardDTO boardDTO =(BoardDTO) map.get("dto");
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			//Spring
			//1. foward
			modelAndView.addObject("message","권한이 없습니다.");
			modelAndView.addObject("path","./list");
			modelAndView.setViewName("common/result");
			//2. redirect
		}
		
		
	}
	
}
