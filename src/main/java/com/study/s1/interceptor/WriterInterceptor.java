package com.study.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.study.s1.board.BoardDTO;
import com.study.s1.board.qna.QnaDAO;
import com.study.s1.board.qna.QnaDTO;
import com.study.s1.member.MemberDTO;


@Component
public class WriterInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check=true;
		Long num = Long.parseLong(request.getParameter("num"));
		BoardDTO boardDTO = new QnaDTO();
		boardDTO.setNum(num);
		boardDTO = qnaDAO.detail(boardDTO);
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			check = false;
			//1. foward
			request.setAttribute("message", "비정상적인 접근입니다.");
			request.setAttribute("path", "./list");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			//2. redirect
//			response.sendRedirect("./list");
		}
		return check;
	}
	
}
