package com.springboot.hcmservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hcmservice.dto.Employee;
import com.springboot.hcmservice.dto.EmployeeDetails;
import com.springboot.hcmservice.entity.Hcm;
import com.springboot.hcmservice.service.HcmService;




@RestController
@RequestMapping("/hcm")
public class HcmController {
	@Autowired
	private HcmService hcmService;
	
	@PostMapping("/create")
	public Hcm createEmployee(@RequestBody Hcm hcm) {
	return	hcmService.createHcm(hcm);
	}
	
	@PutMapping("/update")
	public String updateHcm(@RequestBody Hcm hcm) {
		return hcmService.updateHcm(hcm);
		
	}
	@GetMapping
	public List<Hcm> getAllHcm(){
	return  hcmService.getAllHcm();
	}
	
	@PostMapping("/getDetails")
	public List<EmployeeDetails> getEmployeeDetails(@RequestBody  List<Employee> emplist){
		System.out.println("emplist::::::::::::::"+emplist);
		return  hcmService.getAllEmployeeDetails(emplist);
		}

}
