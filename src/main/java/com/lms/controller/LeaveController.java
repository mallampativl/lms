package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lms.model.Leaves;
import com.lms.service.LeaveService;

@Controller
public class LeaveController {
	@Autowired 
	LeaveService leaveService;
	
		@GetMapping("/")
		public String demo(){
			return "index";
		}
		
		@PostMapping(value="save")
		public ModelAndView save(Leaves leaves){
			ModelAndView mv = new ModelAndView();
			leaveService.save(leaves);
			System.out.println(leaves);
			List<Leaves> list = leaveService.fetchDetaild(leaves);
			  mv.addObject("list",list); 
			  System.out.println(mv);
			  mv.setViewName("welcome");
		    return mv;
			
		}
}
