package com.chahd.voyages.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Voyage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoyage;
	private String nomVoyage;
	private Double prixVoyage;
	private Date dateVoyage;
	
	@ManyToOne
	private Classe classe;
	
	
	
	public Voyage() {
		super();
	}
	
	
	public Voyage(String nomVoyage, Double prixVoyage, Date dateVoyage) {
		super();
		this.nomVoyage = nomVoyage;
		this.prixVoyage = prixVoyage;
		this.dateVoyage = dateVoyage;
	}


	public Long getIdVoyage() {
		return idVoyage;
	}
	public void setIdVoyage(Long idVoyage) {
		this.idVoyage = idVoyage;
	}
	public String getNomVoyage() {
		return nomVoyage;
	}
	public void setNomVoyage(String nomVoyage) {
		this.nomVoyage = nomVoyage;
	}
	public Double getPrixVoyage() {
		return prixVoyage;
	}
	public void setPrixVoyage(Double prixVoyage) {
		this.prixVoyage = prixVoyage;
	}
	public Date getDateVoyage() {
		return dateVoyage;
	}
	public void setDateVoyage(Date dateVoyage) {
		this.dateVoyage = dateVoyage;
	}


	@Override
	public String toString() {
		return "Voyage [idVoyage=" + idVoyage + ", nomVoyage=" + nomVoyage + ", prixVoyage=" + prixVoyage
				+ ", dateVoyage=" + dateVoyage + "]";
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	


}
