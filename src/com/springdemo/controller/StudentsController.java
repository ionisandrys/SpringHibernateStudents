package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.dao.StudentsDAO;
import com.springdemo.entity.Students;
import com.springdemo.service.StudentsService;

@Controller  // for Spring MVC Controller
@RequestMapping("/students")
public class StudentsController {
	
	/*
	// injecting the DAO into this controller
	
	@Autowired // Spring will scan for a component that implements StudentsDAO interface
	private StudentsDAO studentsDAO;
	*/
	
	// inject students service
	@Autowired
	private StudentsService studentsService;
	
	@GetMapping("/list") // only want to handle GET requests
	public String listStudents(Model theModel){
		
		// using the service now 
		// get students from service
		List<Students> theStudents = studentsService.getStudents();
		
		// add the students to the model
		theModel.addAttribute("students", theStudents);
		
		
		return "list-students";
	}

	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		// create model attribute to bind form data
		Students theStudents = new Students();
		theModel.addAttribute("students", theStudents);
		
		return "students-form";
	}

	
		@PostMapping("/saveStudents")
		public String saveStudents(@ModelAttribute("students") Students theStudents){
			
			// save the student using our service
			studentsService.saveStudents(theStudents);
			
			
			return "redirect:/students/list";
		}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
								Model theModel){
		
		// get student from service
		Students theStudents = studentsService.getStudents(theId);
		
		// set student as a model attribute to pre populate the form
		theModel.addAttribute("students", theStudents);
		
		// send over to our form
		return "students-form";
	}
	
	@GetMapping("/delete")
	public String deleteStudents(@RequestParam("studentsId") int theId){
		
		// delete student
			studentsService.deleteStudents(theId);
			
		return "redirect:/students/list";
	}
	
	@PostMapping("/search")
    public String searchStudents(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Students> theStudents = studentsService.searchStudents(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("students", theStudents);

        return "list-students";     
    //    return "redirect:/students/list";
    }
	
	
	
	
	
	
}
