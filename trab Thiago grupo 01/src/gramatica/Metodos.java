package gramatica;

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
	
	/**
	 * Chamo as etapas do programa.
	 */
	public Metodos() {
		
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
}
