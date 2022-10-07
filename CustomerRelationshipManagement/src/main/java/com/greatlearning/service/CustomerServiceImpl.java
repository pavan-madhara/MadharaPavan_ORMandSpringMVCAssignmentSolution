package com.greatlearning.service;
import com.greatlearning.entity.Customer;
import com.greatlearning.controller.HomeController;
import com.greatlearning.controller.CustomerController;
import java.util.List;
import java.lang.*;


//import javax.transaction.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionFactory;
	private Session session;
	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		try {
		session=(Session) sessionFactory.getCurrentSession();
		}
		catch(HibernateException e)
		{
		
		session=(Session)sessionFactory.openSession();
		
	} }
	@Transactional
	public List<Customer> findAll()  {
		Transaction tx=(Transaction) session.beginTransaction();
		List<Customer> customer=session.createQuery("from Customer").list();
	tx.commit();
		return customer;
	
	}
	
	@Override
	public void save(Customer theCustomer)  {
		// TODO Auto-generated method stub
		Transaction tx=(Transaction) session.beginTransaction();
		session.saveOrUpdate(theCustomer);
	tx.commit();
			}
	@Override
	public Customer findById(int theId)  
	{
		Customer customer=new Customer();
		Transaction tx=(Transaction) session.beginTransaction();
		customer=session.get(Customer.class,theId);
		tx.commit();
		return customer;
	}
	

	@Override
	public void deleteById(int Id)  {
		// TODO Auto-generated method stub
		Transaction tx=(Transaction) session.beginTransaction();
		Customer customer=session.get(Customer.class,Id);
		session.delete(customer);
		tx.commit();
	}


}
