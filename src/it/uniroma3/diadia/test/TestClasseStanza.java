package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestClasseStanza {
	
	private Stanza r1;
	Stanza r2;
	Stanza r3;
	Stanza r4;
	Stanza r5;
	Stanza r6;
	Attrezzo martello;
	Attrezzo koko;
	
	@Before
	public void setup1() {
		r1= new Stanza("r1");
		r2= new Stanza("r2");
		r3= new Stanza("r3");
		r4= new Stanza("r4");
		r5= new Stanza("r5");
		r6= new Stanza("r6");
	}
	
	@Test
	public void testimpostaStanzaAdiacenteConStanzaDiPartenzaSenzaAdiacenti() {
		
		r1.impostaStanzaAdiacente("nord", r2);
		
		assertSame("errore",r2, r1.getStanzaAdiacente("nord"));
		
		
	}
	
	@Test
	public void testimpostaStanzaAdiacenteInUnaAdiacenzaGiaOccupata() {
		
		r1.impostaStanzaAdiacente("nord", r3);
		assertEquals( "errore",r3, r1.getStanzaAdiacente("nord"));		
	}
	
	
	@Test  
	public void testimpostaStanzaAdiacenteConStanzaCorrenteConDirezioniPiene() {
		
		r1.impostaStanzaAdiacente("nord", r2);
		r1.impostaStanzaAdiacente("sud", r3);
		r1.impostaStanzaAdiacente("est", r4);
		r1.impostaStanzaAdiacente("ovest", r5);
		
		r1.impostaStanzaAdiacente("sud ovest", r6);
		assertNull(r1.getStanzaAdiacente("sud ovest"));

	}
	
	
	
	

	
	
	//Test su HasAttrezzo

	
	@Test 
	public void testHasAttrezzoNUll() {
		assertFalse(r1.hasAttrezzo(null));
	}
	
	
	@Test
	public void TestHasAttrezzoConAttrezzoNONEsistente() {
		
		this.martello= new Attrezzo ("martello", 5);
		this.koko= new Attrezzo("koko", 2);
		assertTrue(this.r1.addAttrezzo(koko));
		assertFalse(this.r1.hasAttrezzo("martello"));
	}
	
	
	@Test
	public void TestHasAttrezzoConAttrezzoEsistente() {
		

		this.koko= new Attrezzo("koko", 2);
		assertTrue(this.r1.addAttrezzo(koko));
		assertTrue(this.r1.hasAttrezzo("koko"));
	}
	
	
	
	
	//Test sul metodo removeAttrezzo
	

	
	@Test
	public void testRemoveAttrezzoNull() {
		assertFalse(r1.removeAttrezzo(null));
		
	}
	
	@Test
	public void testRemoveAttrezzo() {
		this.martello= new Attrezzo ("martello", 5);
		this.r2.addAttrezzo(this.martello);
		assertTrue(r2.removeAttrezzo(this.martello));
		
		
	}
	
	@Test
	public void testRemoveAttrezzoInesistente() {
		this.koko= new Attrezzo ("koko", 1);
		assertFalse(r2.removeAttrezzo(koko));
	}
	
	
	@Test
	public void testGEtAttrezzo() {
		this.martello= new Attrezzo("martello", 3);
		this.r3.addAttrezzo(martello);
		assertSame(martello, r3.getAttrezzo("martello"));
	}
	

	
	
	
	
	
	

}
