package br.com.gsc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.gsc.model.tableMapping.Product;
import br.com.gsc.model.tableMapping.Topic;
import br.com.gsc.repository.objRepos.ProductRepository;
import br.com.gsc.repository.objRepos.TopicRepository;

@Controller
@RequestMapping("/listTopics.html")
public class ListTopicController {
	
	@Autowired
	ProductRepository pRepo;
	
	@Autowired
	TopicRepository tRepo;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showTopics(ModelAndView modelAndView){
		Product prod = pRepo.findTProductByID((long) 1);
		prod.getListOfTopics().size();
		List<Topic> lista = prod.getListOfTopics();
		return new ModelAndView("listTopics").addObject("topics",lista);
	}
}
