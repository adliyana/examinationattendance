package my.edu.utem.ftmk.dad.examinationattendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import my.edu.utem.ftmk.dad.examinationattendance.model.Device;
import my.edu.utem.ftmk.dad.examinationattendance.repository.DeviceRepository;

@RestController
@RequestMapping("/api/devices")
public class DeviceRESTController {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@GetMapping
	public List<Device> getDevice(){
		
		return deviceRepository.findAll();
	}
	@GetMapping("{deviceId}")	
	public Device getDevice(@PathVariable long deviceId){
			
			Device device = deviceRepository.findById(deviceId).get();
			
			return device;
		}
	
	@PostMapping()
	public Device insertDevice(@RequestBody Device device) {
		
		return deviceRepository.save(device);
	}

	@PutMapping()
	public Device updateDevice(@RequestBody Device device) {
		return deviceRepository.save(device);
	}
	
	@DeleteMapping("{deviceId}")
	public ResponseEntity<HttpStatus> deleteDevice(@PathVariable long deviceId) {
		
		deviceRepository.deleteById(deviceId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
