package come.shop.webapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "INGREDIENTI")
@Data
@Getter
@Setter
public class Ingredienti implements Serializable{

private static final long serialVersionUID = -6230810713799336046L;
	
	@Id
	@Column(name = "CODART")
	private String codArt;
	
	@Column(name = "INFO")
	private String info;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	@JsonIgnore //alternativo al @JsonBackReference
	//@JsonBackReference
	private Articoli articolo;
	
	
}
