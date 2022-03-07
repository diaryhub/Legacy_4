package com.study.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.s1.board.BoardDTO;

import com.study.s1.util.Pager;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String board() {
		return "qna";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(QnaDTO qnaDTO, Model model) throws Exception{
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}
	
	//list
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public String list (Pager pager,Model model) throws Exception{
		List<BoardDTO> ar =qnaService.list(pager);
		model.addAttribute("list", ar);
		return "board/list";
	}
	
	@RequestMapping(value = "add", method=RequestMethod.POST)
	public String add(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.add(qnaDTO);
		if(result>0) {
			System.out.println("insert sucsess");
			return "redirect:./list";
		}
		return "redirect:./";
	}
	
	@RequestMapping(value = "add", method=RequestMethod.GET)
	public String add(ModelAndView mv) throws Exception {
		return "board/add";
	}
	
	@RequestMapping(value = "update", method=RequestMethod.POST)
	public String update(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.update(qnaDTO);
		if(result>0) {
			System.out.println("update sucsess");
			return "redirect:./list";
		}
		return "redirect:./update";
	}
	@RequestMapping(value = "update", method=RequestMethod.GET)
	public String update(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO=qnaService.detail(boardDTO);
		model.addAttribute("dto",boardDTO);
		return "board/update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(BoardDTO boardDTO) throws Exception {
		int result = qnaService.delete(boardDTO);
			return "redirect:./list";
		
	}
	
}
