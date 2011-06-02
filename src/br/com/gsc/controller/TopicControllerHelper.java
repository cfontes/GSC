package br.com.gsc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.gsc.model.tableMapping.Product;
import br.com.gsc.model.tableMapping.Topic;
import br.com.gsc.repository.objRepos.ProductRepository;

@Service
public class TopicControllerHelper {

	@Autowired
	ProductRepository pRepo;
	
	public ModelAndView initInternPage(){
		Product prod = pRepo.findTProductByID((long) 1);
		prod.getListOfTopics().size();
		List<Topic> lista = prod.getListOfTopics();
		Topic topic = new Topic();
		ModelAndView model = new ModelAndView("/intern");
		model.addObject("topics",lista);
		model.addObject("topic",topic);
		return model;
	}
	
	
}
