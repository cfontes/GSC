package br.com.gsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.gsc.model.tableMapping.Product;
import br.com.gsc.repository.objRepos.ProductRepository;

@Controller
@RequestMapping("/listTopic.html")
public class ListTopicController {
	
	@Autowired
	ProductRepository pRepo;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showTopics(ModelAndView modelAndView){
		Product prod = pRepo.findTProductByID((long) 1);
//		modelAndView.setView(listTopics);
		
		return null;
	}
}
