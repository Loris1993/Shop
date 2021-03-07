package com.shop.webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BARCODE")
@Data
@NoArgsConstructor
@AllArgsConstructor 
@Getter
@Setter
public class Barcode implements Serializable  {

	public Barcode(String string, String string2, Articoli articolo2) {
		
	
		
	}

	private static final long serialVersionUID = 8682477643109847337L;

	
	@Id
	@Column(name = "BARCODE")
	private String barcode;
	
	@Column(name = "IDTIPOART")
	private String idTipoArt;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude //per bug @data lombok
	@JoinColumn(name = "CODART", referencedColumnName = "codArt")
	@JsonBackReference
	private Articoli articolo; //Il nome deve essere coerente con parametro MappedBy

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getIdTipoArt() {
		return idTipoArt;
	}

	public void setIdTipoArt(String idTipoArt) {
		this.idTipoArt = idTipoArt;
	}

	public Articoli getArticolo() {
		return articolo;
	}

	public void setArticolo(Articoli articolo) {
		this.articolo = articolo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
