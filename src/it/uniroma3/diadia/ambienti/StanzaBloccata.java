package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	

	private String direzioneBloccata;
	private String oggetoSbloccante;

	public StanzaBloccata(String nome, String direzioneBloccata, String oggetoSbloccante) {
		super(nome);
		// TODO Auto-generated constructor stub
		this.direzioneBloccata=direzioneBloccata;
		this.oggetoSbloccante= oggetoSbloccante;
		
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		
		
		Stanza out= this;
		
		if(this.hasAttrezzo(this.oggetoSbloccante)) {
			
			out=super.getStanzaAdiacente(dir);
		}
		
		return out;
		
	}
	
	@Override 
	public String getDescrizione(){
		
		String sup= super.getDescrizione();
		StringBuilder risultato = new StringBuilder();
		
		if(!this.hasAttrezzo(this.oggetoSbloccante)) {
			risultato.append(sup);
			risultato.append("la direzione " + this.direzioneBloccata + " è bloccata\n");
			risultato.append("è necessario questo oggetto: "+ this.oggetoSbloccante);
				
		}
		
    	return risultato.toString();
		
		
	}
	

}
