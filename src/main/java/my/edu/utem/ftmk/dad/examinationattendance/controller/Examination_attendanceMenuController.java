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

import my.edu.utem.ftmk.dad.examinationattendance.model.Examination_attendance;

@Controller
public class Examination_attendanceMenuController {
	
	private String defaultURI = "http://localhost:8080/examinationattendance/api/examinationattends";
	
	@GetMapping("/examinationattend/list")
	public String getExamination_attendance(Model model){
		
		//The URI for GET attendance
		String uri = "http://localhost:8080/examinationattendance/api/examinationattends";
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Examination_attendance[]> response = restTemplate.getForEntity(uri, Examination_attendance[].class);
		
		//Parse JSON data to array of object
		Examination_attendance examAttend[] = response.getBody();
		
		//Parse an array to a list object
		List<Examination_attendance> examination_attendanceList = Arrays.asList(examAttend);
		
		//Attribute list to model as attribute
		model.addAttribute("examAttend", examination_attendanceList);
		
		return "examinationattendS";
	}
	
	@RequestMapping("/examinationattend/save")
	public String updateExamination_attendance(@ModelAttribute Examination_attendance examination_attendance) {
		
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Examination_attendance> request = new HttpEntity<Examination_attendance>(examination_attendance);
		
		String examination_attendanceResponse = "";
		
		if (examination_attendance.getExaminationAttendanceId() > 0) {
			//This block update an new order type and
			
			//Send request as PUT
			restTemplate.put(defaultURI, request, Examination_attendance.class);
		} else {
			//This block add a new attendance
			
			//send request as POST
			examination_attendanceResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		
		System.out.println(examination_attendanceResponse);
		
		//Redirect request to display a list of attendance
		return "redirect:/examinationattend/list";
	}
	
	@GetMapping("/examinationattend/{ExaminationAttendanceId}")
	public String getExamination_attendance(@PathVariable Integer ExaminationAttendanceId, Model model) {
		
		String pageTitle = "New Attendance";
		Examination_attendance examination_attendance = new Examination_attendance();
		
		//This block get examination_attendance to be updated
		if(ExaminationAttendanceId > 0) {
			
			//Generate new URI and append examinationAttendanceId to it
			String uri = defaultURI + "/" + ExaminationAttendanceId;
			
			//Get examination_attendance from the web service
			RestTemplate restTemplate = new RestTemplate();
			examination_attendance = restTemplate.getForObject(uri, Examination_attendance.class);
			
			//Give a new title to the page
			pageTitle = "Edit Attendance";
		}
		
		//Attach value to pass to front end
		model.addAttribute("examinationattends", examination_attendance);
		model.addAttribute("examinationattend", pageTitle);
		
		return "examinationattendanceinfo";
	}
	
	@RequestMapping("/examinationattend/delete/{ExaminationAttendanceId}")
	public String deleteExamination_attendance(@PathVariable int ExaminationAttendanceId) {
		
		//Generate new URI, similar to the mapping in Examination_attendanceRESTController
		String uri = defaultURI + "/{ExaminationAttendanceId}";
		
		//Send a DELETE request and attach the value of ExaminationAttendanceId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("ExaminationAttendanceId", Integer.toString(ExaminationAttendanceId)));
		
		return "redirect:/examinationattend/list";
	}
}
