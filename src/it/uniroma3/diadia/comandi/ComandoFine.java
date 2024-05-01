package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;

public class ComandoFine implements Comando{
	
	private IO IO;
	

	
 	public ComandoFine(IO IO) {
 		this.IO= IO;
 	}
	
 	@Override
 	public void esegui(Partita partita) {
 		IO.mostraMessaggio("Grazie di aver giocato!");
 	}
 	
 	@Override
	public void setParametro(String Parametro) {	
	}

}
