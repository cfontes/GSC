package br.com.gsc.controller;

import java.util.Date;

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
import br.com.gsc.model.tableMapping.Topic;
import br.com.gsc.repository.objRepos.PersonRepository;
import br.com.gsc.repository.objRepos.PostRepository;
import br.com.gsc.repository.objRepos.TopicRepository;

@Controller
@RequestMapping("**/post/**")
public class PostController {
	
	@Autowired
	PostRepository postRepo;
	@Autowired
	PersonRepository personRepo;
	@Autowired
	TopicRepository topicRepo;
	
	@RequestMapping(value = "**/post/{postId}", method=RequestMethod.GET)
	public ModelAndView showPosts(@PathVariable("postId") long id){
		ModelAndView model = new ModelAndView("/user/post");
		return null;
	}
	
	@RequestMapping(value = "/topic/{topicId}/post/addpost", method=RequestMethod.POST)
	public String addPost(@PathVariable(value="topicId") long id, @ModelAttribute("post") Post post){
		System.out.println("10.................................................................");
		Person person = personRepo.findPersonByID(SecurityContextHolder.getContext().getAuthentication().getName());
		post.setPerson(person);
		Topic topic = topicRepo.findTopicByID(id);
		post.setTopic(topic);
		post.setCreatedIn(new Date());
		postRepo.addPost(post);
		return "redirect:/topic/"+id+".html";
	}
	
	@RequestMapping(value = "/topic/{topicId}/post/{postId}", method=RequestMethod.DELETE)
	public String deletePost(@PathVariable(value="topicId") long id, @PathVariable(value="postId") long postId){
		postRepo.removePost(postRepo.findTPostByID(postId));
		return "redirect:/topic/"+id+".html";
	}

}
