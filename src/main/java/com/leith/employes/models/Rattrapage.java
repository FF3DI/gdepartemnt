package com.leith.employes.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Rattrapage {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private long id_rat;
	  @NotNull
	  @Size(min=4,max=15)
	  private String nomClasse;
	  private String module;
	  @Temporal(TemporalType.DATE)
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  @PastOrPresent
	  private Date date;
	  @ManyToOne
	  private Motif motif;
	 
}
