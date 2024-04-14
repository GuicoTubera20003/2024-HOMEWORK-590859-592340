package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	
	
	private Stanza stanzaCorrente;
	public Labirinto labirinto=new Labirinto();
	boolean finita;
	public Giocatore giocatore;
	
	
	
	public Partita(){

		this.finita = false;
		giocatore= new Giocatore();
		labirinto.creaStanze();
		stanzaCorrente= labirinto.getIniziale();
	}
	
	
 	public void setStanzaCorrente(Stanza corrente ) {
 		
 		this.stanzaCorrente= corrente;
 		
 	}
 	
 	
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	





	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.stanzaCorrente== labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}
	


	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}


}
