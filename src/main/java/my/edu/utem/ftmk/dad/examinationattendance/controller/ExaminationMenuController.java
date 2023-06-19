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

import my.edu.utem.ftmk.dad.examinationattendance.model.Examination;

@Controller
public class ExaminationMenuController {
	
	private String defaultURI = "http://localhost:8080/examinationattendance/api/examinations";
	
	@GetMapping("/examination/list")
	public String getStudent(Model model){
		
		//The URI for GET student
		String uri = "http://localhost:8080/examinationattendance/api/examinations";
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Examination[]> response = restTemplate.getForEntity(uri, Examination[].class);
		
		//Parse JSON data to array of object
		Examination exaMinations[] = response.getBody();
		
		//Parse an array to a list object
		List<Examination> examinationList = Arrays.asList(exaMinations);
		
		//Attribute list to model as attribute
		model.addAttribute("exaMinations", examinationList);
		
		return "examinationS";
	}
	
	@RequestMapping("/examination/save")
	public String updateStudent(@ModelAttribute Examination examination) {
		
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Examination> request = new HttpEntity<Examination>(examination);
		
		String examinationResponse = "";
		
		if (examination.getExaminationId() > 0) {
			//This block update an new order type and
			
			//Send request as PUT
			restTemplate.put(defaultURI, request, Examination.class);
		} else {
			//This block add a new student
			
			//send request as POST
			examinationResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		
		System.out.println(examinationResponse);
		
		//Redirect request to display a list of student
		return "redirect:/examination/list";
	}
	
	@GetMapping("/examination/{ExaminationId}")
	public String getExamination(@PathVariable Integer ExaminationId, Model model) {
		
		String pageTitle = "New Examination";
		Examination examination = new Examination();
		
		//This block get student to be updated
		if(ExaminationId > 0) {
			
			//Generate new URI and append studentId to it
			String uri = defaultURI + "/" + ExaminationId;
			
			//Get student from the web service
			RestTemplate restTemplate = new RestTemplate();
			examination = restTemplate.getForObject(uri, Examination.class);
			
			//Give a new title to the page
			pageTitle = "Edit Examination";
		}
		
		//Attach value to pass to front end
		model.addAttribute("examinations", examination);
		model.addAttribute("examination", pageTitle);
		
		return "examinationinfo";
	}
	
	@RequestMapping("/examination/delete/{ExaminationId}")
	public String deleteExamination(@PathVariable int ExaminationId) {
		
		//Generate new URI, similar to the mapping in StudentRESTController
		String uri = defaultURI + "/{ExaminationId}";
		
		//Send a DELETE request and attach the value of StudentId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("ExaminationId", Integer.toString(ExaminationId)));
		
		return "redirect:/examination/list";
	}
}
