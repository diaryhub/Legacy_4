package com.study.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankbookController {
	
	@Autowired
	private BankbookService bankbookService;
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception {
		List<BankbookDTO> ar = bankbookService.list();
		mv.addObject("list",ar);
		mv.setViewName("bankbook/list");
		return mv;
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(BankbookDTO bankbookDTO, Model model) throws Exception {
		bankbookDTO = bankbookService.detail(bankbookDTO);
		model.addAttribute("dto",bankbookDTO);
		return "bankbook/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankbookDTO bankbookDTO) throws Exception {
		int result = bankbookService.add(bankbookDTO);
		if(result>0) {
			System.out.println("insert sucsess");
			return "redirect:./list";
		}
		System.out.println("insert fail");
		return "redirect:./add";
	}
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add(ModelAndView modelAndView) {
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(BankbookDTO bankbookDTO) throws Exception {
		int result = bankbookService.delete(bankbookDTO);
		if(result>0) {
			System.out.println("delete sucsess");
		return "redirect:./list";
		}
		System.out.println("delete fail");
		return "redirect:./list";
	}
	
	
}
