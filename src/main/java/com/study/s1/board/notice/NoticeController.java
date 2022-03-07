package com.study.s1.board.notice;

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
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String board() {
		return "notice";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete (NoticeDTO noticeDTO)throws Exception{
		int result = noticeService.delete(noticeDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value = "list", method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mv,Pager pager) throws Exception {
		List<BoardDTO> ar = noticeService.list(pager);
		mv.addObject("list",ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		return mv;
	}
	@RequestMapping(value = "detail", method=RequestMethod.GET)
	public String detail(BoardDTO boardDTO,Model model) throws Exception {
		boardDTO = noticeService.detail(boardDTO);
		model.addAttribute("dto",boardDTO);
		return "board/detail";
	}
	@RequestMapping(value = "add", method=RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);
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
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		if(result>0) {
			System.out.println("update sucsess");
			return "redirect:./list";
		}
		return "redirect:./update";
	}
	@RequestMapping(value = "update", method=RequestMethod.GET)
	public String update(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO=noticeService.detail(boardDTO);
		model.addAttribute("dto",boardDTO);
		return "board/update";
	}
	
}
