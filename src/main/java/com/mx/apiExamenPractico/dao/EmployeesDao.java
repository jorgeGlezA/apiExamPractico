package com.mx.apiExamenPractico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.apiExamenPractico.model.Employees;

public interface EmployeesDao extends JpaRepository<Employees, Long> {

}
