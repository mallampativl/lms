package com.lms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	public List<Leaves> fetchdetails() {
		String sql= reload.getMessage(Constants.SELECT,null,null);
		//String sql = "select name,from_date,to_date from leave_management";
		List<Leaves> dataFromDB = jdbcTemplate.query(sql,new RowMapper<Leaves>(){
			@Override
			public Leaves mapRow(ResultSet rs, int rowNum)throws SQLException{
				Leaves leave = new Leaves();
				leave.setName(rs.getString("name"));
				leave.setFromDate(rs.getString("from_date"));
				leave.setToDate(rs.getString("to_date"));
				leave.setNo_of_days(rs.getString("no_of_days"));
				System.out.println(leave +": getting from db");
				return leave;
			}
			
		});
		System.out.println(dataFromDB);
		return dataFromDB;
	}
	
	

}
