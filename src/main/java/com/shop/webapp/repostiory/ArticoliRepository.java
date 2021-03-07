package com.shop.webapp.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import come.shop.webapp.entity.Articoli;


public interface ArticoliRepository extends JpaRepository<Articoli,String>{
	
Articoli findByCodArt(String codArt);
	
	List<Articoli> findByDescrizioneLike(String descrizione);
	
	//JPQL
	@Query(value="SELECT a FROM Articoli a JOIN a.barcode b WHERE b.barcode IN (:ean)")
	Articoli SelByEan(@Param("ean") String ean);
	
	

}
