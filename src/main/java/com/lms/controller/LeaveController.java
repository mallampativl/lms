package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
		public String save(Leaves leaves){
			leaveService.save(leaves);
			System.out.println(leaves);
			return "welcome";
			
		}
}
