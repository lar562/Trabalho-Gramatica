package gramatica;

import java.util.Scanner;

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

}
