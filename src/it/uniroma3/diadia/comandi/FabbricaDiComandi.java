package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandi {
	
	private IO IO;
	
	public FabbricaDiComandi(IO Io) {
		this.IO= Io;
	}
	
	
	public Comando costruisciComando(String istruzione) {
		
			Scanner scannerDiParole= new Scanner (istruzione) ;
			String nomeComando = null;
			String parametro = null;
			Comando comando = null;
			
			
			if (scannerDiParole. hasNext ())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
			if (scannerDiParole.hasNext ())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
			
			if (nomeComando == null)
			comando = new ComandoNonValido (IO);
			
			else if (nomeComando.equals ("vai")) {
				comando = new ComandoVai (IO) ;
				comando.setParametro(parametro);
			}
			
			
			else if (nomeComando.equals ("prendi")) {
				comando = new ComandoPrendi (IO) ;
				comando.setParametro(parametro);
			}
			
			
			else if (nomeComando.equals ("posa")) {
			comando = new ComandoPosa (IO) ;
			comando.setParametro(parametro);
			}
			
			else if (nomeComando.equals ("aiuto") && parametro==null)
			comando = new ComandoAiuto (IO);
			
			else if (nomeComando.equals ("fine") && parametro==null)
			comando = new ComandoFine (IO);
			
			else if (nomeComando. equals ("guarda") )
			comando = new ComandoGuarda (IO) ;
			
			else comando = new ComandoNonValido (IO) ;
			comando.setParametro (parametro);
			
			return comando;
	}
}
