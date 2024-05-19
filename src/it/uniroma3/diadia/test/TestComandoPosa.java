package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.*;


import org.junit.Test;

public class TestComandoPosa {

	private Partita partita;
	private ComandoPosa comandoPosa;
	private IO IO;
	private Attrezzo leggero;
	private Labirinto lab;

	
	@Before
	public void setup() {
		this.lab= new LabirintoBuilder();
		lab.creaStanze();
		this.partita= new Partita(lab);
		this.IO= new IOConsole();
		this.leggero= new Attrezzo("leggero", 3);
		this.comandoPosa= new ComandoPosa(IO);
		
		
	}
	
	
	@Test
	public void TestCoamdoPosaConParametroNULL() {
		comandoPosa.setParametro(null);
		comandoPosa.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(null));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(null));
	}
	
	@Test
	public void TestComandoPosaConParametroUnAttrezzoInesistente() {
		
		comandoPosa.setParametro("martello");
		comandoPosa.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	@Test
	public void TestComandoPosaConParametroUnAttrezzoEsistente() {
		assertTrue(partita.getGiocatore().getBorsa().addAttrezzo(leggero));
		comandoPosa.setParametro("leggero");
		comandoPosa.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("leggero"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("leggero"));
	}
	
	
	
	
	

}
