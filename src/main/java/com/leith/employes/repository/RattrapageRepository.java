package com.leith.employes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.leith.employes.models.Rattrapage;
@RepositoryRestResource(path = "rest")
public interface RattrapageRepository extends JpaRepository<Rattrapage, Long>  {
  List<Rattrapage>findBynomClasse(String nom);
  List<Rattrapage>findBynomClasseContains(String nom);
  @Query("select e from Rattrapage e where e.nomClasse like %:nom and e.module > :module")
  List<Rattrapage> findByNommodule (@Param("nom") String nom,@Param("module") String module);
  
 
  
  
  @Query("select e from Rattrapage e order by e.nomClasse ASC, e.module DESC")
  List<Rattrapage> trierEmployesNomsmodule ();
  
  
}
