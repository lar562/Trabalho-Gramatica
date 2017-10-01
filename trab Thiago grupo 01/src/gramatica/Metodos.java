package gramatica;

import java.util.Scanner;

public class Metodos {
	private static String[] alfabeto;
	private static String[] terminais;
	
	public static void main(String[] args) {
		
		
	recebeAlfabeto();
	}

		
		public static String[] divideString(String inputdoUsuario){
			String aux = inputdoUsuario;
			
			String[] dividido = aux.split(",");

			return dividido;
			
		}
		

	
	public static String recebeAlfabeto(){
		
		String inputdoUsuario = null;
		System.out.println("Digite o alfabeto separando com virgula:");
		Scanner sc = new Scanner(System.in);
		inputdoUsuario=sc.next();
		
		alfabeto=divideString(inputdoUsuario);
		recebeTerminais();
		return inputdoUsuario;
		
	}
	public static String recebeTerminais(){
		
		String termin=null;
		System.out.println("Digite os terminais separando com virgula:");
		Scanner sc = new Scanner(System.in);
		termin=sc.next();
		
		terminais=divideString(termin);
		teste();
		return termin;
		
	}
	public static String regrasTerminais(){
		String[] regras;
		
		System.out.println("Digite as regras de cada terminal :\nSe gerar mais de 2 letras separar com .");
		Scanner sc = new Scanner(System.in);
		
		return null;
		
	}
	
	public static void teste(){
		String[] auxA,auxT;
		auxA=alfabeto;
		auxT=terminais;
		int i;
		for(i=0;i<auxA.length;i++){
			System.out.print(auxA[i]);
		}
		System.out.println();
		for(i=0;i<auxT.length;i++){
			System.out.print(auxT[i]);
		}
	}

}
