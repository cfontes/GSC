package br.com.gsc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gsc.model.tableMapping.Topic;

@Controller
@RequestMapping("/user/index.html")
public class UserController {
	
	@ModelAttribute("topic")
	public Topic createForm(){
		System.out.println("topic");
		return new Topic();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="index")
	public String showForm(){
		return "/user/index";		
	}
	
}
