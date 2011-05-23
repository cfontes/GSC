package br.com.gsc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.gsc.model.tableMapping.Person;
import br.com.gsc.model.tableMapping.Post;
import br.com.gsc.model.tableMapping.Product;
import br.com.gsc.model.tableMapping.Topic;
import br.com.gsc.repository.objRepos.PersonRepository;
import br.com.gsc.repository.objRepos.ProductRepository;
import br.com.gsc.repository.objRepos.TopicRepository;

@Controller
@RequestMapping("/user/topic/**")
public class TopicController {

	@Autowired
	TopicRepository top;
	@Autowired
	PersonRepository per;
	@Autowired
	ProductRepository pro;
	
	@RequestMapping(value="/user/topic/{topicId}", method=RequestMethod.GET)
	public ModelAndView showPage(@PathVariable("topicId") int id){
		ModelAndView model = new ModelAndView("/user/topic");
		Topic topic = top.findTopicByID((long) id);
		model.addObject("topic",topic);	
		Post post = new Post();
		post.setPerson(topic.getPerson());
		post.setTopic(topic);
		model.addObject("post",post);
		System.out.println("Teste");
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="*addtopic")
	public String showForm(Map model){
		System.out.println("Aqui");
		Topic topic = top.findTopicByID((long) 1);
		model.put("topic", topic);
		return "/user/addtopic";		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="*addtopic")
	public String addtopic(@ModelAttribute("topic") Topic topic){
		System.out.println("adding");
		Topic newTopic = new Topic();
		newTopic.setTopicTitle(topic.getTopicTitle());
		newTopic.setTopicContent(topic.getTopicContent());
		newTopic.setTopicType(topic.getTopicType());
		Person p = per.findPersonByID(SecurityContextHolder.getContext().getAuthentication().getName());
		newTopic.setPerson(p);
		Product pro = new Product();
		pro.setName("teste");
		pro.setId(1);
		newTopic.setProduct(pro);
		top.addTopic(newTopic);
		return "redirect:/";
	}

}
