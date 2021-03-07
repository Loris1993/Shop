package com.shop.webapp.UnitTest.RepositoryTests;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.shop.webapp.Application;
import com.shop.webapp.entity.Articoli;
import com.shop.webapp.entity.Barcode;
import com.shop.webapp.entity.CatProdotti;
import com.shop.webapp.repostiory.ArticoliRepository;

@SpringBootTest()
@ContextConfiguration(classes = Application.class)
@TestMethodOrder(OrderAnnotation.class)
public class ArticoliRepostioryTest {
	
	@Autowired
	private ArticoliRepository articoliRepository;
	
	
	//test di creazione , inserimento e asserzione dell'articolo creato
	@Test
	@Order(1)
	public void TestInsArticolo()
	{
		//creo articolo
		Articoli articolo = new Articoli("123Test","Articolo di Test",6,1.75,"1");
		
		
		//creo categoria prodotti
		CatProdotti catProdotti = new CatProdotti();
		catProdotti.setId(1);
		articolo.setCatProdotti(catProdotti);
		
		//creo barcode
		Set<Barcode> Eans = new HashSet<>();
		Eans.add(new Barcode("12345678", "CP", articolo));
		
		articolo.setBarcode(Eans);
		
		//inserisco l'articolo
		articoliRepository.save(articolo);
		
		//asserzione : estraggo l'articolo per id e lo confronto con quello creato
		assertThat(articoliRepository.findByCodArt("123Test")) //metodo di SpringDataJPA
		.extracting(Articoli::getDescrizione)
		.isEqualTo("Articolo di Test");
	}
	
	
	
	//test asserzione ricerca per descrizione
	@Test
	@Order(2)
	public void TestSelByDescrizioneLike()
	{
		
		List<Articoli> items = articoliRepository.findByDescrizioneLike("Articolo di Test"); 
		assertEquals(1, items.size());
	}
	
	
	//test asserzione ricerca per codice a barre
	@Test
	@Order(3)
	public void TestfindByEan() throws Exception
	{
		assertThat(articoliRepository.SelByEan("12345678"))
				.extracting(Articoli::getDescrizione)
				.isEqualTo("Articolo di Test");
				
	}
	
	//test cancellazione articolo di test creato
	@Test
	@Order(4)
	public void TestDelArticolo()
	{
		Articoli articolo = articoliRepository.findByCodArt("123Test");
		
		articoliRepository.delete(articolo);
		
	}
	
	
	
	
	

}
