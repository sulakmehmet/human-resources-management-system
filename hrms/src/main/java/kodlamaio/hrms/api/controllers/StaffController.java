package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.StaffService;
import kodlamaio.hrms.entities.concretes.Staff;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
	
	private StaffService staffService;
	
	@Autowired
	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}

	@GetMapping("/getall")
	public List<Staff> getAll(){
		return this.staffService.getAll();
	}

}
