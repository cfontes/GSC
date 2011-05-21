package br.com.gsc.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.gsc.form.CadastroUser;
import br.com.gsc.model.tableMapping.User;
import br.com.gsc.repository.objRepos.PersonRepository;

@Controller
@RequestMapping("/cadastro.html")
public class AddUserController {
	
	@Autowired
	private PersonRepository jpa;
	
	@ModelAttribute("CadastroUser")
	public CadastroUser createForm(){;
		return new CadastroUser();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model){
		CadastroUser cadastro = new CadastroUser();
		model.put("CadastroUser", cadastro);
		return "cadastro";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String cadastrarUser(@ModelAttribute("cadastro") CadastroUser cadastro){		
		User user = new User();
		user.setUsername(cadastro.getUserName());
		user.setPassword(cadastro.getPassword());
		user.setEmail(cadastro.getEmail());
		user.setAuthority(cadastro.getAuth());
		jpa.addPerson(user);
		return "redirect:/index.jsp";
	}
	
}
