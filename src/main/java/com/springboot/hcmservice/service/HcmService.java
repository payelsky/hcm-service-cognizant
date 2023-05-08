package com.springboot.hcmservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.hcmservice.dto.Employee;
import com.springboot.hcmservice.dto.EmployeeDetails;
import com.springboot.hcmservice.entity.Hcm;
import com.springboot.hcmservice.repository.HcmRepository;

@Service
public class HcmService {
	
	@Autowired
	private HcmRepository hcmrepository;
	
	public Hcm createHcm(Hcm hcm) {
		return 	hcmrepository.save(hcm);
		}
	
	public String updateHcm(Hcm hcm) {
		Hcm hcm1=hcmrepository.findById(hcm.getEmployeeId()).get();	
		if(hcm1!=null) {
			hcm1=Hcm.build(hcm1.getEmployeeId(), hcm.getExperience(), hcm.getYearsInCurrentRole(), hcm.getGoalCompletedForCurrentYear(), hcm.getClientAppreciationForCurrentYear());
					hcmrepository.save(hcm1);
			return "Success";
		}else {
		   return "No data Found";
		}
	}
	
	public List<Hcm> getAllHcm(){
		return hcmrepository.findAll();
	}
	
	public List<EmployeeDetails> getAllEmployeeDetails(List<Employee> emplist){
		List<Integer> idlist=emplist.stream().map(e->e.getEmployeeId()).collect(Collectors.toList());
		List<Hcm> hcmlist=hcmrepository.findByemployeeIdIn(idlist);
		List<EmployeeDetails> empdetailslist=hcmlist.stream().map(hc->EmployeeDetails.build(hc.getEmployeeId(), "", "", "", "", "", hc.getExperience(), hc.getYearsInCurrentRole(), hc.getGoalCompletedForCurrentYear(), hc.getClientAppreciationForCurrentYear()))
		                .collect(Collectors.toList());
		
		empdetailslist= empdetailslist.stream().map(empd->{
		  Employee em=emplist.stream().filter(emp->emp.getEmployeeId()==empd.getEmployeeId()).findAny().get();	 
		 
		  empd.setAddress(em.getAddress());
		  empd.setAge(em.getAge()); 
		  empd.setGender(em.getGender()); 
		  empd.setName(em.getName());
		  empd.setIsActive(em.getIsActive());
		  return empd;
		  }).collect(Collectors.toList());
		 
		System.out.println("empdetailslist:::::::::::::::::::::::::"+empdetailslist);
	//	empdetailslist.stream().map(empd->)
		return empdetailslist;
	}

}
