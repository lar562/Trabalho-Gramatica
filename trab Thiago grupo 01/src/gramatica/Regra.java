package gramatica;

import java.util.ArrayList;

public class Regra {
	private String regra;
	private ArrayList<AlfabetoGerado> alfabetoGerado;
	
	public Regra(String regra) {
		this.regra = regra;
		alfabetoGerado = new ArrayList<AlfabetoGerado>();
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}
	
	public void addAlfabeto(String alfabetoGerado) {
		AlfabetoGerado alfabeto = new AlfabetoGerado(alfabetoGerado);
		this.alfabetoGerado.add(alfabeto);
	}
	
	public String pegarAlfabeto(int i) {
		String alfabeto;
		alfabeto =  this.alfabetoGerado.get(i).getAlfabeto();
		return alfabeto;
	}

}
