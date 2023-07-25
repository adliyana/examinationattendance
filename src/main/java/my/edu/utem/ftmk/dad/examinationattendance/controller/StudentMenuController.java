package my.edu.utem.ftmk.dad.examinationattendance.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.examinationattendance.model.Student;

/**
 * This class represents Menu Controller for Student
 * 
 * @author Rose Asnarizza
 *
 */

@Controller
public class StudentMenuController {
	
	//The URI for GET student
	private String defaultURI = "http://localhost:8080/examinationattendance/"
			+ "api/students";
	
	/**
	 * This method to display list of student
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/student/list")
	public String getStudent(Model model){
		
		//Get a list of students from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Student[]> response = 
				restTemplate.getForEntity(defaultURI, Student[].class);
		
		//Parse JSON data to array of object
		Student stuDents[] = response.getBody();
		
		//Parse an array to a list object
		List<Student> studentList = Arrays.asList(stuDents);
		
		//Attribute list to model as attribute
		model.addAttribute("stuDents", studentList);
		
		return "students";
	}
}
