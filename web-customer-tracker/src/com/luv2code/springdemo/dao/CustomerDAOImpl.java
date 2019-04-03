package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//@Transactional //ta adnotacja odpowiedzialna jest za automatyczne rozpoczyanie i koñczenie sesji pomiêdzy aplikacj¹ a DB
	// usuwamy w przypadku gdy tworzymy us³ugê (servce) odpowiedzialn¹ za implementacjê DAO (w naszym projekcie CustomerServiceImpl)
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query
		// sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get the result
		List<Customer> customers = theQuery.getResultList();
		
		//return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomers(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrive/read customer from the db using primary key		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		//return the customer
		return theCustomer;
	}

	@Override
	public void deleteCustomers(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
    public List<Customer> searchCustomers(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Customer> theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
        
    }

}
