package gramatica;

import java.util.ArrayList;

/**
 * Class criada para guardar as regras de produção, onde temos uma regra que se refere a um caracter específico,
 * e temos um Arraylist(AlfabetoGerado) contento o alfabeto que pode ser substituído por este caracter da regra.
 * @author RafaelSene
 */
public class Regra {
	private String regra;
	private ArrayList<AlfabetoGerado> alfabetoGerado;
	
	/**
	 * Recebe uma String do usuário para a criação do Array. Nele criamos uma Matriz.
	 * Para cada regra temos vários alfabetos.
	 * Ex : X - abS
	 * 	X - a
	 * 	Y - b
	 * Em regra.get(Possicao).getRegra - temos:X(Possicao[0]) , Y(Possicao[1]).
	 * Em regra.get(Possicao).alfabetoGerado.get(Possicao).getAlfabeto - Em X(Possicao[0]) Temos: abS(Possicao[0]).
	 * Em regra.get(Possicao).alfabetoGerado.get(Possicao).getAlfabeto - Em X(Possicao[1]) Temos: a(Possicao[1]).
	 * Em regra.get(Possicao).alfabetoGerado.get(Possicao).getAlfabeto - EM Y(Possicao[1]) Temos: b(Possicao[0]).
	 * 
	 * @param regra recebe uma String.
	 */
	public Regra(String regra) {
		this.regra = regra;
		alfabetoGerado = new ArrayList<AlfabetoGerado>();
	}

	/**
	 * Pega a String guardada em uma posição.
	 * @return retorna uma String na posição.
	 */
	public String getRegra() {
		return regra;
	}

	/**
	 * Edita a regra em uma posição.
	 * @param regra String de substituição.
	 */
	public void setRegra(String regra) {
		this.regra = regra;
	}
	
	/**
	 * Adiciona um alfabeto referente a regra.
	 * @param entraAlfabeto String na qual você entra com o alfabeto e ele é guardado.
	 */
	public void addAlfabeto(String entraAlfabeto) {
		AlfabetoGerado alfabeto = new AlfabetoGerado(entraAlfabeto);
		this.alfabetoGerado.add(alfabeto);
	}
	
	/**
	 * Pega um alfabeto de um caracter específico referente a posição (i) passada.
	 * @param i posição passada.
	 * @return retorna a String(alfabedo guardado nequela possicao).
	 */
	public String pegarAlfabeto(int i) {
		String alfabeto;
		alfabeto =  this.alfabetoGerado.get(i).getAlfabeto();
		return alfabeto;
	}
	
	/**
	 * Retorna o tamanho do alfabeto que um caracter específico pode gerar.
	 * @return retorna tamanho (int).
	 */
	public int tamanho(){
		int tam = alfabetoGerado.size();
		return tam;
	}
}
