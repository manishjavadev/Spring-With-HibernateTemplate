package com.manish.javadev.service;

import java.util.List;
import com.manish.javadev.to.CustomerTO;

public interface CustomerService {
	
	void addCustomer(CustomerTO cust);

	void updateCustomer(int custId);

	void deleteCustomer(int custId);

	List<CustomerTO> getAllCustomer();

	CustomerTO getCustomerById(int custId);

}
