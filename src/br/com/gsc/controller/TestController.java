package br.com.gsc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 /**
  * Test servlet to see if spring is working fine
  * @author cristiano
  *
  */
@Controller
public class TestController {
 
    @RequestMapping("/hello")
    public ModelAndView helloWorld() {
        String message = "Hello World, Spring 3.0!";
        return new ModelAndView("hello", "message", message);
    }
}