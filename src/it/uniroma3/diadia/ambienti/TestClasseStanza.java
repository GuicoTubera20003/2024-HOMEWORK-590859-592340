package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestClasseStanza {
	
	Stanza r1= new Stanza("r1");
	Stanza r2= new Stanza("r2");
	Stanza r3= new Stanza("r3");
	Stanza r4= new Stanza("r4");
	Stanza r5= new Stanza("r5");
	Stanza r6= new Stanza("r6");
	
	
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
	
	
	
	
	Attrezzo martello= new  Attrezzo("martello", 5);
	Attrezzo koko= new Attrezzo("koko", 12);

	
	//Test sul metodo hasAttrezzo 
	
	@Test
	public void testHasAttrezzoConAttrezzoInesistente() {
		assertFalse(r1.hasAttrezzo("koko"));
	}
	
	@Test
	public void testHasAttrezzoNull() {
		r1.addAttrezzo(null);
		assertFalse(r1.hasAttrezzo(null));
	}
	
	@Test
	public void testHasAttrezzo() {	
		r1.addAttrezzo(martello);
		assertTrue(r1.hasAttrezzo("martello"));
		
	}


	
	//Test sul metodo removeAttrezzo
	
	@Before
	public void insert() {
		if(!r1.hasAttrezzo("martello"))
			r1.addAttrezzo(martello);
	}
	
	@Test
	public void testRemoveAttrezzoNull() {		
		assertFalse(r1.removeAttrezzo(null));
		
	}
	
	@Test
	public void testRemoveAttrezzo() {
		assertTrue(r1.removeAttrezzo(martello));
	
	}
	
	@Test
	public void testRemoveAttrezzoInesistente() {
		assertFalse(r1.removeAttrezzo(koko));
		
	}
	
	
	
	
	

}
