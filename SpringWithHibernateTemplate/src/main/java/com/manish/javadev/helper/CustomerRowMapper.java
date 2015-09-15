package com.manish.javadev.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.manish.javadev.to.CustomerTO;

public class CustomerRowMapper implements RowMapper<CustomerTO> {

	public CustomerTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		CustomerTO customerTO = new CustomerTO();
		customerTO.setCustId(rowNum);
		customerTO.setFirstName(rs.getString("firstName"));
		customerTO.setLastName(rs.getString("lastName"));
		customerTO.setAge(rs.getInt("age"));
		customerTO.setCity(rs.getString("city"));
		return customerTO;
	}
}
