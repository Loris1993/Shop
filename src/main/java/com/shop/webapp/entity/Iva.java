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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "IVA")
@Data
@Getter
@Setter
public class Iva {

	@Id
	@Column(name = "IDIVA")
	private int idIva;
	
	@Column(name = "DESCRIZIONE")
	private String descrizione;
	
	@Column(name = "ALIQUOTA")
	private int aliquota;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "iva") //manca il parametro cascade perchÃ¨ l'accesso sarÃ  di sola lettura
	@JsonBackReference
	private Set<Articoli> articoli = new HashSet<>();


	public int getIdIva() {
		return idIva;
	}


	public void setIdIva(int idIva) {
		this.idIva = idIva;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public int getAliquota() {
		return aliquota;
	}


	public void setAliquota(int aliquota) {
		this.aliquota = aliquota;
	}


	public Set<Articoli> getArticoli() {
		return articoli;
	}


	public void setArticoli(Set<Articoli> articoli) {
		this.articoli = articoli;
	}
	
	
}
