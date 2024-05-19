package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Scanner;

public class IOSimulator implements IO{
	private ArrayList<String> righeDaLeggere;
	private ArrayList<String> messaggiProdotti;

	@Override
	public void mostraMessaggio(String messaggio) {
		if(this.righeDaLeggere.contains(messaggio)) {
			int i= righeDaLeggere.indexOf(messaggio);
			this.messaggiProdotti.add(this.righeDaLeggere.remove(i));
		}
		return;
		
	}

	@Override
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		this.righeDaLeggere.add(riga);
		return riga;
	}
	
}
