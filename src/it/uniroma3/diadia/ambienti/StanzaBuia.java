package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String oggettoPerVedere;		//memorizza il nome dell' attrezzo che permette di visuallizare 
											//la descrizione della stanza

	public StanzaBuia(String nome, String oggettoPerVedere) {
		super(nome);
		this.oggettoPerVedere=oggettoPerVedere;
	}
	
	
	@Override
	public String getDescrizione(){
		String out;
		
		if(this.hasAttrezzo(oggettoPerVedere))
			out=this.toString();
		else
			out= "qui c'è buio pesto";
		
		
		return out;
	}
	
	
}
