package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;

public class ComandoAiuto implements Comando{
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private IO IO;
	
	
	public ComandoAiuto(IO IO) {
		this.IO= IO;
	}
	
	

	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			IO.mostraMessaggio(elencoComandi[i]);
		IO.mostraMessaggio("");
	}
	
	@Override
	public void setParametro(String Parametro) {	
	}
}
