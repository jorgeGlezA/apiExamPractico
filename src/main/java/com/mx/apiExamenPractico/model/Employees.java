package com.mx.apiExamenPractico.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
CREATE TABLE EMPLOYERS(
ID NUMBER PRIMARY KEY,
GENDER_ID NUMBER,
JOB_ID NUMBER,
NAME VARCHAR2 (255),
LAST_NAME VARCHAR2 (255),
BIRTHDAY DATE,
CONSTRAINT PK_GENDERS FOREIGN KEY (GENDER_ID) REFERENCES GENDERS(ID),
CONSTRAINT PK_JOBS FOREIGN KEY (JOB_ID) REFERENCES JOBS(ID)
);
*/

@Entity
@Table(name = "EMPLOYERS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employees {

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER", nullable = false)
	private Long id;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR2 (255)", nullable = true)
	private String name;
	
	@Column(name = "LAST_NAME", columnDefinition = "VARCHAR2 (255)", nullable = true)
	private String lastName;
	
	@Column(name = "BIRTHDAY", columnDefinition = "DATE", nullable = true)
	private Date birthday;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GENDER_ID")
	Genders gender;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JOB_ID")
	Jobs job;
	
	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	@JsonIgnore
	List<EmployeeWorkedHours> lista = new ArrayList<>();
	
	
}
