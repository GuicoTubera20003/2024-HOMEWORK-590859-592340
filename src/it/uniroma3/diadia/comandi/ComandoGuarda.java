package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;

public class ComandoGuarda implements Comando{
	private IO IO;
	
	public ComandoGuarda(IO IO) {
		this.IO=IO;
	}
	
	@Override
	public void esegui(Partita partita) {
		IO.mostraMessaggio(partita.getStanzaCorrente().toString());
		IO.mostraMessaggio(partita.getGiocatore().toString());
		IO.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		}
	
	@Override
	public void setParametro(String parametro) {
		
	}
}
