package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
	

	final static int SOGLIA_MAGICA_DEFAULT= 3;
	
	
	private int ContatoreAttrezziPosati;
	private int sogliamagica;
	
	
	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public StanzaMagicaProtected(String nome, int sogliamagica) {
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
	if (this.ContatoreAttrezziPosati > this.sogliamagica)
	attrezzo = this.modificaAttrezzo(attrezzo);
	if (this.numeroAttrezzi<this.attrezzi.length) {
	this.attrezzi[this.numeroAttrezzi] = attrezzo;
	this.numeroAttrezzi++;
	}
	return true;

		
	}
}
