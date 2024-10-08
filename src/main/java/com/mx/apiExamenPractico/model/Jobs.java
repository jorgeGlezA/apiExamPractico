package com.mx.apiExamenPractico.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 CREATE TABLE JOBS (
ID NUMBER PRIMARY KEY,
NAME VARCHAR2 (255),
SALARY NUMBER(9,2)
);
  */
@Entity
@Table(name = "JOBS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jobs {

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER", nullable = false)
	private Long id;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR2 (255)", nullable = true)
	private String name;
	
	@Column(name = "SALARY", columnDefinition = "NUMBER(9,2)", nullable = true)
	private Long salario;
	
	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Employees> lista = new ArrayList<>();
}
