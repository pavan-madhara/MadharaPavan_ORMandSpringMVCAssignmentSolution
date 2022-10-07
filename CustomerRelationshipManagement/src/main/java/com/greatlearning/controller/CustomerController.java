package com.greatlearning.controller;

import com.greatlearning.entity.Customer;
import com.greatlearning.service.*;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//dependency injection
	@Autowired
	public CustomerService customerservice;

	@RequestMapping("/list")
	public String listCustomer(Model theModel) throws Exception  {
		
			List<Customer> customer = customerservice.findAll();
		theModel.addAttribute("Customer", customer);
		return "list-Customer";
	}

@RequestMapping("/showFormForAdd")
public String showFormForAdd(Model theModel)
{
Customer theCustomer=new Customer();
theModel.addAttribute("Customer", theCustomer);
return "Customer-forms";
}

@RequestMapping("/showFormForUpdate")
public String showFormForUpdate(@RequestParam("CustomerId")int theId,Model theModel) throws Exception
{
	Customer theCustomer=customerservice.findById(theId);
	theModel.addAttribute("Customer",theCustomer);
	return "Customer-forms";
}
@PostMapping("/save")
public String save(@RequestParam("id")int id,@RequestParam("firstname")String firstname,@RequestParam("lastname")String lastname,@RequestParam("email")String email) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException{
{
	System.out.println(id);
	Customer theCustomer;
    if(id!=0)
    {
    	theCustomer=customerservice.findById(id);
    	theCustomer.setFirstname(firstname);
    	theCustomer.setLastname(lastname);
    	theCustomer.setEmail(email);
    }
    else
    	theCustomer=new Customer(firstname,lastname,email);
    	//save the Customer
    	customerservice.save(theCustomer);
    	//use a redirect to prevent duplicate submissions
    	return "redirect:/customer/list";
    	
}}
    @RequestMapping("/delete")
    public String delete(@RequestParam("CustomerId")int theId) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException 
    {
    	customerservice.deleteById(theId);
    	//redirect to /customer/list
    	return "redirect:/customer/list";
    }
}
