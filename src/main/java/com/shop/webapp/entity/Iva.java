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
	
	
}
