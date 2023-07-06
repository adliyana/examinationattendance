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

/**
 * This class represents Menu Controller for Examination
 * 
 * @author Adib Adliyana
 * @author Rose Asnarizza
 * @author Syafiqah
 *
 */

@Controller
public class ExaminationMenuController {
	
	// The URI for GET Examination
	private String defaultURI = "http://localhost:8080/examinationattendance/"
			+ "api/examinations";
	
	/**
	 * This method to display list of examination
	 * 
	 * @param model
	 * @return
	 */
	
	@GetMapping("/examination/list")
	public String getStudent(Model model){
		
		// Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Examination[]> response = restTemplate.getForEntity
				(defaultURI, Examination[].class);
		
		// Parse JSON data to array of object
		Examination exaMinations[] = response.getBody();
		
		// Parse an array to a list object
		List<Examination> examinationList = Arrays.asList(exaMinations);
		
		// Attribute list to model as attribute
		model.addAttribute("exaMinations", examinationList);
		
		return "examinations";
	}
}
