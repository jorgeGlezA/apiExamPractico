package com.mx.apiExamenPractico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.apiExamenPractico.model.EmployeeWorkedHours;

public interface EmployeeWorkedHoursDao extends JpaRepository<EmployeeWorkedHours, Long> {

}
