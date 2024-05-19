package it.uniroma3.diadia.test;

import static org.junit.Assert.*;
import java.util.*;

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
		pesante= new Attrezzo("pesante", 5);
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
		Attrezzo max= new Attrezzo ("max", 10);
		borsa.addAttrezzo(max);
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

	@Test
	public void testHasAttrezzo() {
		borsa.addAttrezzo(leggero);
		borsa.addAttrezzo(pesante);
		borsa.hasAttrezzo("pesante");
	}

	@Test
	public void TestgetContenutoOrdinatoPerPeso() {
		borsa.addAttrezzo(pesante);
		borsa.addAttrezzo(leggero);
		List<Attrezzo> p= borsa.getContenutoOrdinatoPerPeso();
		assertEquals(leggero,p.get(0));
		assertEquals(pesante,p.get(1));


	}
	

	@Test
	public void TestgetContenutoOrdinatoPerPesoUguale() {
		Attrezzo leggero1= new Attrezzo("A", 1);
		borsa.addAttrezzo(leggero);
		borsa.addAttrezzo(leggero1);
		List<Attrezzo> p= borsa.getContenutoOrdinatoPerPeso();
		assertEquals(leggero1,p.get(0));
		assertEquals(leggero,p.get(1));


	}
	
	

	@Test
	public void TestgetContenutoOrdinatoPerPesoConAttrezziGiaOrdinati() {
		Attrezzo leggero1= new Attrezzo("A", 4);
		borsa.addAttrezzo(leggero);
		borsa.addAttrezzo(leggero1);
		borsa.getContenutoOrdinatoPerPeso();
		assertEquals(leggero,borsa.getAttrezzi().get(0));
		assertEquals(leggero1,borsa.getAttrezzi().get(1));


	}
	
	
	
	
	@Test
	public void TestGetContenutoOrdinatoPerNome() {
		int r=0;
		Attrezzo a= new Attrezzo("a", 3);
		Attrezzo b= new Attrezzo("b", 1);
		Attrezzo c= new Attrezzo("c", 1);
		borsa.addAttrezzo(c);
		borsa.addAttrezzo(b);
		borsa.addAttrezzo(a);
		//funzione GetContenutoOrdinatoPerNome
		SortedSet<Attrezzo> s= borsa.GetContenutoOrdinatoPerNome();
		
		
		
		Attrezzo[] arr= new Attrezzo[3];
		s.toArray(arr);
		assertEquals(a, arr[0]);
		assertEquals(b, arr[1]);
		assertEquals(c, arr[2]);
		
		
	}
	
	
	
	@Test
	public void getContenutoRaggruppatoPerPeso() {
		
		Attrezzo a= new Attrezzo("a", 1);
		borsa.addAttrezzo(pesante);
		borsa.addAttrezzo(a);
		borsa.addAttrezzo(leggero);
		
		
		
		Map<Integer, Set<Attrezzo>> mp= borsa.getContenutoRaggruppatoPerPeso();
		assertNotNull(mp);
		Set<Attrezzo> p1= mp.get(1);
		assertTrue(p1.contains(leggero));
		assertTrue(p1.contains(a));
		assertFalse(p1.contains(pesante));
		Set<Attrezzo> p2= mp.get(5);
		assertTrue(p2.contains(pesante));
	}
	
	
	
	@Test
	public void getSortedSetOrdinatoPerPeso() {
		Attrezzo a= new Attrezzo ("a", 1);	
		borsa.addAttrezzo(leggero);
		borsa.addAttrezzo(a);
		
		SortedSet<Attrezzo> s= borsa.getSortedSetOrdinatoPerPeso();
		Attrezzo[] arr= new Attrezzo[5];
		s.toArray(arr);
		assertEquals(a, arr[0]);
		assertEquals(leggero, arr[1]);
	}
		
		
	
		
		
}
	
	
	
	
	
