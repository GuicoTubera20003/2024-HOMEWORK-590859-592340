package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;



public class TestClasseLabirintoTest {
	
	Stanza stanza1= new Stanza("Atrio");
	Stanza stanza2= new Stanza("Biblioteca");
	Labirinto labirinto= new Labirinto();
	
	
	
	@Test
	public void testGetStanzaInizialeNull() {
		
		labirinto.setIniziale(null);
		assertEquals(null, labirinto.getIniziale());
		
	}
	
	@Test
	public void testGetStanzaIniziale() {
		
		labirinto.setIniziale(stanza1);		
		assertEquals(stanza1, labirinto.getIniziale());
		
	}
	
	@Test
	public void testGetStanzaFinaleNUll() {
		
		labirinto.setFinale(null);
		assertEquals(null, labirinto.getFinale());
	}
	
	@Test
	public void testGetStanzaFinale() {
		
		labirinto.setFinale(stanza2);	
		assertEquals(stanza2, labirinto.getFinale());
	}
	
	@Test
	public void testGetStanzaVincente() {
		
		labirinto.setFinale(stanza2);	
		assertEquals(stanza2, labirinto.getStanzaVincente());
	}

}

