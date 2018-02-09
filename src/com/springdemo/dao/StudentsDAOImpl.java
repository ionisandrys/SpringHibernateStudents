package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;

//import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.entity.Students;

@Repository  
// spring is able to component scan, find this repository and handle the exception translation
// @Repository - only apply for DAO implementations !!!
public class StudentsDAOImpl implements StudentsDAO {

	// for accessing database, DAO needs a hibernate session factory
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Students> getStudents() {
		
		// get current hibernate session. sessionFactory is autowired injected 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query
		Query<Students> theQuery = 
				currentSession.createQuery("from Students order by lastName",
						Students.class);
		
		
		// get list of students from the query by executing it
		List<Students> students = theQuery.getResultList();
		
		
		// return the results
		
		return students;
	}


	@Override
	public void saveStudents(Students theStudents) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer to database
		currentSession.saveOrUpdate(theStudents);
		// if id is empty, then INSERT new Student
					// else UPDATE existing student
		
	}


	@Override
	public Students getStudents(int theId) {
		
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve from database using id
		Students theStudents = currentSession.get(Students.class, theId);
		
		return theStudents;
	}


	@Override
	public void deleteStudents(int theId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key = id
		Query theQuery = currentSession.createQuery("delete from Students where id=:studentsId");
		
		theQuery.setParameter("studentsId", theId);
		
		theQuery.executeUpdate();
	}


	@Override
    public List<Students> searchStudents(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name, if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Students where lower(firstName) like :theName or lower(lastName) like :theName", Students.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Students", Students.class);            
        }
        
        // execute query and get result list
        List<Students> students = theQuery.getResultList();
                
        // return the results        
        return students;
        
        
        
        /*
         * In this method, we need to check "theSearchName", this is the user input. 
         * We need to make sure it is not empty. If it is not empty then we will use it in the search query.  
         * If it is empty, then we'll just ignore it and simply return all of the students.

           For the condition when "theSearchName" is not empty, then we use it to compare against the first name or last name. 
           We also make use of the "like" clause and the "%" wildcard characters. 
           This will allow us to search for substrings. For example, if we have students with last name of "Sheldon", "Shelly" ... 
       then we can search for "Sh" and it will match on those names.  

            Also, the query uses the lower case version of the values to make a case insensitive search. 
            If we'd like to make a case sensitive search, we simply remove the lower references.
         */
        
    }

}
