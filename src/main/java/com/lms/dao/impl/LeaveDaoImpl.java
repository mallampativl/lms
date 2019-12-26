package com.lms.dao.impl;

import com.lms.dao.LeaveDao;
import com.lms.model.Leaves;

public class LeaveDaoImpl implements LeaveDao {
	
	@Override
	public String saveDetails(Leaves leaves) {
		leaves.setAvailable("");
		leaves.setUsed("");
		return null;
		
	}
	

}
