package EX07;
import java.util.Scanner;

/* Paulo Eduardo da Silva Pessoa
 * João do Valle Seixas Paula
 Entrar via teclado com doze valores e armazená-los em uma matriz de ordem 3x4. Após a
digitação dos valores solicitar uma constante multiplicativa, que deverá multiplicar cada
valor matriz e armazenar o resultado na própria matriz, nas posições correspondentes.
 */
 

public class Main {

	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        int[][] matriz = new int[3][4];

	   
	        System.out.println("Digite 12 valores inteiros para preencher a matriz 3x4:");
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 4; j++) {
	                System.out.print("Valor [" + i + "][" + j + "]: ");
	                matriz[i][j] = scanner.nextInt();
	            }
	        }

	        System.out.print("\nDigite a constante multiplicativa: ");
	        int constante = scanner.nextInt();


	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 4; j++) {
	                matriz[i][j] *= constante; 
	            }
	        }

	
	        System.out.println("\nMatriz após multiplicação:");
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 4; j++) {
	                System.out.print(matriz[i][j] + "\t");
	            }
	            System.out.println();
	        }

	        scanner.close();
	    }
	}
