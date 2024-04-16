package it.uniroma3.diadia;





import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole IO;



	public DiaDia(IOConsole IO) {
		this.partita = new Partita();
		this.IO= IO;
 
	}

	public void gioca() {
		String istruzione; 
		IO.mostraMessaggio(MESSAGGIO_BENVENUTO);

		
		
		do		
			istruzione= IO.leggiRiga();
		while (!processaIstruzione(istruzione, this.IO));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione, IOConsole IO) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
	
		if(istruzione.isEmpty()) {
			IO.mostraMessaggio("comando sconosciuto");
			return false;
			
		}
		else { 
			
			if(comandoDaEseguire.getNome().equals("posa")) {
				this.posare(comandoDaEseguire.getParametro());
				return false;
			}
			
			if(comandoDaEseguire.getNome().equals("prendi")) {
				this.prendere(comandoDaEseguire.getParametro());
				return false;
			}
			
			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine(); 
				return true;
			} else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
			else
				IO.mostraMessaggio("comando sconosciuto");
			if (this.partita.vinta()) {
				IO.mostraMessaggio("hai vinto!");
				return true;
			} else
				return false;
		}
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			IO.mostraMessaggio(elencoComandi[i]);
		IO.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			IO.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			IO.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.giocatore.getCfu();
			this.partita.giocatore.setCfu(cfu--);
		}
		IO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		IO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	
	
	private void prendere(String attrezzo) {
		if(attrezzo==null ) {
			
			IO.mostraMessaggio("errore: scrivere il nome dell' ogetto da prendere");
			return;
		}
		
		if(!partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			IO.mostraMessaggio("attrezzo non esistente nella stanza");
		}
			
		else {
			for (int i=0; i<partita.getStanzaCorrente().getNumeroAttrezzi(); i++) {
				if(partita.getStanzaCorrente().getAttrezzi()[i].getNome().equals(attrezzo)) {
					if(partita.giocatore.getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzi()[i])) {
						partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzi()[i]);
						IO.mostraMessaggio("fatto");
						IO.mostraMessaggio(partita.giocatore.getBorsa().toString());
						IO.mostraMessaggio(partita.getStanzaCorrente().toString());
						}
				}
				else
					IO.mostraMessaggio("non c'è oggetto richiesto");
				
			}
		}
		
	}
	
	
	private void posare(String attrezzo) {
		
		if(partita.getStanzaCorrente().getNumeroAttrezzi()+1 > 10) {
			IO.mostraMessaggio("la stanza è piena");
			return;
		}
		if(attrezzo==null) {

			IO.mostraMessaggio("errore: scrivere il nome dell' ogetto da prendere");
			return;
		}
		if(partita.giocatore.getBorsa().isEmpty()) {
			IO.mostraMessaggio("errore: la tua borsa è vuota");
			return ;
		}
		if(!partita.giocatore.getBorsa().hasAttrezzo(attrezzo)) {
			IO.mostraMessaggio("errore: ogetto inesistnte nella borsa");
			return;
		}
		else {
			for(int i=0;i<partita.giocatore.getBorsa().getNumeroAttrezzi();i++) {
				if(partita.giocatore.getBorsa().getAttrezzi()[i].getNome().equals(attrezzo)) {
					partita.getStanzaCorrente().addAttrezzo(partita.giocatore.getBorsa().getAttrezzi()[i]);
					partita.giocatore.getBorsa().removeAttrezzo(attrezzo);
					IO.mostraMessaggio(partita.getStanzaCorrente().toString());
				}
			}
		}
		
	}

	public static void main(String[] argc) {
		
		IOConsole IO=new IOConsole();
		DiaDia gioco = new DiaDia(IO);
		gioco.gioca();
	}
}