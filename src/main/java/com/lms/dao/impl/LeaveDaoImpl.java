package com.lms.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
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
	ReloadableResourceBundleMessageSource reload;
	
	final String INSERT_QUERY = "insert into employee (name) values (?)";
	
	@Override
	public String saveDetails(Leaves leaves) {
		/*String sql = "insert into leave_management_db " +
				"(name) VALUES (?)";
		jdbcTemplate.update(sql, new Object[] { leaves.getName()
				 });*/
		Object[] objArray=new Object[]{leaves.getName()};
		String sql = reload.getMessage(INSERT_QUERY, objArray,null);
		jdbcTemplate.update(sql);
		System.out.println(jdbcTemplate);
		return "hi";
		
	}
	
	
	

}
