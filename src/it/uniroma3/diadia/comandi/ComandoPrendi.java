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
				for (int i=0; i<partita.getStanzaCorrente().getNumeroAttrezzi(); i++) {
					Attrezzo a= partita.getStanzaCorrente().getAttrezzi()[i];
					if(a.getNome().equals(this.attrezzo)) {
						if(partita.getGiocatore().getBorsa().getPeso() + a.getPeso() >=partita.getGiocatore().getBorsa().getPesoMax()) {
							IO.mostraMessaggio("la borsa è troppo piena per prendere questo attrezzo");
						}
						if(partita.getGiocatore().getBorsa().addAttrezzo(a)) {
							partita.getStanzaCorrente().removeAttrezzo(a);
							IO.mostraMessaggio("fatto");
							IO.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
							IO.mostraMessaggio(partita.getStanzaCorrente().toString());
							}
						
					}
					else
						IO.mostraMessaggio("non c'è oggetto richiesto");
					
				}
			}
			
	}
	
	@Override
	public void setParametro(String parametro) {
		this.attrezzo=parametro;
	}
}
