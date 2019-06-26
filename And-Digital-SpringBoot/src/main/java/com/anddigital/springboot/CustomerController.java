
package com.anddigital.springboot;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anddigital.springboot.model.Customer;
import com.anddigital.springboot.model.Phone;
import com.anddigital.springboot.service.CustomerService;

@RestController
class CustomerController {
    @Autowired
    private CustomerService customerService;
    
    //Retrieving all the phone numbers of all the customers
    
    @RequestMapping("/customers")
    public List<Customer> retrieveAllCustomers() {
        return customerService.retrieveAllCustomers();
    }
    
    //Retrieving all the phone numbers available
    @RequestMapping("/customers/phones")
    public List<Phone> retrieveAllCustomersPhones() {
        
    	List<Phone> phoneList = new ArrayList<>();
    	List<Customer> customers= customerService.retrieveAllCustomers();
    	for(Customer cust :customers) {
    		phoneList.addAll(cust.getPhones());
    	}
    	return phoneList;
    }
    
    
    //Retrieving all the phone numbers of a single customer   
    @GetMapping("/customers/{customerId}/phones")
    public List<Phone> retrievePhones(@PathVariable String customerId) {
        return customerService.retrievePhones(customerId);
    }
    
    
    //Adding a new phone to a particular customer
    
    @PostMapping("/customers/{customerId}/phones")
	public ResponseEntity<Void> addPhoneToCustomer(
			@PathVariable String customerId, @RequestBody Phone newPhone) {
		   
    	   Customer customer= customerService.addPhoneToCustomer(customerId, newPhone);
		   URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
					"/{id}").buildAndExpand(customer.getId()).toUri();

			// Status
			return ResponseEntity.created(location).build();
			
			
    }
}
