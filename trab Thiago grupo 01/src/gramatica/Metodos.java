package gramatica;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author RafaelSene
 * Class responsavel pelo programa onde esta todos os codigos para execucao.
 */
public class Metodos {
	
	private String partida;
	private String palavra;
	private ArrayList<String> terminais = new ArrayList<>();
	private ArrayList<Regra> regra = new ArrayList<Regra>();
	private ArrayList<String> todaComputacao = new ArrayList<String>();
	
	/**
	 * Chamo as etapas do programa.
	 */
	public Metodos() {
		computarPalavra();
	//caracterTerminais();
	//	System.out.print("Entre com palavra a ser computada : ");
	//	palavra = recebeString();
	//	separarRegraProducao(regraProducao);
	}
	
	/**
	 * Pega uma string digitada pelo usuario
	 * @return retorna a String digitada.
	 */
	public String recebeString() {
		Scanner input = new Scanner(System.in);
		String inputdoUsuario = input.nextLine();		
		return inputdoUsuario;
	}
	
	/**
	 * Cria e separa a regra de producao.
	 * Ficando em loop ate o usuario passa "0"
	 * Dentro do loop recebemos o que o usuario digitou e logo em siguida temos os seguinte tratamento:
	 * String[] regraGerada = regraProducao.split("|"); >> Separa a regra do alfabeto
	 * As linha seguintes pega o que foi separado e verifica se tem na Lista, se tem e so adicionado mais um alfabeto a determinada regra
	 * caso nao tenha ele ja cria a regra e adiciona o alfabeto a essa regra.
	 * Lembrando:
	 * Ex:	X -> abS
	 * 		X -> a
	 * 		Y -> b
	 * Regra me refiro a X e Y comforme o exemplo acima.
	 * alfabeto me refiro a abS,a,b comforme o exemplo acima, ou seja alfabeto seria a String na qual a regra pode ser trocada.
	 */
	public void separarRegraProducao(){	
		System.out.print("Entre com regra de producao os separando por | ( Barra )"
				+ "\numa por fez sempre precionando ENTER em seguida, 0 (zero) para parar de entra com o alfabeto."
				+ " \nExemplo: S|aSb S|a S|a: ");
		String regraProducao;
		do{
			regraProducao = recebeString();
			
			if(regraProducao != "0"){
				boolean regraEncontrada = false;
				String[] regraGerada = regraProducao.split("|");
				
				for (int j = 0; j < regra.size(); j++) {
					if(regra.get(j).getRegra().equals(regraGerada[0])){
						regra.get(j).addAlfabeto(regraGerada[0]);
						regraEncontrada = true;
					}
				}
				if(!regraEncontrada){					
					regra.add(new Regra(regraGerada[0]));	
					regra.get(regra.size() -1).addAlfabeto(regraGerada[1]);
				}
			}
		}while(regraProducao == "0");
				
	}
	
	/**
	 * Define o ponto de partida da computacoa da palavra.
	 */
	public void pontoDePartida(){
		partida = recebeString();
	}
	
	/**
	 * Pega a String passada pelo usuario a separando e guardando na Lista de terminais.
	 */
	public void caracterTerminais(){
		System.out.println("Entre com os Terminais os separando por , (Virgula) Ex: a,b :");
		String terminaisNaoSeparado = recebeString();
		String[] terminaisSeparadoEmVetor = terminaisNaoSeparado.split(",");
		for(int i = 0; i < terminaisSeparadoEmVetor.length; i++){
			terminais.add(terminaisSeparadoEmVetor[i]);
		}
		for (int i = 0; i < terminais.size(); i++) {
			System.out.println(terminais.get(i));
		}
	}
	
	/**
	 * Pega a palavra a ser computada
	 */
	public void palavraParaComputar(){
		palavra = recebeString();
	}
	
	public void computarPalavra(){
		palavra = "aa";
		partida = "S";
		terminais.add("a");
		terminais.add("b");
		regra.add(new Regra("S"));
		regra.get(0).addAlfabeto("a");
		regra.get(0).addAlfabeto("b");
		regra.get(0).addAlfabeto("aS");
		regra.get(0).addAlfabeto("aSb");
		
		boolean resultado = false;
		boolean busca = false;
		int intRegra = 0;
		int intAlfabeto;
		String computandoPalavra = partida;

		do{
			//System.out.println(computandoPalavra.charAt(0));
			System.out.println(computandoPalavra);
			todaComputacao.add(new String(computandoPalavra));
			//Busca a regra na palavra que esta sendo computada.
			for (int i = 0; i < computandoPalavra.length(); i++) {
				for (int j = 0; j < regra.size(); j++) {
					if(computandoPalavra.charAt(i) == regra.get(j).getRegra().charAt(0)){
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
			System.out.println("Escolha uma das opcoes:");
			//Lista as opcoes.
			for (int i = 0; i < regra.get(intRegra).tamanho(); i++) {
				System.out.println(i + " = " + regra.get(intRegra).getRegra() + " -> " + regra.get(intRegra).pegarAlfabeto(i));
			}
			//Entra com o valor da escolha.
			Scanner input = new Scanner(System.in);
			intAlfabeto = input.nextInt();
			
			//Busca a regra na palavra que esta sendo computada.
			for (int i = 0; i < computandoPalavra.length(); i++) {
				for (int j = 0; j < regra.size(); j++) {
					if(computandoPalavra.charAt(i) == regra.get(j).getRegra().charAt(0)){
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
			
		}while(!resultado);
	}
}
