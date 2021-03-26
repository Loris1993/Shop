package com.shop.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.webapp.entity.Articoli;
import com.shop.webapp.exception.NotFoundException;
import com.shop.webapp.service.ArticoliService;



@RestController
@RequestMapping("/api/articoli")
public class ArticoliController {

private static final Logger logger = LoggerFactory.getLogger(ArticoliController.class);
	
	@Autowired
	private ArticoliService articoliService;

	
	// ---- Ricerca Per Barcode coerente con i metodi della classe SelectArtTest--
	//produce un JSON
	@GetMapping(value = "/cerca/ean/{barcode}", produces = "application/json")
	public ResponseEntity<Articoli> listArtByEan(@PathVariable("barcode") String Barcode) throws NotFoundException	 
	{
		logger.info(String.format("****** Otteniamo l'articolo con barcode %s *******", Barcode) );
		
		Articoli articolo = articoliService.SelByBarcode(Barcode);
		
		if (articolo == null)
		{
			String ErrMsg = String.format("Il barcode %s non è stato trovato!", Barcode);
			
			logger.warn(ErrMsg);
			
			throw new NotFoundException(ErrMsg);
		}
		
		return new ResponseEntity<Articoli>(articolo, HttpStatus.OK);// status 200
	}
	
	
	
	
}
