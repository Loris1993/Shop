package com.shop.webapp.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.webapp.entity.Articoli;

import java.util.List;


public interface ArticoliRepository extends JpaRepository<Articoli,String>{
	
Articoli findByCodArt(String codArt);
	
	List<Articoli> findByDescrizioneLike(String descrizione);
	
	//JPQL
	@Query(value="SELECT a FROM Articoli a JOIN a.barcode b WHERE b.barcode IN (:ean)")
	Articoli SelByEan(@Param("ean") String ean);
	
	

}
