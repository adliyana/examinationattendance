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
import org.springframework.web.client.RestTemplate;
import my.edu.utem.ftmk.dad.examinationattendance.model.Device;

@Controller
public class DeviceMenuController {

	private String defaultURI = "http://localhost:8080/examinationattendance/api/devices";
	
	@GetMapping("/device/list")
	public String getDevice(Model model){
		
		//The URI for GET device
		String uri = "http://localhost:8080/examinationattendance/api/devices";
		
		//Get a list DEVICE from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Device[]> response = restTemplate.getForEntity(uri, Device[].class);
		
		//Parse JSON data to array of object
		Device deVices[] = response.getBody();
		
		//Parse an array to a list object
		List<Device> deviceList = Arrays.asList(deVices);
						
		//Attach list to model as attribute
		model.addAttribute("deVices",deviceList);
						
		return "devices";
	}
	
	public String updateDevice(@ModelAttribute Device device) {
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Device> request = new HttpEntity<Device>(device);
		
		String deviceResponse = "";
		
		if(device.getDeviceId()>0) {
			//This block update an new order type and
			
			//Send request as PUT
			restTemplate.put(defaultURI, request, Device.class);
			
		} else {
			//This block add a new order type
			
			//send request as POST
			deviceResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(deviceResponse);
		
		//Redirect request to display a list or order type
		return "redirect:/device/list";
	}
	
	public String getDevice(@PathVariable Integer deviceId, Model model) {
		
		String pageTitle = "New Device";
		Device device = new Device();
		
		//This block get device to be updated
		if(deviceId > 0) {
			
			//Generate new URI and append deviceId to it
			String uri = defaultURI + "/" + deviceId;
			
			//Get an device from the web service
			RestTemplate restTemplate = new RestTemplate();
			device = restTemplate.getForObject(uri, Device.class);
			
			//Give a new title to the page
			pageTitle = "Edit Device";
		}
		
		//Attach value to pass to front end
		model.addAttribute("device", device);
		model.addAttribute("pageTitle", pageTitle);
		
		return "deviceinfo";
	}
	
//	public String deleteDevice(@PathVariable int deviceId) {
//		
//		//Generate new URI, similar to the mapping in DeviceRESTController
//		String uri = defaultURI + "/{deviceId}";
//		
//		//Send a DELETE request and attach the value of orderTypeId into URI
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.delete(uri, Map.of("deviceId", Integer.toString(deviceId)));
//		
//		return "redirect:/device/list";
//	}
}