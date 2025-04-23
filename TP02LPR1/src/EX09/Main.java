package EX09;
import java.util.Scanner;

/* Paulo Eduardo da Silva Pessoa
 * João do Valle Seixas Paula
Entrar com uma matriz de ordem MxN, onde a ordem também será escolhida pelo usuário,
sendo que no máximo 10x10. A matriz não precisa ser quadrática. Após a digitação dos
elementos, calcular e exibir a matriz transposta.
 */
 

public class Main {


	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int M, N;

	        do {
	            System.out.print("Digite o número de linhas (M), até 10: ");
	            M = scanner.nextInt();
	            System.out.print("Digite o número de colunas (N), até 10: ");
	            N = scanner.nextInt();

	            if (M <= 0 || M > 10 || N <= 0 || N > 10) {
	                System.out.println("Erro: valores de M e N devem estar entre 1 e 10.");
	            }
	        } while (M <= 0 || M > 10 || N <= 0 || N > 10);

	        int[][] matriz = new int[M][N];
	        int[][] transposta = new int[N][M];

	        System.out.println("\nDigite os elementos da matriz " + M + "x" + N + ":");
	        for (int i = 0; i < M; i++) {
	            for (int j = 0; j < N; j++) {
	                System.out.print("Valor [" + i + "][" + j + "]: ");
	                matriz[i][j] = scanner.nextInt();
	            }
	        }


	        for (int i = 0; i < M; i++) {
	            for (int j = 0; j < N; j++) {
	                transposta[j][i] = matriz[i][j];
	            }
	        }

	        System.out.println("\nMatriz Original:");
	        for (int i = 0; i < M; i++) {
	            for (int j = 0; j < N; j++) {
	                System.out.print(matriz[i][j] + "\t");
	            }
	            System.out.println();
	        }

	        System.out.println("\nMatriz Transposta:");
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                System.out.print(transposta[i][j] + "\t");
	            }
	            System.out.println();
	        }

	        scanner.close();
	    }
	}
