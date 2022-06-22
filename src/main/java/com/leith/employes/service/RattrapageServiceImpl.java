package com.leith.employes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.leith.employes.models.Rattrapage;
import com.leith.employes.models.Motif;
import com.leith.employes.repository.MotifRepository;
import com.leith.employes.repository.RattrapageRepository;

@Service
public class RattrapageServiceImpl implements RattrapageService {
  @Autowired
  RattrapageRepository rattrapageRepository;
  @Autowired
  MotifRepository motifRepository;
@Override
public Rattrapage saveEmployee(Rattrapage e) {
	// TODO Auto-generated method stub
	return rattrapageRepository.save(e);
}

@Override
public Rattrapage updateEmployee(Rattrapage e) {
	// TODO Auto-generated method stub
	return rattrapageRepository.save(e);
}

@Override
public void deleteEmployee(Rattrapage e) {
	// TODO Auto-generated method stub
	rattrapageRepository.delete(e);
	
}

@Override
public void deleteEmployeeById(Long id) {
	// TODO Auto-generated method stub
	rattrapageRepository.deleteById(id);
}

@Override
public Rattrapage getEmployee(Long id) {
	// TODO Auto-generated method stub
	return rattrapageRepository.findById(id).get();
}

@Override
public List<Rattrapage> getAllEmployees() {
	
	return rattrapageRepository.findAll();
}

@Override
public Page<Rattrapage> getAllEmployeesParPage(int page, int size) {
	return rattrapageRepository.findAll(PageRequest.of(page, size));
}

@Override
public List<Rattrapage> findByNomEmploye(String nom) {
	// TODO Auto-generated method stub
	return rattrapageRepository.findBynomClasse(nom);
}

@Override
public List<Rattrapage> findByNomEmployesContains(String nom) {
	// TODO Auto-generated method stub
	return rattrapageRepository.findBynomClasseContains(nom);
}

@Override
public List<Rattrapage> findByNomDomaine(String nom, String domaine) {
	// TODO Auto-generated method stub
	return rattrapageRepository.findByNommodule(nom, domaine);
}





@Override
public List<Rattrapage> trierEmployesNomsDomaine() {
	// TODO Auto-generated method stub
	return rattrapageRepository.trierEmployesNomsmodule();
}

@Override
public List<Motif> getAllPostes() {
	return motifRepository.findAll();
}

@Override
public List<Rattrapage> findByOrderByNomClasseAsc() {
	// TODO Auto-generated method stub
	return null;
}




  
}
