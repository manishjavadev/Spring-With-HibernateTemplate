package com.manish.javadev.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.manish.javadev.dao.CustomerDAO;
import com.manish.javadev.model.Customer;
import com.manish.javadev.to.CustomerTO;

@SuppressWarnings("unchecked")
public class CustomerDaoImpl implements CustomerDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	//Add Customer
	public void addCustomer(CustomerTO cto) {
		Customer custModel = new Customer(cto.getFirstName(),
				cto.getLastName(), cto.getAge(), cto.getCity());
		hibernateTemplate.save(custModel);
		System.out.println("Hibernate Template=  " + hibernateTemplate);

	}

	//Update Customer By Id
	public void updateCustomer(int custId) {
		Customer cust = hibernateTemplate.load(Customer.class, custId);
		cust.setFirstName("Updated FirstName");
		hibernateTemplate.update(cust);
	}

	//Delete Customer By Id
	public void deleteCustomer(int custId) {
		Customer cust = hibernateTemplate.load(Customer.class, custId);
		hibernateTemplate.delete(cust);
	}

	//Get All Customer
	public List<CustomerTO> getAllCustomer() {
		List<CustomerTO> custTo = new ArrayList<CustomerTO>();
		String sql = "from Customer c";
		List<Customer> list = hibernateTemplate.find(sql);
		for (Customer cust : list) {
			CustomerTO custto = new CustomerTO(cust.getCustId(),
					cust.getFirstName(), cust.getLastName(), cust.getAge(),
					cust.getCity());
			custTo.add(custto);
		}
		return custTo;
	}

	//Get Customer By Id
	public CustomerTO getCustomerById(int custId) {
		Customer cust = hibernateTemplate.load(Customer.class, custId);
		CustomerTO custTo = new CustomerTO(cust.getCustId(),
				cust.getFirstName(), cust.getLastName(), cust.getAge(),
				cust.getCity());
		return custTo;
	}
}
