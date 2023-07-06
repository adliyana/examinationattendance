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
import my.edu.utem.ftmk.dad.examinationattendance.model.Staff;

/**
 * This class represents Menu Controller for Staff
 * 
 * @author Adib Adliyana
 * @author Rose Asnarizza
 * @author Syafiqah
 *
 */

@Controller
public class StaffMenuController {

	//The URI for GET staff
	private String defaultURI = "http://localhost:8080/examinationattendance/"
			+ "api/staffs";
	
	/**
	 * This method to display list of staff
	 * 
	 * @param model
	 * @return
	 */
	
	@GetMapping("/staff/list")
	public String getStaff(Model model){
		
		//Get a list staff from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Staff[]> response = restTemplate.getForEntity(defaultURI, 
				Staff[].class);
		
		//Parse JSON data to array of object
		Staff sTaffs[] = response.getBody();
		
		//Parse an array to a list object
		List<Staff> staffList = Arrays.asList(sTaffs);
				
		//Attribute list to model as attribute
		model.addAttribute("sTaffs", staffList);
				
		return "staffs";
	}
}
