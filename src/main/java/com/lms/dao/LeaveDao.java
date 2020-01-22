package com.lms.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lms.model.Leaves;

@Component
public interface LeaveDao {
	
	public int saveDetails(Leaves leaves);
	public List<Leaves> fetchdetails();

}
