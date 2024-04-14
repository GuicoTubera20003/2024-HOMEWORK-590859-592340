package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

/*import org.junit.Before;*/
import org.junit.Test;

/*import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;*/

public class TestClasseGiocatoreTest {
	
	Giocatore giocatore= new Giocatore();
	Borsa borsa= new Borsa();
	
	
	@Test
	public void testGetCon5Cfu(){
		giocatore.setCfu(5);
		assertEquals(5, giocatore.getCfu());
	}
	
	@Test
	public void testGetConTuttiCfu(){
		assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	public void testgetBorsa(){
		
	}
	

}
