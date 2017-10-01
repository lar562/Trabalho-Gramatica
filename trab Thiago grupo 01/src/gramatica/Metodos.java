package gramatica;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
	
	private String partida;
	private String terminais;
	private String palavra;
	private ArrayList<Regra> regra = new ArrayList<Regra>();
	
	
	public Metodos() {
		
	//	System.out.print("Entre com o ponto de Partida : ");
	//	partida = recebeString();
	//	System.out.print("Entre com os estados terminais os separando por , (Vírgula) : ");
	//	terminais = recebeString();
		System.out.print("Entre com regra de producao os separando por | ( Barra )\numa por fez sempre precionando ENTER em seguida, 0 (zero) para parar de entra com o alfabeto. \nExemplo: S|aSb S|a S|a: ");
		separarRegraProducao();		
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

}
