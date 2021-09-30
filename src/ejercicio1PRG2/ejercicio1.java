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
	
		leerMatrices(matrices,traspuestas,tamaños,tam,sc);
		calcularTraspuestas(traspuestas,tamaños,0);	
		imprimeMatrices(matrices,traspuestas,tamaños,0);

	}
	
	public static void leerMatrices(ArrayList<int[][]>listaMatrices,ArrayList<int[][]>traspuestas,ArrayList<Integer>tamaños,int tam,Scanner sc) {
		if(tam!=0) {
			int matriz[][]= new int[tam][tam];
			int futuraTraspuesta[][]= new int[tam][tam];
			tamaños.add(tam);
			leerMatriz(sc,matriz,futuraTraspuesta,tam,0,0);
			listaMatrices.add(matriz);
			traspuestas.add(futuraTraspuesta);
			tam=sc.nextInt();
			leerMatrices(listaMatrices,traspuestas,tamaños,tam,sc);
		}
	}
	
	public static void leerMatriz(Scanner sc,int matriz[][],int futuraTraspuesta[][],int tam, int i, int j) {
		int n;
		if(i<tam) {
			if(j<tam) {
				n = esNumeroCorrecto(sc.nextInt());
				matriz[i][j]=n;
				futuraTraspuesta[i][j]=n;
				leerMatriz(sc,matriz,futuraTraspuesta,tam,i,j+1);
			}
			
			if(j==tam) {
				leerMatriz(sc,matriz,futuraTraspuesta,tam,i+1,0);
			}	
		}
	}
	
	public static int esNumeroCorrecto(int num) {
		if(num>=10) {
			if(esNumeroCorrecto(num/10)==1 && esNumeroCorrecto(num%23 +14)==0) {
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
				System.out.println("SÍ");
			}else {
				System.out.println("NO");
			}
			imprimeMatriz(lista.get(i),tamaños.get(i),0,0);
			imprimeMatrices(lista,traspuestas,tamaños,i+1);
		}
	}
	
	public static void calcularTraspuesta(int matriz[][], int tam, int i, int j) {
		if(i<tam) {
			if(j<tam) {
				if(i>j) {
					int aux;
					aux = matriz[i][j];
					matriz[i][j]=matriz[j][i];
					matriz[j][i]=aux;
				}
				calcularTraspuesta(matriz,tam,i,j+1);
			}
			if(j==tam) {
				calcularTraspuesta(matriz,tam,i+1,0);
			}
		}
	}
	
	public static void calcularTraspuestas(ArrayList<int[][]>traspuestas,ArrayList<Integer>tamaños,int i) {
		if(i<traspuestas.size()) {
			calcularTraspuesta(traspuestas.get(i),tamaños.get(i),0,0);
			calcularTraspuestas(traspuestas,tamaños,i+1);
		}
	}
	
	public static boolean sonSimetricas(int matriz1[][], int matriz2[][], int tam, int i, int j) {
		if(i<tam) {
			if(j<tam) {
				if(matriz1[i][j]==matriz2[i][j]) {
					return true && sonSimetricas(matriz1,matriz2,tam,i,j+1);
				}else {
					return false;
				}
			}
			if(j==tam) {
				return sonSimetricas(matriz1,matriz2,tam,i+1,0);
			}
		}
		return true;
	}
	
}
