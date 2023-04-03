package com.Project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.Project.staff.Staff;

@Repository
public class StaffDao 
{
	@Autowired
	SessionFactory sf;
	
	private List<Staff> String;
	
	public List<Staff> getStaffRecord()
	{
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		return criteria.list();
	}
	
	public List<Staff> getARecord()
	{
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.idEq(3));
		return criteria.list();
	}
	
	public String insertData(@RequestBody List<Staff> al)
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		for(Staff staff : al)
		{
			session.save(staff);
		}
		tr.commit();
		return "Data Inserted Successfully";
	}
	
	public List<Staff> salaryMoreThan()
	{
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.gt("salary", "20000"));
		return criteria.list();
	}
	
	public List<Staff> expBetween()
	{
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.between("experience", 10, 20));
		return criteria.list();
	}
	
	public List<Staff> maxSalary()
	{
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("salary", "70000"));
		return criteria.list();
	}
	
	public String updateSalary()
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Staff s = new Staff();
		s.setStaffid(4);
		s.setName("pankaj");
		s.setProfile("admin");
		s.setSalary("60000");
		s.setExperience(22);
		session.update(s);
		tr.commit();
		session.close();
		return "Data Updated Successfully";
	}
	
	
	
	public List<Staff> getMin()
	{
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("experience", 0));
		return criteria.list();
	}
	
	public List<Staff> profileTrainer()
	{
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.like("profile", "Trainer"));
		return criteria.list();
	}
	
	public List<Staff> notProfileTrainer()
	{
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.ne("profile", "Trainer"));
		return criteria.list();
	}

	public String deleteData(int staffid) 
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Staff staff = session.load(Staff.class, staffid);
		session.delete(staff);
		tr.commit();
		session.close();
		return "Data Deleted Successfully";
	}

	public String updateData(Staff st) 
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Staff staff = session.load(Staff.class, st.getStaffid());
		session.update(staff);
		tr.commit();
		session.close();
		return "Data Updated Successfully";
	}

	public List<Staff> projectOngoing() 
	{
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("projectstatus", "ongoing"));
		return criteria.list();
	}
}
