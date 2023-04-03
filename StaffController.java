package com.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project.service.StaffService;
import com.Project.staff.Staff;

@RestController
public class StaffController 
{
	@Autowired
	StaffService service;
	
	@GetMapping("/getData")
	public List<Staff> getStaffRecord()
	{
		return service.getStaffRecord();
	}
	
	@GetMapping("/getAData")
	public List<Staff> getARecord()
	{
		return service.getARecord();
	}
	
	@PostMapping("/insertData")
	public String insertData(@RequestBody List<Staff> al)
	{
		return service.insertData(al);
	}
	
	@GetMapping("/salaryMoreThan")
	public List<Staff> salaryMoreThan()
	{
		return service.salaryMoreThan();
	}
	
	@GetMapping("/expBetween")
	public List<Staff> expBetween()
	{
		return service.expBetween();
	}
	
	@GetMapping("/maxSalary")
	public List<Staff> maxSalary()
	{
		return service.maxSalary();
	}
	
	@PutMapping("/updateSalary")
	public String updateSalary()
	{
		return service.updateSalary();
	}
	
	@GetMapping("/getMin")
	public List<Staff> getMin()
	{
		return service.getMin();
	}
	
	@GetMapping("/profileTrainer")
	public List<Staff> profileTrainer()
	{
		return service.profileTrainer();
	}
	
	@GetMapping("/notProfileTrainer")
	public List<Staff> notProfileTrainer()
	{
		return service.notProfileTrainer();
	}
	
	@DeleteMapping("/deleteData/{staffid}")
	public String deleteData(@PathVariable int staffid)
	{
		String msg = service.deleteData(staffid);
		return msg;
	}

	@PutMapping("/updateData")
	public String updateData(@RequestBody Staff st)
	{
		String msg = service.updateData(st);
		return msg;
	}
	
	@GetMapping("/prjongoing")
	public List<Staff> projectOngoing()
	{
		return service.projectOngoing();
	}
}
