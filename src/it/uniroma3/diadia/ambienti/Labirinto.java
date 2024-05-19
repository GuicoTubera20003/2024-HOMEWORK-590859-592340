package it.uniroma3.diadia.ambienti;

import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;

public class Labirinto {
	
	private Stanza iniziale;
	private Stanza finale;
	private TreeSet<Attrezzo> attrezzi;

	
	
	public Labirinto() {
		ComparatorePerNome cpp= new ComparatorePerNome();
		this.iniziale=null;
		this.finale=null;
		this.attrezzi= new TreeSet<Attrezzo>(cpp);
	}
	
	

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
 
	
	 public void creaStanze() {

			/* crea gli attrezzi */
	    	Attrezzo lanterna = new Attrezzo("lanterna",3);
			Attrezzo osso = new Attrezzo("osso",1);
	    	
			/* crea stanze del labirinto */
			Stanza atrio = new Stanza("Atrio");
			Stanza aulaN11 = new Stanza("Aula N11");
			Stanza aulaN10 = new Stanza("Aula N10");
			Stanza laboratorio = new Stanza("Laboratorio Campus");
			Stanza biblioteca = new Stanza("Biblioteca");
			
			/* collega le stanze */
			atrio.impostaStanzaAdiacente("nord", biblioteca);
			atrio.impostaStanzaAdiacente("est", aulaN11);
			atrio.impostaStanzaAdiacente("sud", aulaN10);
			atrio.impostaStanzaAdiacente("ovest", laboratorio);
			aulaN11.impostaStanzaAdiacente("est", laboratorio);
			aulaN11.impostaStanzaAdiacente("ovest", atrio);
			aulaN10.impostaStanzaAdiacente("nord", atrio);
			aulaN10.impostaStanzaAdiacente("est", aulaN11);
			aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
			laboratorio.impostaStanzaAdiacente("est", atrio);
			laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
			biblioteca.impostaStanzaAdiacente("sud", atrio);

	        /* pone gli attrezzi nelle stanze */
			aulaN10.addAttrezzo(lanterna);
			atrio.addAttrezzo(osso);

			// il gioco comincia nell'atrio
	       
			this.iniziale= atrio;
			this.finale= biblioteca;
			
	    }
	 

	
	 

		public Stanza getIniziale() {
			return iniziale;
		}


		public void setIniziale(Stanza iniziale) {
			this.iniziale = iniziale;
		}


		public Stanza getFinale() {
			return finale;
		}


		public void setFinale(Stanza finale) {
			this.finale = finale;
		}
		
	

		public Stanza getStanzaVincente() {
			return this.finale;
		}
		
		
		public boolean contains(Attrezzo a) {
			if(this.attrezzi.contains(a))
				return true;
			
			return false;
		}

		public  Labirinto getLabirinto() {
			return this;
		}





		public TreeSet<Attrezzo> getAttrezzi() {
			return attrezzi;
		}





	
		

}