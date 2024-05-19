package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestClassePartita {
	
	
	private Labirinto labirinto ;
	private Partita partita;
	
	
	@Before
	public void setup() {
		this.labirinto= new LabirintoBuilder();
		labirinto.creaStanze();
		this.partita= new Partita(labirinto);
	}
	//stanza corrente è null
	@Test
	public void testVintaNull() {
		
		partita.setStanzaCorrente(null);
		assertFalse(partita.vinta());
		
	}
	
	
	//stanza corrente non corrisponde alla stanza vincente
	@Test
	public void testVintaConSTanzaCorrenteSbagliata() {
		
		Stanza s= new Stanza("s");
		partita.setStanzaCorrente(s);
		assertFalse(partita.vinta());
		
	}
	
	
	
	//stanza cooretne corrisponde alla stanza vincente
	@Test
	public void testVintaSTanzaGiustal() {
		
		partita.setStanzaCorrente(partita.getStanzaCorrente().getStanzaAdiacente("nord"));
		assertTrue(partita.vinta());
		
	}
	
	
}
