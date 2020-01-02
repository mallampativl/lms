package com.lms.dao;

import org.springframework.stereotype.Component;

import com.lms.model.Leaves;

@Component
public interface LeaveDao {
	
	public String saveDetails(Leaves leaves);

}
