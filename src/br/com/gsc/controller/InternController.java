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

@Controller
@RequestMapping("/intern.html")
public class InternController {

	@Autowired
	ProductRepository pRepo;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showPage(){
		Product prod = pRepo.findTProductByID((long) 1);
		prod.getListOfTopics().size();
		List<Topic> lista = prod.getListOfTopics();
		Topic topic = new Topic();
		
		ModelAndView model = new ModelAndView("intern");
		model.addObject("topics",lista);
		model.addObject("topic",topic);
		
		return model;
	}
}
