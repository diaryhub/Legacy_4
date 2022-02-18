package com.study.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "list", method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception {
		List<NoticeDTO> ar = noticeService.list();
		mv.addObject("list",ar);
		mv.setViewName("notice/list");
		return mv;
	}
	@RequestMapping(value = "detail", method=RequestMethod.GET)
	public String detail(NoticeDTO noticeDTO,Model model) throws Exception {
		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto",noticeDTO);
		return "notice/detail";
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
		return "notice/add";
	}
	
}
