package com.springboot.hcmservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="HCM_TB")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
public class Hcm {
	
	@Id
	private int employeeId;
	private String experience;
	private String yearsInCurrentRole;
	private String goalCompletedForCurrentYear;
	private String ClientAppreciationForCurrentYear;
	

}
