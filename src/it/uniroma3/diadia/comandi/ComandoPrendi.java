package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;



import it.uniroma3.diadia.*;
public class ComandoPrendi implements Comando{
	
	private String attrezzo;
	private IO IO;
	
	public ComandoPrendi(IO io){
		this.IO=io;
	}
	
	
	@Override
	public void esegui(Partita partita) {
			
			if(attrezzo==null ) {
				
				IO.mostraMessaggio("errore: scrivere il nome dell' ogetto da prendere");
				return;
			}
			
			if(!partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
				IO.mostraMessaggio("attrezzo non esistente nella stanza");
			}
				
			else {
				Attrezzo att= partita.getStanzaCorrente().getAttrezzo(this.attrezzo);
				if(partita.getGiocatore().getBorsa().getPeso()+ att.getPeso()<= partita.getGiocatore().getBorsa().getPesoMax()) {
					partita.getStanzaCorrente().removeAttrezzo(att);
					partita.getGiocatore().getBorsa().addAttrezzo(att);
					IO.mostraMessaggio("fatto");
				}
				else
					IO.mostraMessaggio("la tua borsa è troppo piena");
					
				
			}
			
	}
	
	@Override
	public void setParametro(String parametro) {
		this.attrezzo=parametro;
	}
}
