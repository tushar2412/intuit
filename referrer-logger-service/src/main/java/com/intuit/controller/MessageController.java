package com.intuit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intuit.model.ReferrerCount;
import com.intuit.service.ReferrerService;

@Controller
@RequestMapping("/")
public class MessageController {

	@Autowired
	ReferrerService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(ModelMap model) {
		ModelAndView mv = new ModelAndView("welcome");
		
		 List<ReferrerCount> list = service.findTop3Referrars(); 
		 mv.addObject("title","Referrercounts"); 
		 mv.addObject("referrerCounts", list);		 
		return mv;
	}

	@RequestMapping(value = "/referrer", method = RequestMethod.POST)
	public void greeting(@RequestParam(value = "name", required = false) String name, ModelMap model) throws Exception {
		service.save(name);
	}

}