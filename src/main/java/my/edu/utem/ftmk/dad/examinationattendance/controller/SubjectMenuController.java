package my.edu.utem.ftmk.dad.examinationattendance.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.examinationattendance.model.Subject;

/**
 * This class represents Menu Controller for Subject
 * 
 * @author Adib Adliyana
 * @author Rose Asnarizza
 * @author Syafiqah
 *
 */

@Controller
public class SubjectMenuController {
	
	//The URI for GET subject
	private String defaultURI = "http://localhost:8080/examinationattendance"
			+ "/api/subjects";
	
	/**
	 * This method to display list of subject
	 * 
	 * @param model
	 * @return
	 */
	
	@GetMapping("/subject/list")
	public String getSubject(Model model){
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Subject[]> response = restTemplate.getForEntity
				(defaultURI,Subject[].class);
		
		//Parse JSON data to array of object
		Subject subJects[] = response.getBody();
		
		//Parse an array to a list object
		List<Subject> subjectList = Arrays.asList(subJects);
		
		//Attribute list to model as attribute
		model.addAttribute("subJects", subjectList);
		
		return "subjects";
	}
	
}
