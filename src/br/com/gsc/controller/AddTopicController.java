package br.com.gsc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gsc.model.tableMapping.Person;
import br.com.gsc.model.tableMapping.Product;
import br.com.gsc.model.tableMapping.Topic;
import br.com.gsc.model.tableMapping.User;
import br.com.gsc.repository.objRepos.PersonRepository;
import br.com.gsc.repository.objRepos.ProductRepository;
import br.com.gsc.repository.objRepos.TopicRepository;

@Controller
@RequestMapping("/addtopic.html")
public class AddTopicController {

	@Autowired
	TopicRepository top;
	@Autowired
	PersonRepository per;
	@Autowired
	ProductRepository pro;
	
	@ModelAttribute("topic")
	public Topic createForm(){
		return new Topic();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model){
		Topic topic = new Topic();
		model.put("topic", topic);
		return "addtopic";		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addtopic(@ModelAttribute("topic") Topic topic){		
		Topic newTopic = new Topic();
		newTopic.setTopicTitle(topic.getTopicTitle());
		newTopic.setTopicContent(topic.getTopicContent());
		Person p = per.findPersonByID(SecurityContextHolder.getContext().getAuthentication().getName());
		newTopic.setPerson(p);
		Product pro = new Product();
		pro.setName("teste");
		pro.setId(1);
		newTopic.setProduct(pro);
		top.addTopic(newTopic);
		return "redirect:/user";
	}
	
}
