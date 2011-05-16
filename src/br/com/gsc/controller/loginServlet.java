package br.com.gsc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gsc.form.LoginForm;
import br.com.gsc.repository.objRepos.PersonRepository;

@Controller
@RequestMapping("/loginform.html")
public class loginServlet {

	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping(method = RequestMethod.GET)
    public String showForm(Map model) {
        LoginForm loginForm = new LoginForm();
        model.put("loginForm", loginForm);
        return "loginform";
    }
	
}
