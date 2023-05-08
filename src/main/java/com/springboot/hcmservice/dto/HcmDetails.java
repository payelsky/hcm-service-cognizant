package com.springboot.hcmservice.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
public class HcmDetails {
	
	private int employeeId;
	private String experience;
	private String yearsInCurrentRole;
	private String goalCompletedForCurrentYear;
	private String ClientAppreciationForCurrentYear;
	

}
