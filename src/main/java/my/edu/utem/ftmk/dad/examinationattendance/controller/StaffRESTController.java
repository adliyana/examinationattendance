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
import my.edu.utem.ftmk.dad.examinationattendance.model.Staff;
import my.edu.utem.ftmk.dad.examinationattendance.repository.StaffRepository;

@RestController
@RequestMapping("/api/staffs")
public class StaffRESTController {

	@Autowired
	private StaffRepository staffRepository;
	
	@GetMapping
	public List<Staff> getStaff(){
		
		return staffRepository.findAll();
	}
	
	@GetMapping("{staffId}")
	public Staff getStaff(@PathVariable long staffId){
		
		Staff staff = staffRepository.findById(staffId).get();
		
		return staff;
	}
	
	@PostMapping()
	public Staff insertStaff(@RequestBody Staff staff) {
		
		return staffRepository.save(staff);
	}
	
	@PutMapping()
	public Staff updateStaff(@RequestBody Staff staff) {
		return staffRepository.save(staff);
	}
	
	@DeleteMapping("{staffId}")
	public ResponseEntity<HttpStatus> deleteStaff(@PathVariable long staffId) {
		
		staffRepository.deleteById(staffId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
