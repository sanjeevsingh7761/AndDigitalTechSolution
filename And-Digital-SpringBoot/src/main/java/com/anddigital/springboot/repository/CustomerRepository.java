package com.anddigital.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.anddigital.springboot.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
