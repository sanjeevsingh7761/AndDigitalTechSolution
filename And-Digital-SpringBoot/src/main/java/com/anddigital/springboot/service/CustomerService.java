package com.anddigital.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anddigital.springboot.model.Customer;
import com.anddigital.springboot.model.Phone;
import com.anddigital.springboot.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	private static List<Customer> customers = new ArrayList<Customer>();
	
	static {
		
		Customer cust1 = new Customer("Customer1",
				"Rob", Arrays.asList(
						new Phone("fistPhoneNumber","7438211791", "68686867876887897"),
						new Phone("secondPhoneNumber","7438211789", "68686867876887777"),
						new Phone("thirdPhoneNumber","7438211745", "6868686787688789809")
						));
		
		Customer cust2 = new Customer("Customer2",
				"William", Arrays.asList(
						new Phone("fistPhoneNumber","7438211200", "686868678768877679"),
						new Phone("secondPhoneNumber","7438211711", "68686867876888798"),
						new Phone("thirdPhoneNumber","74382117567", "6868686787688789784")
						));
		Customer cust3 = new Customer("Customer3",
				"Ryan", Arrays.asList(
						new Phone("fistPhoneNumber","7438211200", "686868678768877679"),
						new Phone("secondPhoneNumber","7438211711", "68686867876888798"),
						new Phone("thirdPhoneNumber","74382117567", "6868686787688789784")
						));
		
		customers.add(cust1);
		customers.add(cust2);
		customers.add(cust3);
	}

	public List<Customer> retrieveAllCustomers() {
		return customers;
		
		//with imaginary Data base
		
		/*List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().
		forEach(customers::add);
		return customers;*/
	}

	public Customer retrieveCustomer(String customerId) {
		
		return customers.stream().filter( t -> t.getId().equals(customerId)).findFirst().get();
		
		//with imaginary Data base
		//return customerRepository.findOne(customerId);
	}


	public Customer addPhoneToCustomer(String customerId, Phone phone) {
		Customer customer = retrieveCustomer(customerId);

		if (customer == null) {
			return null;
		}
		customer.setId(customerId);
		customer.getPhones().add(phone);
		return customer;
		
		//Adding new phone to customer with imaginary data base
		//customerRepository.save(customer);
	}
	
	public List<Phone> retrievePhones(String customerId) {
		Customer customer = retrieveCustomer(customerId);

		if (customer == null) {
			return null;
		}
		return customer.getPhones();
	}
}
