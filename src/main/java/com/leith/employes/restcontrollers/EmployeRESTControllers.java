package com.leith.employes.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leith.employes.models.Rattrapage;
import com.leith.employes.service.RattrapageService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeRESTControllers {
	@Autowired
	RattrapageService rattrapageService;
	@RequestMapping(method=RequestMethod.GET)
	public List<Rattrapage> getAllEmployes(){
		return rattrapageService.getAllEmployees();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Rattrapage getEmployeById(@PathVariable("id") Long id) {
	return rattrapageService.getEmployee(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public Rattrapage createEmploye(@RequestBody Rattrapage employe) {
	return rattrapageService.saveEmployee(employe);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Rattrapage updateEmploye(@RequestBody Rattrapage employe) {
	return rattrapageService.updateEmployee(employe);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteEmploye(@PathVariable("id") Long id)
	{
	rattrapageService.deleteEmployeeById(id);
	}
	
}
