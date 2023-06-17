package my.edu.utem.ftmk.dad.examinationattendance.controller;

import java.util.Arrays;
import java.util.List;
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

@Controller
public class StudentMenuController {
	
	private String defaultURI = "http://localhost:8080/examinationattendance/api/students";
	
	@GetMapping("/student/list")
	public String getStudent(Model model){
		
		//The URI for GET student
		String uri = "http://localhost:8080/examinationattendance/api/students";
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Student[]> response = restTemplate.getForEntity(uri, Student[].class);
		
		//Parse JSON data to array of object
		Student stuDents[] = response.getBody();
		
		//Parse an array to a list object
		List<Student> studentList = Arrays.asList(stuDents);
		
		//Attribute list to model as attribute
		model.addAttribute("stuDents", studentList);
		
		return "studentS";
	}
	
	@RequestMapping("/student/save")
	public String updateStudent(@ModelAttribute Student student) {
		
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Student> request = new HttpEntity<Student>(student);
		
		String studentResponse = "";
		
		if (student.getStudentId() > 0) {
			//This block update an new order type and
			
			//Send request as PUT
			restTemplate.put(defaultURI, request, Student.class);
		} else {
			//This block add a new student
			
			//send request as POST
			studentResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		
		System.out.println(studentResponse);
		
		//Redirect request to display a list of student
		return "redirect:/student/list";
	}
	
	@GetMapping("/student/{StudentId}")
	public String getStudent(@PathVariable Integer StudentId, Model model) {
		
		String pageTitle = "New Student";
		Student student = new Student();
		
		//This block get student to be updated
		if(StudentId > 0) {
			
			//Generate new URI and append studentId to it
			String uri = defaultURI + "/" + StudentId;
			
			//Get student from the web service
			RestTemplate restTemplate = new RestTemplate();
			student = restTemplate.getForObject(uri, Student.class);
			
			//Give a new title to the page
			pageTitle = "Edit Student";
		}
		
		//Attach value to pass to front end
		model.addAttribute("students", student);
		model.addAttribute("student", pageTitle);
		
		return "studentinfo";
	}
	
//	@RequestMapping("/student/delete/{StudentId}")
//	public String deleteStudent(@PathVariable int StudentId) {
//		
//		//Generate new URI, similar to the mapping in StudentRESTController
//		String uri = defaultURI + "{StudentId}";
//		
//		//Send a DELETE request and attach the value of StudentId into URI
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.delete(uri, Map.of("StudentId", Integer.toString(StudentId)));
//		
//		return "redirect:/student/list";
//	}
}
