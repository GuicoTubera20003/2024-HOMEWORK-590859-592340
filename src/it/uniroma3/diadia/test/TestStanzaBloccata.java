package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBloccata {
	
	private Attrezzo x;
	private Attrezzo chiave;
	private Stanza Snord;
	private StanzaBloccata sb;
	
	
	
	@Before
	public void setup() {
		this.Snord= new Stanza("Snord");
		this.chiave= new Attrezzo ("chiave", 1);
		this.x= new Attrezzo("x", 1);
		
	}
	
	@Test
	public void TestClasseStanzeBloccataConStanzaBloccataDirezioneNUlla() {
		this.sb= new StanzaBloccata("sb", null, "chiave");
		assertEquals(this.sb, sb.getStanzaAdiacente(null));
	}
	
	@Test
	public void TestClasseStanzeBloccataConStanzaBloccataConDirezioneUnaStanzaInestistente() {
		this.sb= new StanzaBloccata("sb", "nord", "chiave");
		sb.addAttrezzo(this.chiave);
		assertNull( sb.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void TestClasseStanzeBloccataConStanzaBloccataSenzaChiave() {
		this.sb= new StanzaBloccata("sb", "nord", "chiave");
		sb.addAttrezzo(this.x);
		sb.impostaStanzaAdiacente("nord", Snord);
		assertEquals(this.sb, sb.getStanzaAdiacente("nord"));
		}
	
	@Test
	public void TestClasseStanzeBloccataConStanzaBloccataSenzaConChiaive() {
		this.sb= new StanzaBloccata("sb", "nord", "chiave");
		sb.impostaStanzaAdiacente("nord", Snord);
		sb.addAttrezzo(this.chiave);
		assertEquals(this.Snord, sb.getStanzaAdiacente("nord"));
		
		
	}
	
	
	
}
