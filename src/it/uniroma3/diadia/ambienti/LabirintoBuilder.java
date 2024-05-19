package it.uniroma3.diadia.ambienti;

import java.util.HashMap;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto {
	private Stanza StanzaSupporto;			//vaariabile che serve per memorizzare l'ulitma stanza aggiunta
	private HashMap<String, Stanza> stanzeLabirinto;


	public LabirintoBuilder() {
		super();
		this.stanzeLabirinto= new HashMap<>();

	}


	public LabirintoBuilder addStanzaIniziale(String nome) {
		if(!this.stanzeLabirinto.containsKey(nome)) {
			this.StanzaSupporto= new Stanza(nome);
			super.setIniziale(this.StanzaSupporto);
			this.stanzeLabirinto.put(nome, StanzaSupporto);
		}
		else {
			super.setIniziale(this.stanzeLabirinto.get(nome));
		}
		return this;

	}


	public LabirintoBuilder addStanzaVincente(String nome) {
		if(this.StanzaSupporto.getNome().equals(nome))
			super.setFinale(this.StanzaSupporto);
		else {
			this.StanzaSupporto= new Stanza(nome);
			super.setFinale(StanzaSupporto);
			this.stanzeLabirinto.put(nome, StanzaSupporto);
		}
		return this;

	}

	public LabirintoBuilder  addAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo att= new Attrezzo(nomeAttrezzo, peso);
		if(!super.getAttrezzi().contains(att)) {
			super.getAttrezzi().add(att);
			this.StanzaSupporto.addAttrezzo(att);
		}

		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, String direzione) {
		Stanza s= this.stanzeLabirinto.get(stanzaCorrente);
		if(this.stanzeLabirinto.containsKey(stanzaAdiacente)) {
			s.impostaStanzaAdiacente(direzione, this.stanzeLabirinto.get(stanzaAdiacente));
		}

		
		return this;
	}
	
 
	
	
	public LabirintoBuilder addStanza(String nome) {
		if(!this.stanzeLabirinto.containsKey(nome)) {
			this.StanzaSupporto= new Stanza(nome);
			this.stanzeLabirinto.put(nome, StanzaSupporto);
		}
	
		return this;
	}
	
	
	
	public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
		if(!this.stanzeLabirinto.containsKey(nome)) {
			this.StanzaSupporto= new StanzaMagica(nome, soglia);
			this.stanzeLabirinto.put(nome, StanzaSupporto);
		}
		
		return this;
	}
	
	
	public LabirintoBuilder addStanzaBloccata(String nome,  String direzioneBloccata, String chiave) {
		if(!this.stanzeLabirinto.containsKey(nome)) {
			this.StanzaSupporto= new StanzaBloccata(nome, direzioneBloccata, chiave);
			this.stanzeLabirinto.put(nome, StanzaSupporto);
		}
		
		return this;
	}
	
	
	public LabirintoBuilder addStanzaBuia(String nome, String oggettoIlluminante) {
		if(!this.stanzeLabirinto.containsKey(nome)) {
			this.StanzaSupporto= new StanzaBuia(nome, oggettoIlluminante);
			this.stanzeLabirinto.put(nome, StanzaSupporto);
		}
		return this;
	}
	
	
	
	
	
	
	/*
	 * funzioni get
	 */
	public HashMap<String, Stanza> getListaStanze(){
		return this.stanzeLabirinto;
	}
	
	
	@Override
	public Labirinto getLabirinto() {
		return super.getLabirinto();
	}
}







