package gramatica;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class responsavel pelo programa onde esta todos os codigos para execucao.
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
	 * Chamo as etapas do programa.
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
				System.out.print("Deseja computar uma nova palavra y/n ?");
				novaPalavra = recebeString();
			}
		}while(!novaPalavra.equals("n"));

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
	 * String[] regraGerada = regraProducao.split("/");  Separa a regra do alfabeto.
	 * As linha seguintes pega o que foi separado e verifica se tem na Lista, se tem e so adicionado mais um alfabeto a determinada regra
	 * caso nao tenha ele ja cria a regra e adiciona o alfabeto a essa regra.
	 * Lembrando:
	 * Ex:	X - abS
	 * 		X - a
	 * 		Y - b
	 * Regra me refiro a X e Y comforme o exemplo acima.
	 * alfabeto me refiro a abS,a,b comforme o exemplo acima, ou seja alfabeto seria a String na qual a regra pode ser trocada.
	 */
	public void separarRegraProducao(){	
		System.out.print("Entre com regra de producao os separando por / ( Barra )"
				+ "\numa por fez sempre precionando ENTER em seguida, 0 (zero) para parar de entra com o alfabeto."
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
	 * Define o ponto de partida da computacoa da palavra.
	 */
	public void pontoDePartida(){
		System.out.print("Entre com o Caracter de Inicio : ");
		partida = recebeString();
	}
	
	/**
	 * Pega a String passada pelo usuario a separando e guardando na Lista de terminais.
	 */
	public void caracterTerminais(){
		System.out.print("Entre com os Terminais os separando por , (Virgula) Ex: a,b : ");
		String terminaisNaoSeparado = recebeString();
		String[] terminaisSeparadoEmVetor = terminaisNaoSeparado.split(",");
		for(int i = 0; i < terminaisSeparadoEmVetor.length; i++){
			terminais.add(terminaisSeparadoEmVetor[i]);
		}
	}
	
	/**
	 * Pega a palavra a ser computada
	 */
	public void palavraParaComputar(){
		System.out.print("Entre com a palavra a ser computada : ");
		palavra = recebeString();
	}
	
	/**
	 * Este medoto computa a palavra conforme as escolha do usuario e mostra o resultado no final.
	 */
	public void computarPalavra(){

		boolean resultado = false;
		boolean busca = false;
		int intRegra = 0;
		int intAlfabeto;
		String computandoPalavra = partida;
		int buscaRegra;

		do{
			todaComputacao.add(new String(computandoPalavra));
			System.out.println("Computar palavra : " + computandoPalavra);
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
			//Verifica se a palavra computada esta toda correta.
			if(palavra.equals(computandoPalavra)){
				System.out.println("Palavra computada corretamente");
				resultado = true;
			}
			
			//Busca por regra de producao na palavra.
			buscaRegra = 0;
			for (int i = 0; i < computandoPalavra.length(); i++) {
				for (int j = 0; j < regra.size(); j++) {
					if(computandoPalavra.charAt(i) == regra.get(j).getRegra().charAt(0)){
						buscaRegra++;
					}
				}
			}
			
			//Verifica se a palavra computada esta errada.
			if((!palavra.equals(computandoPalavra) && buscaRegra == 0) || 
					(palavra.length() < computandoPalavra.length() + 1 && 
							buscaRegra <= computandoPalavra.length() - palavra.length())){
				System.out.println("Palavra nao pode ser computada");
				resultado = true;
			}
			
		}while(!resultado);
	}
}
