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

import my.edu.utem.ftmk.dad.examinationattendance.model.Subject;

@Controller
public class SubjectMenuController {
	
	private String defaultURI = "http://localhost:8080/examinationattendance/api/subjects";
	
	@GetMapping("/subject/list")
	public String getSubject(Model model){
		
		//The URI for GET subject
		String uri = "http://localhost:8080/examinationattendance/api/subjects";
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Subject[]> response = restTemplate.getForEntity(uri, Subject[].class);
		
		//Parse JSON data to array of object
		Subject subJects[] = response.getBody();
		
		//Parse an array to a list object
		List<Subject> subjectList = Arrays.asList(subJects);
		
		//Attribute list to model as attribute
		model.addAttribute("subJects", subjectList);
		
		return "subjectS";
	}
	
	@RequestMapping("/subject/save")
	public String updateSubject(@ModelAttribute Subject subject) {
		
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Subject> request = new HttpEntity<Subject>(subject);
		
		String subjectResponse = "";
		
		if (subject.getSubjectId() > 0) {
			//This block update an new subject and
			
			//Send request as PUT
			restTemplate.put(defaultURI, request, Subject.class);
		} else {
			//This block add a new subject
			
			//send request as POST
			subjectResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		
		System.out.println(subjectResponse);
		
		//Redirect request to display a list of student
		return "redirect:/subject/list";
	}
	
	@GetMapping("/subject/{SubjectId}")
	public String getSubject(@PathVariable Integer SubjectId, Model model) {
		
		String pageTitle = "New Subject";
		Subject subject = new Subject();
		
		//This block get student to be updated
		if(SubjectId > 0) {
			
			//Generate new URI and append studentId to it
			String uri = defaultURI + "/" + SubjectId;
			
			//Get student from the web service
			RestTemplate restTemplate = new RestTemplate();
			subject = restTemplate.getForObject(uri, Subject.class);
			
			//Give a new title to the page
			pageTitle = "Edit Subject";
		}
		
		//Attach value to pass to front end
		model.addAttribute("subjects", subject);
		model.addAttribute("subject", pageTitle);
		
		return "subjectinfo";
	}
	
	@RequestMapping("/subject/delete/{SubjectId}")
	public String deleteSubject(@PathVariable int SubjectId) {
		
		//Generate new URI, similar to the mapping in SubjectRESTController
		String uri = defaultURI + "/{SubjectId}";
		
		//Send a DELETE request and attach the value of SubjectId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("SubjectId", Integer.toString(SubjectId)));
		
		return "redirect:/subject/list";
	}
}
