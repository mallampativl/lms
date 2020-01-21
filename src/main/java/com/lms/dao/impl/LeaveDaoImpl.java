package com.lms.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lms.dao.LeaveDao;
import com.lms.model.Leaves;
import com.lms.utill.Constants;

@Repository
public class LeaveDaoImpl implements LeaveDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("dbConfig")
	MessageSource reload;
	
	
	@Override
	public int saveDetails(Leaves leaves) {
		
		Object[] objArray=new Object[]{leaves.getName(),leaves.getFromDate(),leaves.getToDate(),leaves.getNo_of_days()};
		String sql = reload.getMessage(Constants.INSERT_DETAILS,null,null);
		int x=jdbcTemplate.update(sql,objArray);
		System.out.println(jdbcTemplate);
		return x;
		
	}
	
	
	
	

}
