package br.com.gsc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AjaxController {

	@RequestMapping(value = "/time.html", method = RequestMethod.GET)
	public @ResponseBody String getTime(@RequestParam String name) {
	   String result = "Time for " + name + " is " + new Date().toString();
	   return result;
	}
	
}
