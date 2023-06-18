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

@Controller
public class StaffMenuController {

	private String defaultURI = "http://localhost:8080/examinationattendance/api/staffs";
	
	@GetMapping("/staff/list")
	public String getStaff(Model model){
		
		//The URI for GET staff
		String uri = "http://localhost:8080/examinationattendance/api/staffs";
		
		//Get a list staff from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Staff[]> response = restTemplate.getForEntity(uri, Staff[].class);
		
		//Parse JSON data to array of object
		Staff sTaffs[] = response.getBody();
		
		//Parse an array to a list object
		List<Staff> staffList = Arrays.asList(sTaffs);
				
		//Attribute list to model as attribute
		model.addAttribute("sTaffs", staffList);
				
		return "staffS";
	}
	
	@RequestMapping("/staff/save")
	public String updateStaff(@ModelAttribute Staff staff) {
		
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Staff> request = new HttpEntity<Staff>(staff);
		
		String staffResponse = "";
		
		if (staff.getStaffId() > 0) {
			//This block update an new order type and
			
			//Send request as PUT
			restTemplate.put(defaultURI, request, Staff.class);
		} else {
			//This block add a new student
			
			//send request as POST
			staffResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		
		System.out.println(staffResponse);
		
		//Redirect request to display a list of staff
		return "redirect:/staff/list";
	}
	
	@GetMapping("/staff/{StaffId}")
	public String getStudent(@PathVariable Integer StaffId, Model model) {
		
		String pageTitle = "New Staff";
		Staff staff = new Staff();
		
		//This block get staff to be updated
		if(StaffId > 0) {
			
			//Generate new URI and append studentId to it
			String uri = defaultURI + "/" + StaffId;
			
			//Get student from the web service
			RestTemplate restTemplate = new RestTemplate();
			staff = restTemplate.getForObject(uri, Staff.class);
			
			//Give a new title to the page
			pageTitle = "Edit Staff";
		}
		
		//Attach value to pass to front end
		model.addAttribute("staffs", staff);
		model.addAttribute("staff", pageTitle);
		
		return "staffinfo";
	}
	
//	@RequestMapping("/student/delete/{StudentId}")
//	public String deleteStudent(@PathVariable int StudentId) {
//		
//		//Generate new URI, similar to the mapping in StudentRESTController
//		String uri = defaultURI + "/{StudentId}";
//		
//		//Send a DELETE request and attach the value of StudentId into URI
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.delete(uri, Map.of("StudentId", Integer.toString(StudentId)));
//		
//		return "redirect:/student/list";
//	}
	
}
