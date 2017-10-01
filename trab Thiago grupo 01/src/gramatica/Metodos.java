package gramatica;

import java.util.Scanner;

//Edimo

/**
 * 
 * @author Joubert Joe Vieira Lellis Essa classe foi criada para organizar todos
 *         os métodos usados para a elaboração do trabalho.
 *
 */
public class Metodos {
	/**
	 * 
	 * Método reponsavel por partir a string em pedaços e separálos atravéz da
	 * ultilização de um vetor de Strings.
	 * 
	 * @param divisao
	 *            O que será usado como critério para dividr a String
	 * @param stringCompleta
	 *            A Srting a ser dividida
	 * @return O vetor de Strings já dividido
	 */
	public String[] divideString(String divisao, String stringCompleta) {
		String[] stringDivida = null;
		stringDivida = stringCompleta.split(divisao);
		return stringDivida;
	}

	/**
	 * Método responsável por capturar o que o usuario digita usa um scanner
	 * para ser possível fazer isso
	 * 
	 * @return Uma String com aquilo que foi digitado.
	 */
	public String recebeString() {
		String inputdoUsuario = null;
		Scanner input = new Scanner(System.in);
		inputdoUsuario = input.next();
		input.close();
		return inputdoUsuario;
	}

	// Atulizado dia 29/09

	/**
	 * Usa os métodos de leitura e seperação de Strings para ler o alfabeto
	 * inserido pelo usuario e o separar em um vetor, atravéz de virgulas.
	 * 
	 * @return um vetor de String contendo o Alfabeto
	 */
	public String[] lerAlfabeto() {
		String[] alfabeto = null;
		System.out.println("Insira os simbolos do alfabeto separados por , (Vírgula) :");
		String alfabetoInteiro = recebeString();
		alfabeto = divideString(",", alfabetoInteiro);
		return alfabeto;
	}

	/**
	 * Recebo do usuario os símbolos terminais e as separa dentro de um vetor
	 * 
	 * @return Vetor contendo os símbolos terminais
	 */
	public String[] lerTerminais() {
		String[] terminais = null;
		System.out.println("Insira os simbolos terminais separados por ',' (Vírgula) :");
		String letrasTerminais = recebeString();
		terminais = divideString(",", letrasTerminais);
		return terminais;
	}
}
