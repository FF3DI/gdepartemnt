package com.leith.employes.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.leith.employes.models.Rattrapage;
import com.leith.employes.models.Motif;

public interface RattrapageService {
	Rattrapage saveEmployee(Rattrapage e);
	Rattrapage updateEmployee(Rattrapage e);
	void deleteEmployee(Rattrapage e);
	void deleteEmployeeById(Long id);
	Rattrapage getEmployee(Long id);
	List<Rattrapage> getAllEmployees();
	 List<Motif> getAllPostes();	
	Page<Rattrapage> getAllEmployeesParPage(int page, int size);
	List<Rattrapage> findByNomEmploye(String nom);
	List<Rattrapage> findByNomEmployesContains(String nom);
	List<Rattrapage> findByNomDomaine (String nom, String domaine);
	List<Rattrapage> findByOrderByNomClasseAsc();
	List<Rattrapage> trierEmployesNomsDomaine();

}
