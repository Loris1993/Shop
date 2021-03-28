package com.shop.webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "famassort") 
@Data
@Getter
@Setter
public class CatProdotti implements Serializable{
	
private static final long serialVersionUID = 3788120361600509595L;
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "DESCRIZIONE")
	private String descrizione;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catProdotti")
	@JsonBackReference
	private Set<Articoli> articoli = new HashSet<>();
	
	public CatProdotti() {
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		
	}

	public Set<Articoli> getArticoli() {
		return articoli;
		
	}

	public void setArticoli(Set<Articoli> articoli) {
		this.articoli = articoli;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
		
	}

	
	

	

}
