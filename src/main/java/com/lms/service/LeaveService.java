package com.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.LeaveDao;
import com.lms.model.Leaves;

@Service
public class LeaveService {
	
	@Autowired
	LeaveDao leaveDao;
	
	public String save(Leaves leaves){
		leaveDao.saveDetails(leaves);
		return "";
	}

}
