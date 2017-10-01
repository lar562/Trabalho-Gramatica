package gramatica;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
	
	private String partida;
	private String terminais;
	private String palavra;
	private ArrayList<Regra> regra;
	
	
	public Metodos() {
		regra = new ArrayList<Regra>();
	//	System.out.print("Entre com o ponto de Partida : ");
	//	partida = recebeString();
	//	System.out.print("Entre com os estados terminais os separando por , (Vírgula) : ");
	//	terminais = recebeString();
		System.out.print("Entre com regra de producao os separando por | ( Barra ) deixando bem claro a separacao \nExemplo: (S|aSb,S|a,S|a): ");
		separarRegraProducao();
	//	System.out.print("Entre com palavra a ser computada : ");
	//	palavra = recebeString();
	//	separarRegraProducao(regraProducao);
	}
	public String recebeString() {
		Scanner input = new Scanner(System.in);
		String inputdoUsuario = input.nextLine();		
		return inputdoUsuario;
	}
	
	public void separarRegraProducao(){
		
		boolean regraEncontrada = false;
		String regraProducao;
		do{
			regraProducao = recebeString();

			String[] regraGerada = regraProducao.split("");
			
			for (int j = 0; j < regra.size(); j++) {
				if(regra.get(j).getRegra().equals(regraGerada[0])){
					regra.get(j).addAlfabeto(regraGerada[0]);
					regraEncontrada = true;
				}
			}
			if(!regraEncontrada){
				regra.add
					
			}
			System.out.println("AAAA");
		}while(regraProducao == "0");
							
		System.out.println("BBBB");

				
	}

}
