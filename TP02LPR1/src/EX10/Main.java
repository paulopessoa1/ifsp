package EX10;
import java.util.Scanner;

/* Paulo Eduardo da Silva Pessoa
 * João do Valle Seixas Paula
Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário,
sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos,
calcular e exibir a matriz inversa. Exibir as matrizes na tela, sob a forma matricial (linhas x
colunas).
 */
 

public class Main {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int M;

	
	        do {
	            System.out.print("Digite a ordem da matriz (M), até 10: ");
	            M = scanner.nextInt();
	            if (M <= 0 || M > 10) {
	                System.out.println("Erro: a ordem da matriz deve ser entre 1 e 10.");
	            }
	        } while (M <= 0 || M > 10);

	        double[][] matriz = new double[M][M];
	        double[][] matrizInversa = new double[M][M];

	   
	        System.out.println("\nDigite os elementos da matriz " + M + "x" + M + ":");
	        for (int i = 0; i < M; i++) {
	            for (int j = 0; j < M; j++) {
	                System.out.print("Valor [" + i + "][" + j + "]: ");
	                matriz[i][j] = scanner.nextDouble();
	            }
	        }


	        double determinante = calcularDeterminante(matriz, M);
	        
	        if (determinante == 0) {
	            System.out.println("\nA matriz não possui inversa (determinante é zero).");
	        } else {
	    
	            calcularInversa(matriz, matrizInversa, M, determinante);

	        
	            System.out.println("\nMatriz Original:");
	            exibirMatriz(matriz, M);

	
	            System.out.println("\nMatriz Inversa:");
	            exibirMatriz(matrizInversa, M);
	        }

	        scanner.close();
	    }


	    public static double calcularDeterminante(double[][] matriz, int n) {
	        if (n == 1) {
	            return matriz[0][0];
	        }

	        double determinante = 0;
	        double[][] subMatriz = new double[n - 1][n - 1];

	        for (int i = 0; i < n; i++) {
	     
	            int subMatrizLinhas = 0;
	            for (int j = 1; j < n; j++) {
	                int subMatrizColunas = 0;
	                for (int k = 0; k < n; k++) {
	                    if (k != i) {
	                        subMatriz[subMatrizLinhas][subMatrizColunas] = matriz[j][k];
	                        subMatrizColunas++;
	                    }
	                }
	                subMatrizLinhas++;
	            }

	            determinante += (i % 2 == 0 ? 1 : -1) * matriz[0][i] * calcularDeterminante(subMatriz, n - 1);
	        }

	        return determinante;
	    }


	    public static void calcularInversa(double[][] matriz, double[][] inversa, int n, double determinante) {
	        double[][] adjunta = new double[n][n];


	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                double[][] subMatriz = new double[n - 1][n - 1];
	                int subi = 0;
	                for (int k = 0; k < n; k++) {
	                    if (k != i) {
	                        int subj = 0;
	                        for (int l = 0; l < n; l++) {
	                            if (l != j) {
	                                subMatriz[subi][subj] = matriz[k][l];
	                                subj++;
	                            }
	                        }
	                        subi++;
	                    }
	                }
	                adjunta[j][i] = (Math.pow(-1, i + j) * calcularDeterminante(subMatriz, n - 1)); // Cofatores
	            }
	        }

	   
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                inversa[i][j] = adjunta[i][j] / determinante;
	            }
	        }
	    }

	 
	    public static void exibirMatriz(double[][] matriz, int n) {
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                System.out.print(matriz[i][j] + "\t");
	            }
	            System.out.println();
	        }
	    }
	}
