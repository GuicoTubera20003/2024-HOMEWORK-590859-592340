package it.uniroma3.diadia.comandi;
import static org.junit.Assert.assertTrue;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	private String attrezzo;
	private IO IO;
	
	/*
	public ComandoPosa(IO IO) {
		this.IO=IO;
	}
	
	public void esegui (Partita partita) {
		if(partita.getStanzaCorrente().getNumeroAttrezzi()+1 > 10) {
			IO.mostraMessaggio("la stanza è piena");
			return;
		}
		if(attrezzo==null) {

			IO.mostraMessaggio("errore: scrivere il nome dell' ogetto da prendere");
			return;
		}
		if(partita.getGiocatore().getBorsa().isEmpty()) {
			IO.mostraMessaggio("errore: la tua borsa è vuota");
			return ;
		}
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
			IO.mostraMessaggio("errore: ogetto inesistnte nella borsa");
			return;
		}
		else {
			for(int i=0;i<partita.getGiocatore().getBorsa().getNumeroAttrezzi();i++) {
				if(partita.getGiocatore().getBorsa().getAttrezzi()[i].getNome().equals(attrezzo)) {
					partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzi()[i]);
					partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
					IO.mostraMessaggio(partita.getStanzaCorrente().toString());
				}
			}
		}
	}
	*/
	
	public ComandoPosa(IO IO) {
		this.IO=IO;
	}
	
	public void esegui (Partita partita) {
		if(partita.getStanzaCorrente().getNumeroAttrezzi()+1 > 10) {
			IO.mostraMessaggio("la stanza è piena");
			return;
		}
		if(attrezzo==null) {

			IO.mostraMessaggio("errore: scrivere il nome dell' ogetto da prendere");
			return;
		}
		if(partita.getGiocatore().getBorsa().isEmpty()) {
			IO.mostraMessaggio("errore: la tua borsa è vuota");
			return ;
		}
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
			IO.mostraMessaggio("errore: ogetto inesistnte nella borsa");
			return;
		}
		else {	
			Attrezzo att= partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
			partita.getStanzaCorrente().addAttrezzo(att);
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
			IO.mostraMessaggio(partita.getStanzaCorrente().toString());
			
		}
	}
	
	@Override
	public void setParametro(String parametro) {	
		this.attrezzo=parametro;
	}

}
