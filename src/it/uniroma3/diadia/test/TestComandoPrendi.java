package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.*;

public class TestComandoPrendi {
	
	private Partita partita;
	private ComandoPrendi cp;
	private IO IO;
	private Attrezzo pesante;
	private Attrezzo leggero;
	@Before
	public void SetUp() { 
		this.partita=new Partita();
		this.IO= new IOConsole();
		this.cp= new ComandoPrendi(IO);
		new Attrezzo("x", 2);
		this.leggero= new Attrezzo("leggero", 1);
		this.pesante= new Attrezzo("pesante", 10);
		
		this.partita.getStanzaCorrente().addAttrezzo(leggero);

	}
	
	
	@Test
	public void TestComandoPrendiConNull() {
		this.cp.setParametro(null);
		cp.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(null));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(null));
	}
	
	@Test
	public void TestComandoPrendiConAttrezzoNonEsistente() {
		this.cp.setParametro("x");
		cp.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(null));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(null));
	}
	
	
	@Test
	public void TestComandoPrendiConBorsaPiena() {
		
		this.partita.getGiocatore().getBorsa().addAttrezzo(pesante);
		this.cp.setParametro("leggero");
		cp.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("leggero"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("leggero"));
	}
	
	@Test
	public void TestComandoPrendiConBorsaDisponibile() {
		this.cp.setParametro("leggero");
		cp.esegui(this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("leggero"));
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("leggero"));
	}

	
	
	
	
	
}
