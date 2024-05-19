package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;

import java.util.*;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private ArrayList<Attrezzo> attrezzi;
	private int pesoMax;


	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi= new ArrayList<Attrezzo>();
	}


	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;

		this.attrezzi.add(attrezzo);
		return true;
	}


	public int getPesoMax() {
		return pesoMax;
	}



	public Attrezzo getAttrezzo(String nomeAttrezzo) {

		for(Attrezzo E: this.attrezzi) {
			if(E!=null && E.getNome().equals(nomeAttrezzo)) {
				return E;
			}
		}

		return null;
	}



	public int getPeso() {
		int peso = 0;
		for (Attrezzo E: this.attrezzi) {
			peso= peso+ E.getPeso();
		}
		return peso;
	}


	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}

	/*
		public void setNumeroAttrezzi(int numeroAttrezzi) {
			this.numeroAttrezzi = numeroAttrezzi;
		}
	 */

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		if(nomeAttrezzo!=null)
			return this.getAttrezzo(nomeAttrezzo)!=null;

		return false;
	}


	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {

				iteratore.remove();
				return a;
			}
		}
		return null;
	}




	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo E: this.attrezzi)
				s.append(E.toString()+" ");


		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}



	/*
	 * Ritorna un riferimento all' arrayList che contiene gi attrezzi contenuti nella borsa
	 */
	public ArrayList<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}



	public void setAttrezzi(Attrezzo[] attrezzi) {

		for(Attrezzo e:attrezzi) {
			if(e!=null)
				this.attrezzi.add(e);
		}
	}



	//funzione che ordina la lista secondo il peso ( secondo il nome se di peso uguale)
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){

		List<Attrezzo> out= new ArrayList<Attrezzo>(this.attrezzi);
		ComparatorePerPeso  cpp= new ComparatorePerPeso ();
		Collections.sort(out, cpp);
		StringBuilder s= new StringBuilder();
		s.append("[");
		for(Attrezzo a: out) {
			if(a!=null) {
				s.append(a.getNome() + ",");
			}
		}
		s.deleteCharAt(s.length()-1);
		s.append("]");
		System.out.println(s.toString());
		return out;

	}



	//funzione che ordina la lista secondo il nome
	public SortedSet<Attrezzo>  GetContenutoOrdinatoPerNome(){
		ComparatorePerNome cpp= new ComparatorePerNome();
		SortedSet<Attrezzo> sd= new TreeSet<Attrezzo>(cpp);
		sd.addAll(this.attrezzi);

		StringBuilder s= new StringBuilder();
		s.append("{");
		for(Attrezzo a: sd) {
			if(a!=null)
				s.append(a.getNome() + ",");
		}
		s.append("}");
		s.deleteCharAt(s.length()-2);
		System.out.println(s.toString());

		return sd;

	}



	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		ComparatorePerNome c= new ComparatorePerNome();

		Map<Integer,Set<Attrezzo>>  out= new TreeMap<Integer,Set<Attrezzo>> ();
		List<Attrezzo> listaOrdinata= this.getContenutoOrdinatoPerPeso();	

		int peso= listaOrdinata.get(0).getPeso();
		int i=0;
		while(i<listaOrdinata.size()) {
			Set<Attrezzo> supporto= new  TreeSet<>(c); 
			//Attrezzo s= listaOrdinata.get(i);
			while(i < listaOrdinata.size() && listaOrdinata.get(i).getPeso() == peso) {
				supporto.add(listaOrdinata.get(i));
				i++;
			}
			out.put(peso, supporto);

			if(i<listaOrdinata.size())
				peso=listaOrdinata.get(i).getPeso();

		}
		
		//ritorna una rappresentazione della mappa
		StringBuilder s= new StringBuilder();
		for(int j=0;j<= this.pesoMax; j++) {
			if(out.containsKey(j)) {

				//si crea una stringa che contiene la lista dei attrezzi dello stesso peso
				StringBuilder qu= new StringBuilder();
				for(Attrezzo att: out.get(j)) {
					if(att!=null)
						qu.append(att.getNome()+",");
				}
				qu.deleteCharAt(qu.length()-1);


				s.append("(" + j + "," + "{" + qu + "}" + ")" + ";");
				
			}
			
			

		}
		s.deleteCharAt(s.length()-1);
		System.out.println(s.toString());


		return out;
	}
	
	
	
	
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatorePerPeso cp= new ComparatorePerPeso();
		SortedSet<Attrezzo> out= new TreeSet<>(cp);
		out.addAll(this.attrezzi);
		
		return out;
	}

	//Tipo di e è la super classe in comune di e



}

