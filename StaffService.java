package com.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Project.dao.StaffDao;
import com.Project.staff.Staff;

@Service
public class StaffService 
{
	@Autowired
	StaffDao dao;
	
	public List<Staff> getStaffRecord()
	{
		return dao.getStaffRecord();
	}
	
	public List<Staff> getARecord()
	{
		return dao.getARecord();
	}
	
	public String insertData(@RequestBody List<Staff> al)
	{
		return dao.insertData(al);
	}
	
	public List<Staff> salaryMoreThan()
	{
		return dao.salaryMoreThan();
	}
	
	public List<Staff> expBetween()
	{
		return dao.expBetween();
	}
	
	public List<Staff> maxSalary()
	{
		return dao.maxSalary();
	}
	
	public String updateSalary()
	{
		return dao.updateSalary();
	}
	
	public List<Staff> getMin()
	{
		return dao.getMin();
	}
	
	public List<Staff> profileTrainer()
	{
		return dao.profileTrainer();
	}
	
	public List<Staff> notProfileTrainer()
	{
		return dao.notProfileTrainer();
	}

	public String deleteData(int staffid) 
	{
		String msg = dao.deleteData(staffid);
		return msg;
	}

	public String updateData(Staff st) 
	{
		String msg = dao.updateData(st);
		return msg;
	}

	public List<Staff> projectOngoing() 
	{
		return dao.projectOngoing();
	}
}
