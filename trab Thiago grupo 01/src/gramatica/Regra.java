package gramatica;

import java.util.ArrayList;

/**
 * Class criada para guarda regras de producao onde temos uma regra que referece a um caracter espesifico
 * e temos um Arraylist(AlfabetoGerado) contento o alfabeto que pode ser substituido por este caracter da regra.
 * @author RafaelSene
 */
public class Regra {
	private String regra;
	private ArrayList<AlfabetoGerado> alfabetoGerado;
	
	/**
	 * Recebe uma String do usuario para criacao do Array nele criamos uma Matriz.
	 * Para cada regra temos varios alfabetos.
	 * Ex : X - abS
	 * 		X - a
	 * 		Y - b
	 * Em regra.get(Possicao).getRegra - temos:X(Possicao[0]) , Y(Possicao[1]).
	 * Em regra.get(Possicao).alfabetoGerado.get(Possicao).getAlfabeto - Em X(Possicao[0]) Temos: abS(Possicao[0])
	 * Em regra.get(Possicao).alfabetoGerado.get(Possicao).getAlfabeto - Em X(Possicao[1]) Temos: a(Possicao[1])
	 * Em regra.get(Possicao).alfabetoGerado.get(Possicao).getAlfabeto - EM Y(Possicao[1]) Temos: b(Possicao[0])
	 * 
	 * @param regra recebe uma String.
	 */
	public Regra(String regra) {
		this.regra = regra;
		alfabetoGerado = new ArrayList<AlfabetoGerado>();
	}

	/**
	 * Pega a String guardada em uma possicao.
	 * @return retorna String na possicao.
	 */
	public String getRegra() {
		return regra;
	}

	/**
	 * Edita a regra em uma possicao.
	 * @param regra String de substituicao.
	 */
	public void setRegra(String regra) {
		this.regra = regra;
	}
	
	/**
	 * Adiciona um alfabeto referente a regra.
	 * @param entraAlfabeto String na qual voce entra com o alfabeto e e guardado.
	 */
	public void addAlfabeto(String entraAlfabeto) {
		AlfabetoGerado alfabeto = new AlfabetoGerado(entraAlfabeto);
		this.alfabetoGerado.add(alfabeto);
	}
	
	/**
	 * Pega um alfabeto de um caracter especifico referente a possicao (i) passada.
	 * @param i possicao passada.
	 * @return retorna a String(alfabedo guardado nequela possicao).
	 */
	public String pegarAlfabeto(int i) {
		String alfabeto;
		alfabeto =  this.alfabetoGerado.get(i).getAlfabeto();
		return alfabeto;
	}
	
	/**
	 * Retorna o tamanho do alfabeto que um caracter especifico pode gerar.
	 * @return retorna tamanho (int).
	 */
	public int tamanho(){
		int tam = alfabetoGerado.size();
		return tam;
	}
}
