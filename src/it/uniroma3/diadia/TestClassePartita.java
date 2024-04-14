package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class TestClassePartita {

	Partita partita= new Partita();
	
	
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
