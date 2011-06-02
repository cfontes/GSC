package br.com.gsc.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
import br.com.gsc.repository.objRepos.PostRepository;
import br.com.gsc.repository.objRepos.ProductRepository;
import br.com.gsc.repository.objRepos.TopicRepository;

@Controller
@RequestMapping("/user/topic/**")
public class TopicController {

	@Autowired
	PostRepository postRepo;
	@Autowired
	TopicRepository top;
	@Autowired
	PersonRepository per;
	@Autowired
	ProductRepository pro;
	@Autowired
	TopicControllerHelper topHelper;
	
	
	@RequestMapping(value="/user/topic/{topicId}", method=RequestMethod.GET)
	public ModelAndView showPage(@PathVariable("topicId") int id){
		ModelAndView model = new ModelAndView("/user/topic");
		Topic topic = top.findTopicByID((long) id);
		model.addObject("topic",topic);	
		Post post = new Post();
		post.setPerson(topic.getPerson());
		post.setTopic(topic);
		model.addObject("post",post);
		return model;
	}
	
	@RequestMapping(value="/user/topic/{topicId}", method=RequestMethod.PUT)
	public String editTopic(@PathVariable("topicId") int id){
		Topic topic = top.findTopicByID((long) id);
		//TODO
		return "redirect:/user/topic/"+id+".html";
	}
	
	@RequestMapping(value="/user/topic/{topicId}", method=RequestMethod.DELETE)
	public String deleteTopic(@PathVariable("topicId") int id){
		Topic topic = top.findTopicByID((long) id);
		top.removeTopic(topic);
		return "redirect:/";
	}
	
//	@SuppressWarnings("unchecked")
//	@RequestMapping(method = RequestMethod.GET, value="/user/topic/addtopic")
//	public String showForm(Map model){
//		Topic topic = top.findTopicByID((long) 1);
//		model.put("topic", topic);
//		return "/user/addtopic";		
//	}
	
	@RequestMapping(method = RequestMethod.POST, value="/user/topic/addtopic")
	public ModelAndView addtopic(@ModelAttribute("topic") @Valid Topic topic, BindingResult result){
		
		if(result.hasErrors()){
			
			return topHelper.initInternPage();
		}
		Topic newTopic = new Topic();
		newTopic.setTopicTitle(topic.getTopicTitle());
		newTopic.setTopicContent(topic.getTopicContent());
		newTopic.setTopicType(topic.getTopicType());
		newTopic.setCreatedInDate(new Date());
		Person p = per.findPersonByID(SecurityContextHolder.getContext().getAuthentication().getName());
		newTopic.setPerson(p);
		Product pro = new Product();
		pro.setName("teste");
		pro.setId(1);
		newTopic.setProduct(pro);
		top.addTopic(newTopic);
		return new ModelAndView("redirect:/");
	}

}
