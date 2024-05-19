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
	private Labirinto labirinto;
	private boolean finita;
	private Giocatore giocatore;
	
	
	
	public Partita(Labirinto labirinto){

		this.finita = false;
		giocatore= new Giocatore();
		this.labirinto= labirinto;
		stanzaCorrente= labirinto.getIniziale();
	}
	
	
 	public void setStanzaCorrente(Stanza corrente ) {
 		
 		this.stanzaCorrente= corrente;
 		
 	}
 	
 	
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	



	public boolean giocatoreIsVivo() {
		if (giocatore.getCfu()>0)
			return true;
		
		return false;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}


	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
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
