package com.springdemo.service;

import java.util.List;

import com.springdemo.entity.Students;

public interface StudentsService {

		public List<Students> getStudents();

		public void saveStudents(Students theStudents);

		public Students getStudents(int theId);

		public void deleteStudents(int theId);

		public List<Students> searchStudents(String theSearchName);
		
}
