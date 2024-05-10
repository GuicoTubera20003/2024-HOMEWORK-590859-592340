package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaMagica {
	
	private StanzaMagica sm;
	private Attrezzo ab;
	
	@Before
	public void setup() {
		this.sm= new StanzaMagica("sm");
	}

	@Test
	public void testAttrezzoNullsenzaMagia() {
		this.ab=null;
		this.sm.addAttrezzo(ab);
		assertNull(sm.getAttrezzo(null));
	}
	
	@Test
	public void TestStanzaMagicaaConAttrezzo_primaDellaMagia() {
		this.ab= new Attrezzo("ab", 2);
		this.sm.addAttrezzo(ab);
		assertTrue(sm.hasAttrezzo("ab"));
	}
	
	@Test
	public void TestStanzaMagicaaConAttrezzo_dopoLaMagia() {
		this.ab= new Attrezzo("ab", 2);
		this.sm.addAttrezzo(ab);
		this.sm.addAttrezzo(ab);
		this.sm.addAttrezzo(ab);
		this.sm.addAttrezzo(ab);
		assertTrue(sm.hasAttrezzo("ba"));
	}

}
