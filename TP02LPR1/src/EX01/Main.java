package EX01;
import java.util.Scanner;

/* Paulo Eduardo da Silva Pessoa
 * João do Valle Seixas Paula
 * Entrar com dois valores via teclado, onde o segundo valor deverá ser maior que o primeiro.
Caso contrário solicitar novamente apenas o segundo valor.
 */
 
public class Main {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int primeiroValor, segundoValor;

        System.out.print("Digite o primeiro valor: ");
        primeiroValor = scanner.nextInt();

        do {
            System.out.print("Digite o segundo valor (maior que o primeiro): ");
            segundoValor = scanner.nextInt();

            if (segundoValor <= primeiroValor) {
                System.out.println("O segundo valor deve ser maior que o primeiro. Tente novamente.");
            }

        } while (segundoValor <= primeiroValor);

        System.out.println("Valores inseridos com sucesso!");
        System.out.println("Primeiro valor: " + primeiroValor);
        System.out.println("Segundo valor: " + segundoValor);

        scanner.close();
    }
}
