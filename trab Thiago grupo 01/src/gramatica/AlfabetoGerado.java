package gramatica;
/**
 * Class criada para guardar o alfabeto que pode ser gerado por um caracter específico.
 * Ex : X - abS
 * 	X - a
 * Sendo X o caracter específico que pode ser substituído por abS ou a para formar a palavra.
 * @author RafaelSene
 *
 */
public class AlfabetoGerado {

	private String alfabeto;
	
	/**
	 * Preenche a variável com a String passada.
	 * @param alfabeto recebe a String passada.
	 */
	public AlfabetoGerado(String alfabeto) {
		this.alfabeto = alfabeto;		
	}
	
	/**
	 * Retorna a String guardada
	 * @return retorna a String
	 */
	public String getAlfabeto() {
		return alfabeto;
	}
	
	/**
	 * Entra com uma String para substituir a que estava guardada.
	 * @param alfabeto recebe a String passada.
	 */
	public void setAlfabeto(String alfabeto) {
		this.alfabeto = alfabeto;
	}

}
