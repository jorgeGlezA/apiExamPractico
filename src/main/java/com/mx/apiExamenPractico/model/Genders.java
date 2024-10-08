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
CREATE TABLE GENDERS (
ID NUMBER PRIMARY KEY,
NAME VARCHAR2 (255)
); 
 */

@Entity
@Table(name = "GENDERS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genders {

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER", nullable = false)
	private Long id;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR2 (255)", nullable = true)
	private String name;
	
	// Un genero tiene muchos empleados
	@OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Employees> lista = new ArrayList<>();
	
}
