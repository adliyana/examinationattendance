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

import my.edu.utem.ftmk.dad.examinationattendance.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.examinationattendance.model.Student;

/**
 * This class represents Menu Controller for Examination Attendance
 * 
 * @author Adib Adliyana
 * @author Rose Asnarizza
 * @author Syafiqah
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
		
		//Get a list order types from the web service
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
	 * 
	 * @param examination_attendance
	 * @return
	 */
	@RequestMapping("/examinationattend/save")
	public String updateExaminationAttendance(
			@ModelAttribute ExaminationAttendance examinationattendance) {
		
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<ExaminationAttendance> request = 
				new HttpEntity<ExaminationAttendance>(examinationattendance);
		
		String examinationAttendanceResponse = "";
		
		if (examinationattendance.getExaminationAttendanceId() > 0) {
			//This block update an new order type and
			
			//Send request as PUT
			restTemplate.put(defaultURI, request, ExaminationAttendance.class);
		} else {
			//This block add a new attendance
			
			//send request as POST
			examinationAttendanceResponse = restTemplate.postForObject
					(defaultURI, request, String.class);
		}
		
		System.out.println(examinationAttendanceResponse);
		
		//Redirect request to display a list of attendance
		return "redirect:/examinationattend/list";
	}
	
	@GetMapping("/examinationattend/{examinationAttendanceId}")
	public String getExaminationAttendance
	(@PathVariable Integer examinationAttendanceId, Model model) {
		
		String pageTitle = "New Attendance";
		ExaminationAttendance examinationattendance = 
				new ExaminationAttendance();
		
		//This block get examinationattendance to be updated
		if(examinationAttendanceId > 0) {
			
			//Generate new URI and append examinationAttendanceId to it
			String uri = defaultURI + "/" + examinationAttendanceId;
			
			//Get examinationattendance from the web service
			RestTemplate restTemplate = new RestTemplate();
			examinationattendance = restTemplate.getForObject
					(uri, ExaminationAttendance.class);
			
			//Give a new title to the page
			pageTitle = "Edit Attendance";
		}
		
//		RestTemplate restTemplateStudent = new RestTemplate();
//		ResponseEntity<Student[]> responseStudent = 
//				restTemplateStudent.getForEntity("http://localhost:8080/examinationattendance/api/students", Student[].class);
//		
//		Student studentArray[] = responseStudent.getBody();	
//		
//		// Parse an array to a list object
//		List<Student> studentList = Arrays.asList(studentArray);
		
		//Attach value to pass to front end
		model.addAttribute("examinationattends", examinationattendance);
		model.addAttribute("examinationattend", pageTitle);
		//model.addAttribute("student",studentList);
		
		return "examinationattendanceinfo";
	}
	
	@RequestMapping("/examinationattend/delete/{examinationAttendanceId}")
	public String deleteExaminationAttendance
	(@PathVariable int examinationAttendanceId) {
		
		//Generate new URI, similar to the mapping in ExaminationAttendance
		String uri = defaultURI + "/{examinationAttendanceId}";
		
		//Send a DELETE request and attach the value of ExaminationAttendanceId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("examinationAttendanceId", 
				Integer.toString(examinationAttendanceId)));
		
		return "redirect:/examinationattend/list";
	}
}
