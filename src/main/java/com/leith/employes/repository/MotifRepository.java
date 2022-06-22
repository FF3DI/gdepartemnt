package com.leith.employes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.leith.employes.models.Motif;
@RepositoryRestResource(path = "rest")
public interface MotifRepository extends JpaRepository<Motif, Long> {

}
