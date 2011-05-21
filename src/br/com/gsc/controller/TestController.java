package br.com.gsc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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