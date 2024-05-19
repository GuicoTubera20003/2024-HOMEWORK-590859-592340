package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;

public class ComandoNonValido implements Comando{
	private IO IO;
	
	public ComandoNonValido (IO IO) {
		this.IO= IO;
	}
	
	@Override
	public void esegui(Partita partita) {
		IO.mostraMessaggio("Comando non valido. Riprova");
	}
	
	@Override
	public void setParametro(String Parametro) {	
	}

}
