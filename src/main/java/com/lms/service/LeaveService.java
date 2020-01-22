package com.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lms.dao.LeaveDao;
import com.lms.model.Leaves;

@Service
public class LeaveService {
	
	@Autowired
	JavaMailSender emailConfig;
	@Autowired
	SimpleMailMessage sms;
	
	@Autowired
	LeaveDao leaveDao;
	
	public String save(Leaves leaves){
	 int x=leaveDao.saveDetails(leaves);
		 if(x>=2){
			 emailConfig.send(sms);
		 }
		 else{
			 
		 }
		 return "";
	}
	public List<Leaves> fetchDetaild(Leaves leaves){
		List<Leaves> list = leaveDao.fetchdetails();
		return list;
		
	}

}
