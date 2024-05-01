package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class TestClasseBorsaTest {
	Borsa borsa;
	Attrezzo leggero;
	Attrezzo pesante;
	
	@Before
	public void SetUp1() { 
		borsa=new Borsa();
		leggero= new Attrezzo("leggero", 1);
		pesante= new Attrezzo("pesante", 10);
	}
	
	/*
	 * Test relativi al metodo addAttrezzo
	 */
	//caso in cui si passa null
	@Test
	public void testAddAttrezzoNull() {
		
		assertFalse(borsa.addAttrezzo(null));
		
	}
	
	//caso in cui si passa un oggetto con peso accettabile
	@Test
	public void testAddAttrezzo() {
		assertTrue(borsa.addAttrezzo(leggero));
	}
	
	
	//caso in cui si cerca di aggiunfere un attrezzo con una borsa piena	
	@Test
	public void testAddAttrezzoConBorsaPiena() {
		borsa.addAttrezzo(pesante);
		assertFalse(borsa.addAttrezzo(leggero));
	}
	
	
	
	/*
	 * Test relativi al metodo removeAttrezzo
	 */
	
	
	@Test
	public void removeAttrezzoNull() {
		
		assertNull(borsa.removeAttrezzo(null));
	}
	
	
	@Test
	public void removeAttrezzoContenutoNellaBorsa () {
		borsa.addAttrezzo(leggero);
		assertEquals(leggero, borsa.removeAttrezzo(leggero.getNome()));
	}
	
	@Test
	public void removeAttrezzoNonCOntenutoNellBorsa() {
		borsa.addAttrezzo(pesante);
		assertNull(borsa.removeAttrezzo(leggero.getNome()));
	}
}
