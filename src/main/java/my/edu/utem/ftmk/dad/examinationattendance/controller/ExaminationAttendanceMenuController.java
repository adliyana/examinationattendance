package my.edu.utem.ftmk.dad.examinationattendance.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.examinationattendance.model.Examination;
import my.edu.utem.ftmk.dad.examinationattendance.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.examinationattendance.model.Student;
import my.edu.utem.ftmk.dad.examinationattendance.model.Subject;

/**
 * This class represents Menu Controller for Examination Attendance
 * 
 * @author Rose Asnarizza
 *
 */
@Controller
public class ExaminationAttendanceMenuController {
	
	//The URI for GET attendance
	private String defaultURI = 
			"http://localhost:8080/examinationattendance/api/"
			+ "examinationattends";
	
	/**
	 * This method to display list of examination attendance
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/examinationattend/list")
	public String getExaminationAttendance(Model model){
		
		//Get a list examination attendance from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ExaminationAttendance[]> response = 
				restTemplate.getForEntity(defaultURI, 
						ExaminationAttendance[].class);
		
		//Parse JSON data to array of object
		ExaminationAttendance examAttend[] = response.getBody();
		
		//Parse an array to a list object
		List<ExaminationAttendance> examinationAttendanceList = 
				Arrays.asList(examAttend);
		
		//Attribute list to model as attribute
		model.addAttribute("examAttend", examinationAttendanceList);
		
		return "examinationattends";
	}
	
	/**
	 * This method will update or add new attendance
	 * 
	 * @param examinationattendance
	 * @return
	 */
	@RequestMapping("/examinationattend/save")
	public String updateExaminationAttendance
	(@ModelAttribute ExaminationAttendance examinationattendance) {
		
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<ExaminationAttendance> request = 
				new HttpEntity<ExaminationAttendance>(examinationattendance);
		
		String examinationAttendanceResponse = "";
		
		// This block get examination attendance to be updated
		if (examinationattendance.getExaminationAttendanceId() > 0) {
			
			//Send request as PUT
			restTemplate.put(defaultURI, request, ExaminationAttendance.class);
		} else {
			
			//send request as POST
			examinationAttendanceResponse = 
				restTemplate.postForObject(defaultURI, request, String.class);
		}
		
		System.out.println(examinationAttendanceResponse);
		
		//Redirect request to display a list of attendance
		return "redirect:/examinationattend/list";
	}
	
	/**
	 * This method gets a report of the attendance by examinationId
	 * 
	 * @param examinationId
	 * @return
	 */
	@GetMapping("/report/{examinationId}")
	public String getExamination 
	(@PathVariable Integer examinationId, Model model) {
		
		String pageTitle = "Report Attendance";
		
		// REST template for students who attend the examination
		RestTemplate restTemplateStudent = new RestTemplate();
		ResponseEntity<ExaminationAttendance[]> responseStudent =
				restTemplateStudent.getForEntity
				("http://localhost:8080/examinationattendance/api"
						+ "/examinationattends/report/" 
						+ examinationId,ExaminationAttendance[].class);
				
		ExaminationAttendance studentAttendance[] = responseStudent.getBody();
		List<ExaminationAttendance> studentAttendances = 
				Arrays.asList(studentAttendance);
		
		// REST template for students who is absent for the examination
		RestTemplate restTemplateStudentAbsent = new RestTemplate();
		ResponseEntity<Student[]> responseStudentAbsent = 
				restTemplateStudentAbsent.getForEntity
				("http://localhost:8080/examinationattendance/api"
						+ "/examinationattends/report/absent/" 
						+ examinationId,Student[].class);
		
		Student studentAbsent[] = responseStudentAbsent.getBody();
		List<Student> studentAbsents = Arrays.asList(studentAbsent);
		
		// Attach value to pass to front end
		model.addAttribute("studentAttendance", studentAttendances);
		model.addAttribute("studentAbsent", studentAbsents);
		model.addAttribute("pageTitle",pageTitle);
		
		return "report";
	}
	
	/**
	 * This method gets an examination attendance
	 * 
	 * @param examinationId
	 * @return
	 */
	@GetMapping("/examinationattend/{examinationAttendanceId}")
	public String getExaminationAttendance
	(@PathVariable Integer examinationAttendanceId, Model model,
			@RequestParam(name = "matricNo",required =false) String matricNo) {
		
		String pageTitle = "New Attendance";
		ExaminationAttendance examinationattendance = 
				new ExaminationAttendance();
		
		Student currentStudent = new Student();
		
		// This block add examination attendance based on  matric number
		if(!Strings.isBlank(matricNo)) {
			
			RestTemplate studentREST = new RestTemplate();
			currentStudent = studentREST.getForObject
					("http://localhost:8080/examinationattendance/api/"
							+ "students/matric/"+matricNo, Student.class);
			examinationattendance.setStudent(currentStudent);
		}
		
		RestTemplate restTemplateExamination = new RestTemplate();
		ResponseEntity<Examination[]> responseExamination = 
				restTemplateExamination.getForEntity("http://localhost:8080/"
					+ "examinationattendance/api/examinations", 
						Examination[].class);
		
		Examination examinationArray[] = responseExamination.getBody();	
		
		// Parse an array to a list object
		List<Examination> examinationList = Arrays.asList(examinationArray);
		
		//Attach value to pass to front end
		model.addAttribute("examinationattends", examinationattendance);
		model.addAttribute("examinationattend", pageTitle);
		model.addAttribute("examinations",examinationList);
		model.addAttribute("student", currentStudent);
		
		return "examinationattendanceinfo";
	}
}
