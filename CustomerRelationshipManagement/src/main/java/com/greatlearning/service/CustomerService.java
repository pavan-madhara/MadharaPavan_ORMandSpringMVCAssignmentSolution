package com.greatlearning.service;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.greatlearning.entity.Customer;

public interface CustomerService {
	
	
	public List<Customer> findAll() throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
	
	public Customer findById(int theId) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
	
	public void save(Customer theCustomer) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
	 
	public void deleteById(int theId) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
	
}
