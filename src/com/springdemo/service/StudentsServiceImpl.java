package com.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.StudentsDAO;
import com.springdemo.entity.Students;

@Service
public class StudentsServiceImpl implements StudentsService {

	// need to inject students dao
	
	@Autowired
	private StudentsDAO studentsDAO;
	
	
	@Override
	@Transactional // now define transactions at Service layer
	// remove @Transactional from StudentsDAOImpl.java because now the service layer will manage the transaction, not the DAO
	public List<Students> getStudents() {
		
		return studentsDAO.getStudents();
	}


	@Override
	@Transactional
	public void saveStudents(Students theStudents) {
		
		studentsDAO.saveStudents(theStudents);
	}


	@Override
	@Transactional
	public Students getStudents(int theId) {
		
		return studentsDAO.getStudents(theId);
	}


	@Override
	@Transactional
	public void deleteStudents(int theId) {
		
		studentsDAO.deleteStudents(theId);
		
	}


	@Override
	@Transactional
	public List<Students> searchStudents(String theSearchName) {
		
		 return studentsDAO.searchStudents(theSearchName);
	}

}
