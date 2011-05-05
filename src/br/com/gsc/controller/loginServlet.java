package br.com.gsc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gsc.form.LoginForm;
import br.com.gsc.repository.objRepos.PersonRepository;

@Controller
@RequestMapping("/loginform.html")
public class loginServlet {

	PersonRepository personRepository;
	
	@RequestMapping(method = RequestMethod.GET)
    public String showForm(Map model) {
            LoginForm loginForm = new LoginForm();
            model.put("loginForm", loginForm);
            return "loginform";
    }
	
    @RequestMapping(method = RequestMethod.POST)
    public String processForm(LoginForm loginForm, BindingResult result,Map model) {
            String userName = "UserName";
            String password = "password";
            if (result.hasErrors()) {
                    return "loginform";
            }
            loginForm = (LoginForm) model.get("loginForm");
            if (!loginForm.getUserName().equals(userName)
                            || !loginForm.getPassword().equals(password)) {
                    return "loginform";
            }
            model.put("loginForm", loginForm);
            return "loginsuccess";
    }
	
}
