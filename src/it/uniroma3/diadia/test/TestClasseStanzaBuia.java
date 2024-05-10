package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestClasseStanzaBuia {
	
	private StanzaBuia sb;
	private Attrezzo luce;
	
	@Before
	public void setup() {
		this.sb= new StanzaBuia("sb", "luce");
		this.luce= new Attrezzo("luce", 1);
	}
		
	@Test
	public void StanzaBuiaSenzaLuce (){
		assertEquals(sb.getDescrizione(), "qui c'è buio pesto");
		
	}
	
	@Test
	public void StanzaBuiaConLuce (){
		sb.addAttrezzo(luce);
		assertNotEquals("qui c'è buio pesto",sb.getDescrizione());
		assertNotNull(sb.getDescrizione());
		
	}
	

}
