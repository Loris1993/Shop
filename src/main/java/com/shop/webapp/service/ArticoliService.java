package com.shop.webapp.service;

import java.util.List;

import com.shop.webapp.entity.Articoli;

public interface ArticoliService {

public List<Articoli> SelByDescrizione(String descrizione);
	
	public Articoli SelByCodArt(String codArt);
	
	public Articoli SelByBarcode(String barcode);
	
	public void DelArticolo(Articoli articolo);
	
	public void InsArticolo(Articoli articolo);	

	
	
}
