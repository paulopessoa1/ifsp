package EX08;
import java.util.Scanner;

/* Paulo Eduardo da Silva Pessoa
 * João do Valle Seixas Paula
 Entrar via teclado com doze valores e armazená-los em uma matriz de ordem 3x4. Após a
digitação dos valores solicitar uma constante multiplicativa, que deverá multiplicar cada
valor matriz e armazenar o resultado em outra matriz de mesma ordem, nas posições
correspondentes. Exibir as matrizes na tela, sob a forma matricial, ou seja, linhas por
colunas.
 */
 

public class Main {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        int[][] matrizOriginal = new int[3][4];
	        int[][] matrizResultado = new int[3][4];

	      
	        System.out.println("Digite 12 valores inteiros para preencher a matriz 3x4:");
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 4; j++) {
	                System.out.print("Valor [" + i + "][" + j + "]: ");
	                matrizOriginal[i][j] = scanner.nextInt();
	            }
	        }
	
	        System.out.print("\nDigite a constante multiplicativa: ");
	        int constante = scanner.nextInt();
	        
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 4; j++) {
	                matrizResultado[i][j] = matrizOriginal[i][j] * constante;
	            }
	        }

	        System.out.println("\nMatriz Original:");
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 4; j++) {
	                System.out.print(matrizOriginal[i][j] + "\t");
	            }
	            System.out.println();
	        }

	        System.out.println("\nMatriz Resultado (multiplicada pela constante " + constante + "):");
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 4; j++) {
	                System.out.print(matrizResultado[i][j] + "\t");
	            }
	            System.out.println();
	        }

	        scanner.close();
	    }
	}
