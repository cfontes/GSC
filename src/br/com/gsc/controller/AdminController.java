package br.com.gsc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/**")
public class AdminController {
	
	@RequestMapping(method = RequestMethod.GET, value="/index.*")
	public ModelAndView showAdminPage(){
		ModelAndView model = new ModelAndView("/admin/index");
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addObject("user",user);
		return model;
	}

}
