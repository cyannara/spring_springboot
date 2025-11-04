package com.dbal.app.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpVO {
	
    String employeeId;   
	String firstName;
	String lastName;
	String email;
	Date hireDate; 
	String jobId;	
	String departmentId;
	Integer salary;
}
