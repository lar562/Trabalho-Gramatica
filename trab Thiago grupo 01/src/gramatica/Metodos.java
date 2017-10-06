package gramatica;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class responsável pelo programa onde está todos os códigos para a execução.
 * @author RafaelSene
 * 
 */
public class Metodos {
	
	private String partida;
	private String palavra;
	private ArrayList<String> terminais = new ArrayList<>();
	private ArrayList<Regra> regra = new ArrayList<Regra>();
	private ArrayList<String> todaComputacao = new ArrayList<String>();
	
	/**
	 * Chama as etapas do programa.
	 */
	public Metodos() {
		String novaPalavra = "y";
		pontoDePartida();
		caracterTerminais();
		separarRegraProducao();
		do{
			if(novaPalavra.equals("y")){
				palavraParaComputar();
				computarPalavra();
			}
			System.out.print("Deseja computar uma nova palavra y/n ?");
			novaPalavra = recebeString();
		}while(!novaPalavra.equals("n"));

	}
	
	/**
	 * Pega uma string digitada pelo usuário.
	 * @return retorna a String digitada.
	 */
	public String recebeString() {
		Scanner input = new Scanner(System.in);
		String inputdoUsuario = input.nextLine();		
		return inputdoUsuario;
	}
	
	/**
	 * Cria e separa a regra de produção.
	 * Ficando em loop até o usuário passar "0".
	 * Dentro do loop recebemos o que o usuário digitou e logo em seguida temos os seguintes tratamentos:
	 * String[] regraGerada = regraProducao.split("/");  Separa a regra do alfabeto.
	 * As linhas seguintes pegão o que foi separado e verificam se têm na Lista, se tem é adicionado mais um alfabeto na determinada regra
	 * Caso não tenha, ele logo cria a regra e adiciona o alfabeto a ela.
	 * Lembrando:
	 * Ex:	X - abS
	 * 	X - a
	 * 	Y - b
	 *A regra se refere a X e Y, comforme o exemplo acima.
	 *O alfabeto se refere a abS,a,b, comforme o exemplo acima, ou seja, ele seria a String na qual a regra pode ser trocada.
	 */
	public void separarRegraProducao(){	
		System.out.print("Entre com regra de produção separando-a por / ( Barra )"
				+ "\uma por vez, sempre precionando ENTER em seguida. 0 (zero) é para parar com a entrada de regras."
				+ " \nExemplo: S/aSb S/a S/a: ");
		String regraProducao;
		do{
			regraProducao = recebeString();
			
			if(!regraProducao.equals("0")){
				boolean regraEncontrada = false;
				String[] regraGerada = regraProducao.split("/");
				
				for (int j = 0; j < regra.size(); j++) {
					if(regra.get(j).getRegra().equals(regraGerada[0])){
						regra.get(j).addAlfabeto(regraGerada[1]);
						regraEncontrada = true;
					}
				}
				if(!regraEncontrada){					
					regra.add(new Regra(regraGerada[0]));	
					regra.get(regra.size() -1).addAlfabeto(regraGerada[1]);
				}
			}
		}while(!regraProducao.equals("0"));	
	}
	
	/**
	 * Define o ponto de partida da computacão da palavra.
	 */
	public void pontoDePartida(){
		System.out.print("Entre com o Caracter de Início : ");
		partida = recebeString();
	}
	
	/**
	 * Pega a String passada pelo usuário, separando e guardando-a na Lista de terminais.
	 */
	public void caracterTerminais(){
		System.out.print("Entre com os Terminais separando-os por , (Vírgula). Ex: a,b : ");
		String terminaisNaoSeparado = recebeString();
		String[] terminaisSeparadoEmVetor = terminaisNaoSeparado.split(",");
		for(int i = 0; i < terminaisSeparadoEmVetor.length; i++){
			terminais.add(terminaisSeparadoEmVetor[i]);
		}
	}
	
	/**
	 * Pega a palavra a ser computada.
	 */
	public void palavraParaComputar(){
		System.out.print("Entre com a palavra a ser computada : ");
		palavra = recebeString();
	}
	
	/**
	 * Este médoto computa a palavra conforme as escolhas do usuário, e mostra os resultados no final.
	 */
	public void computarPalavra(){

		boolean resultado = false;
		int intRegra = -1;
		int intAlfabeto;
		String computandoPalavra = partida;
		int buscaRegra;

		do{
			boolean busca = false;
			todaComputacao.add(new String(computandoPalavra));
			System.out.println("Computar palavra : " + computandoPalavra);
			//Busca a regra na palavra que está sendo computada.
			for (int i = 0; i < computandoPalavra.length(); i++) {
				for (int j = 0; j < regra.size(); j++) {
					String primeiro = computandoPalavra.charAt(i) + "";
					String segundo =  regra.get(j).getRegra();
					if(primeiro.equals(segundo) ){
						intRegra = j;
						busca = true;
					}
					if(busca)
						break;
				}
				if(busca)
					break;
			}
			busca = false;
			System.out.println("Escolha uma das opções:");
			//Lista as opções.
			for (int i = 0; i < regra.get(intRegra).tamanho(); i++) {
				System.out.println(i + " = " + regra.get(intRegra).getRegra() + " -> " + regra.get(intRegra).pegarAlfabeto(i));
			}
			//Entra com o valor da escolha.
			Scanner input = new Scanner(System.in);
			intAlfabeto = input.nextInt();
			
			//Adiciona as escolhas de transação para motrar ao usuário depois.
			todaComputacao.add(new String(regra.get(intRegra).getRegra() + " -> " + regra.get(intRegra).pegarAlfabeto(intAlfabeto)));
			
			//Busca a regra na palavra que está sendo computada.
			for (int i = 0; i < computandoPalavra.length(); i++) {
				for (int j = 0; j < regra.size(); j++) {
					String primeiro = computandoPalavra.charAt(i) + "";
					String segundo =  regra.get(j).getRegra() + "";
					if(primeiro.equals(segundo) ){
						String trocarPalavra = "" + computandoPalavra.charAt(i);
						computandoPalavra = computandoPalavra.replaceFirst(regra.get(j).getRegra(), regra.get(j).pegarAlfabeto(intAlfabeto));
						busca = true;
					}
					if(busca)
						break;
				}
				if(busca)
					break;
			}
			//Verifica se as palavras computadas estão todas corretas.
			if(palavra.equals(computandoPalavra)){
				System.out.println("Palavra computada corretamente!!");
				resultado = true;
			}
			
			//Busca por regras de prodção na palavra.
			buscaRegra = 0;
			for (int i = 0; i < computandoPalavra.length(); i++) {
				for (int j = 0; j < regra.size(); j++) {
					String primeiro = computandoPalavra.charAt(i) + "";
					String segundo =  regra.get(j).getRegra() + "";
					if(primeiro.equals(segundo) ){
						buscaRegra++;
					}
				}
			}
			
			//Verifica se a palavra computada está errada.
			if((!palavra.equals(computandoPalavra) && buscaRegra == 0 && !resultado) || 
					(palavra.length() < computandoPalavra.length() + 1 && 
							buscaRegra <= computandoPalavra.length() - palavra.length() && !resultado)){
				System.out.println("Palavra não pode ser computada!!");
				resultado = true;
			}
			
		}while(!resultado);
		todaComputacao.add(new String(computandoPalavra));
		System.out.println("Toda computacao feita: ");
		for (int i = 0; i < todaComputacao.size(); i++) {
			System.out.println(todaComputacao.get(i));
		}
		todaComputacao.removeAll(todaComputacao);
	}
}
