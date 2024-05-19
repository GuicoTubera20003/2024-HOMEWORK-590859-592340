package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private IO IO;
	
	public ComandoVai( IO IO) {

		this.IO=IO;
	}
	
	
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	
	@Override
	public void esegui(Partita partita) {
			Stanza stanzaCorrente = partita.getStanzaCorrente ();
			Stanza prossimaStanza = null;
			if (direzione==null) {
			IO.mostraMessaggio("Dove vuoi andare? "
					+ "Devi specificare una direzione");
			return;
			}
			
			prossimaStanza = stanzaCorrente.getStanzaAdiacente (this.direzione);
			if (prossimaStanza==null) {
				IO.mostraMessaggio("Direzione inesistente");
			return ;
			}
			
			
			partita.setStanzaCorrente (prossimaStanza) ;
			IO.mostraMessaggio(partita.getStanzaCorrente ().getNome ()) ;
			partita.getGiocatore ().setCfu(partita.getGiocatore ().getCfu () -1);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}

}