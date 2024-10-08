package com.mx.apiExamenPractico.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
CREATE TABLE EMPLOYEE_WORKED_HOURS(
ID NUMBER PRIMARY KEY,
EMPLOYEE_ID NUMBER,
WORKED_HOURS NUMBER,
WORKED_DATE DATE,
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYERS (ID)
);
*/

@Entity
@Table(name = "EMPLOYEE_WORKED_HOURS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeWorkedHours {

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER", nullable = false)
	private Long id;
	
	@Column(name = "WORKED_HOURS", columnDefinition = "NUMBER", nullable = true)
	private Integer workedHourd;
	
	@Column(name = "WORKED_DATE", columnDefinition = "DATE", nullable = true)
	private Date workedDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	Employees employees;
}
