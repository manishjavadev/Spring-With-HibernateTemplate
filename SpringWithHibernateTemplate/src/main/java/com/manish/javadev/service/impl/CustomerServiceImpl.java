package com.manish.javadev.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.manish.javadev.dao.CustomerDAO;
import com.manish.javadev.service.CustomerService;
import com.manish.javadev.to.CustomerTO;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO custdao;

	public void addCustomer(CustomerTO cust) {
		custdao.addCustomer(cust);
	}

	public void updateCustomer(int custId) {
		custdao.updateCustomer(custId);
	}

	public void deleteCustomer(int custId) {
		custdao.deleteCustomer(custId);
	}

	public List<CustomerTO> getAllCustomer() {
		return custdao.getAllCustomer();
	}

	public CustomerTO getCustomerById(int custId) {
		return custdao.getCustomerById(custId);
	}
}
