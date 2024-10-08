package com.mx.apiExamenPractico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.apiExamenPractico.dao.EmployeeWorkedHoursDao;
import com.mx.apiExamenPractico.model.EmployeeWorkedHours;

@Service
public class EmployeeWorkedHoursImp {

	@Autowired
	EmployeeWorkedHoursDao empWorkHoursDao;
	
	public List<EmployeeWorkedHours> listar(){
		return empWorkHoursDao.findAll();
	}
}
