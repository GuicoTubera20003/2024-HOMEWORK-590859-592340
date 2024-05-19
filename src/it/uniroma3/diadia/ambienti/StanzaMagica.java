package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	
	final static int SOGLIA_MAGICA_DEFAULT= 3;
	
	
	private int ContatoreAttrezziPosati;
	private int sogliamagica;
	
	
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public StanzaMagica(String nome, int sogliamagica) {
		super(nome);
		this.ContatoreAttrezziPosati=0;
		this.sogliamagica=sogliamagica;
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		return attrezzo;
		}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
	this.ContatoreAttrezziPosati++;
	
	if (this.ContatoreAttrezziPosati>this.sogliamagica)
		attrezzo = this.modificaAttrezzo(attrezzo);
	
	return super.addAttrezzo(attrezzo);
	}
	
	public Boolean isMagica() {
		return true;
	}
	
	
}
