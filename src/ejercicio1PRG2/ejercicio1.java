package ejercicio1PRG2;

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio1 {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int tam=sc.nextInt();
		ArrayList<int[][]>matrices= new ArrayList<int[][]>();
		ArrayList<int[][]>traspuestas= new ArrayList<int[][]>();
		ArrayList<Integer>tamaños=new ArrayList<Integer>();
	
		
		while(tam!=0) {
			int matriz[][]= new int[tam][tam];
			tamaños.add(tam);
			for(int i=0;i<tam;i++) {
				for(int j=0;j<tam;j++) {
					matriz[i][j]= esNumeroCorrecto(sc.nextInt());
				}
			}
			matrices.add(matriz);
			traspuestas.add(matriz);
			tam=sc.nextInt();
		}
		calcularTraspuestas(matrices,traspuestas,tamaños,0);
		imprimeMatrices(matrices,traspuestas,tamaños,0);
		imprimeMatriz(traspuestas.get(0),3,0,0);
		System.out.println();
		imprimeMatriz(traspuestas.get(1),2,0,0);

	}

	public static int esNumeroCorrecto(int num) {
		if(num>=10) {
			if(esNumeroCorrecto(num/10)==1 && esNumeroCorrecto(num%23)+14==0) {
				return 1;
			}else {
				return 0;
			}
		}else {
			if(num%2==0) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	
	public static void imprimeMatriz(int matriz[][], int tam, int i, int j) {
		if(i<tam) {
			if(j<tam) {
				System.out.print(matriz[i][j]+" ");
				imprimeMatriz(matriz,tam,i,j+1);
			}
			
			if(j==tam) {
				System.out.println();
				imprimeMatriz(matriz,tam,i+1,0);
			}
		}
	}
	
	public static void imprimeMatrices(ArrayList<int[][]>lista,ArrayList<int[][]>traspuestas,ArrayList<Integer>tamaños, int i) {
		if(i<lista.size()) {
			if(sonSimetricas(lista.get(i),traspuestas.get(i),tamaños.get(i),0,0)){
				System.out.println("SI");
			}else {
				System.out.println("NO");
			}
			imprimeMatriz(lista.get(i),tamaños.get(i),0,0);
			System.out.println();
			imprimeMatrices(lista,traspuestas,tamaños,i+1);
		}
	}
	
	public static void calcularTraspuesta(int matriz[][], int traspuesta[][], int tam, int i, int j) {
		if(i<tam) {
			if(j<tam) {
				traspuesta[j][i]=matriz[i][j];
				calcularTraspuesta(matriz,traspuesta,tam,i,j+1);
			}
			if(j==tam) {
				calcularTraspuesta(matriz,traspuesta,tam,i+1,0);
			}
		}
	}
	
	public static void calcularTraspuestas(ArrayList<int[][]>matrices,ArrayList<int[][]>traspuestas,ArrayList<Integer>tamaños,int i) {
		if(i<matrices.size()) {
			calcularTraspuesta(matrices.get(i),traspuestas.get(i),tamaños.get(i),0,0);
			calcularTraspuestas(matrices,traspuestas,tamaños,i+1);
		}
	}
	
	public static boolean sonSimetricas(int matriz1[][], int matriz2[][], int tam, int i, int j) {
		if(i<tam) {
			if(j<tam) {
				if(matriz1[i][j]==matriz2[i][j]) {
					return true && sonSimetricas(matriz1,matriz2,tam,i,j+1);
				}else {
					return false && sonSimetricas(matriz1,matriz2,tam,i,j+1);
				}
			}
			if(j==tam) {
				return sonSimetricas(matriz1,matriz2,tam,i+1,0);
			}
		}
		return true;	//revisar
	}
	
}
