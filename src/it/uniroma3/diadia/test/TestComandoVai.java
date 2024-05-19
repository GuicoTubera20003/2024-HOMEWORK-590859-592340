package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class TestComandoVai {

	private Partita partita;
	private ComandoVai cv;
	private Labirinto lab;
	private IO io;

	@Before
	public void setup() {
		io= new IOConsole();
		cv= new ComandoVai(io);
	}

	@Test
	public void TestComandoVaiMonolocale() {
		lab= new LabirintoBuilder().addStanzaIniziale("stanza iniziale").addStanzaVincente("stanza iniziale");
		this.partita= new Partita(lab);
		cv.setParametro("nord");
		cv.esegui(partita);
		Stanza stanzaIniziale= new Stanza("stanza iniziale");
		assertEquals(stanzaIniziale, partita.getStanzaCorrente());
	}
	
	@Test
	public void TestComandoVaiBilocale() {
		lab= new LabirintoBuilder().addStanzaIniziale("stanza iniziale").addStanza("stanza finale").addAdiacenza("stanza iniziale", "stanza finale", "nord")
				 .getLabirinto();
		this.partita= new Partita(lab);
		assertNotNull(partita.getStanzaCorrente());
		assertNotNull(partita.getStanzaCorrente().getStanzaAdiacente("nord"));
		cv.setParametro("nord");
		cv.esegui(partita);
		Stanza stanzaFInale= new Stanza("stanza finale");
		assertEquals(stanzaFInale, partita.getStanzaCorrente());
				
	
	}
	
	
	@Test
	public void TestComandoVaiStanzaBloccataConChiave() {
		lab= new LabirintoBuilder().addStanzaIniziale("stanza iniziale")
				.addStanzaVincente("stanza vincente")
				.addStanzaBloccata("stanza bloccata", "nord", "chiave")
				.addAttrezzo("chiave", 2)
				.addAdiacenza("stanza iniziale", "stanza bloccata", "nord")
				.addAdiacenza("stanza bloccata", "stanza vincente", "nord")
				.getLabirinto();
		this.partita= new Partita(lab);
		assertNotNull(partita.getStanzaCorrente().getStanzaAdiacente("nord"));
		cv.setParametro("nord");
		cv.esegui(partita);
		cv.setParametro("nord");
		cv.esegui(partita);
		Stanza sv= new Stanza("stanza vincente");
		assertEquals(sv, partita.getStanzaCorrente());
	}
	
	
	
	@Test
	public void TestComandoVaiStanzaBloccata() {
		lab= new LabirintoBuilder().addStanzaIniziale("stanza iniziale")
				.addStanzaVincente("stanza vincente")
				.addStanzaBloccata("stanza bloccata", "nord", "chiave")
				.addAttrezzo("martello", 2)
				.addAdiacenza("stanza iniziale", "stanza bloccata", "nord")
				.addAdiacenza("stanza bloccata", "stanza vincente", "nord")
				.getLabirinto();
		this.partita= new Partita(lab);
		assertNotNull(partita.getStanzaCorrente().getStanzaAdiacente("nord"));
		cv.setParametro("nord");
		cv.esegui(partita);
		cv.setParametro("nord");
		cv.esegui(partita);
		Stanza sv= new Stanza("stanza bloccata");
		assertEquals(sv, partita.getStanzaCorrente());
	}
 


}
