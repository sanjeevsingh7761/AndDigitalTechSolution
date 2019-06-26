package com.anddigital.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.anddigital.springboot.model.Customer;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

	@Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void retrieveAllCustomers_test() throws RestClientException, MalformedURLException {
    	
    	ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(
				"http://localhost:8080/customers", Customer.class);
    	Customer response = responseEntity.getBody();
        
    	assertEquals(3, response.getPhones().size());
    	assertEquals("7438211791", response.getPhones().get(0).getPhoneNumber());

    }
	
    @Test
    public void retrievePhonesForASingleCustomer_test() throws RestClientException, MalformedURLException {
    	
    	Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("customerId", "Customer1");
    	
    	ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(
				"http://localhost:8080/customers/{customerId}/phones", Customer.class, uriVariables);
    	Customer response = responseEntity.getBody();
        
    	assertEquals(3, response.getPhones().size());
    	
    	assertEquals("7438211791", response.getPhones().get(0).getPhoneNumber());
    	assertEquals("68686867876887897", response.getPhones().get(0).getSimNumber());
    	
    	assertEquals("7438211789", response.getPhones().get(0).getPhoneNumber());
    	assertEquals("68686867876887777", response.getPhones().get(0).getSimNumber());

    }
	
}
