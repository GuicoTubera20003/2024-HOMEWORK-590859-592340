package it.uniroma3.diadia.ambienti;

import java.util.*;
import java.util.Set;


import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;


	private String nome;
	private ArrayList<Attrezzo> attrezzi;
	private Map<String, Stanza> stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	private ArrayList<String> direzioni;


	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.direzioni = new ArrayList<>( NUMERO_MASSIMO_DIREZIONI );
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new ArrayList<Attrezzo>();


	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		if(this.numeroStanzeAdiacenti<4 && (direzione.equals("nord") || direzione.equals("sud") || direzione.equals("est") || direzione.equals("ovest")) ) { 
			stanzeAdiacenti.put(direzione, stanza);
			this.numeroStanzeAdiacenti++;
			direzioni.add(direzione);
		}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return stanzeAdiacenti.get(direzione);

	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public ArrayList<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null) {
			return this.attrezzi.add(attrezzo);
		}
		return false;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.direzioni)
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) {

			if(attrezzo!=null)
				risultato.append(attrezzo.toString()+" ");
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */

	/*
    public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;

		for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo!=null && attrezzo.getNome().equals(nomeAttrezzo))
					trovato = true;
			return trovato;
		}
		return trovato;

	}
	 */

	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;

		for(Attrezzo a: this.attrezzi) {
			if(a!=null && a.getNome().equals(nomeAttrezzo))
				trovato= true;
		}
		return trovato;
	}


	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */


	// QUETSA VERSIONE MI CREA PROBLEMI

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;

		if(nomeAttrezzo!=null) {
			for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo!=null && attrezzo.getNome().equals(nomeAttrezzo))
					attrezzoCercato = attrezzo;
			}
		}
		return attrezzoCercato;	


	}


	/*
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;

		if(nomeAttrezzo!=null) {
			for (int i=0; i<this.numeroAttrezzi;i++) {
				if (this.getAttrezzi()[i].getNome().equals(nomeAttrezzo))
					attrezzoCercato = this.getAttrezzi()[i];
			}
		}
		return attrezzoCercato;	


	}
	 */
	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		// TODO da implementare
		boolean supp=false;

		if(attrezzo!=null) {
			return this.attrezzi.remove(attrezzo);		
		}
		return supp;

	}


	public ArrayList<String> getDirezioni() {
		ArrayList<String> dir = new ArrayList<>(this.numeroStanzeAdiacenti);
		for(int i=0; i<this.numeroStanzeAdiacenti; i++) {
			dir.add(this.direzioni.get(i));
		}
		return dir;
	}
	
	
	public Map<String, Stanza>  getMapStanzeAdiacenti(){
		return this.stanzeAdiacenti;
	}

	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}

	
	
	@Override
	public boolean equals(Object o) {
		Stanza that= (Stanza) o;
		return this.getNome().equals(that.getNome());
	}


}