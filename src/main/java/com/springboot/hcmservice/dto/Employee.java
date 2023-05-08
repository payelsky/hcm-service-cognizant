package com.springboot.hcmservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	private int employeeId;
	private String name;
	private String age;
    private String gender;
	private String address;
	private String isActive;
	

}
