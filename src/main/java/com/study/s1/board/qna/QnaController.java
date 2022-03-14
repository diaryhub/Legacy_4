package com.study.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.study.s1.board.BoardDTO;
import com.study.s1.board.notice.NoticeFileDTO;
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
	
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public ModelAndView fileDown(QnaFileDTO qnaFileDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fileDown");
		qnaFileDTO = qnaService.detailFile(qnaFileDTO);
		mv.addObject("file",qnaFileDTO);
		return mv;
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ModelAndView reply(QnaDTO qnaDTO,ModelAndView mv) throws Exception {	
		mv.addObject("dto", qnaDTO);
		mv.setViewName("board/reply");
		return mv;
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public ModelAndView reply(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.reply(qnaDTO);
		mv.setViewName("redirect:./list");
		return mv;
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
	public String add(QnaDTO qnaDTO, MultipartFile [] files) throws Exception {
		int result = qnaService.add(qnaDTO,files);
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















