import java.util.Scanner;

public class Data{

    private int dia, mes, ano;
    private static final Scanner sc = new Scanner(System.in);
    private static final String[] MESES = {
        "janeiro", "fevereiro", "março", "abril", "maio", "junho",
        "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"
    };

    public Data() {
        System.out.print("Ano: ");
        ano = lerInteiroMaiorQue(0);
        System.out.print("Mês: ");
        mes = lerInteiroEntre(1, 12);
        System.out.print("Dia: ");
        dia = lerDiaValido();
    }

    public Data(int d, int m, int a) {
        if (!valida(d, m, a)) throw new IllegalArgumentException("Data inválida");
        dia = d; mes = m; ano = a;
    }

    private int lerDiaValido() {
        while (true) {
            int d = lerInteiroEntre(1, 31);
            if (valida(d, mes, ano)) return d;
            System.out.print("Dia inválido, digite novamente: ");
        }
    }

    private static int lerInteiroEntre(int min, int max) {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine());
                if (val >= min && val <= max) return val;
            } catch (Exception e) {}
            System.out.print("Valor inválido, tente novamente: ");
        }
    }

    private static int lerInteiroMaiorQue(int min) {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine());
                if (val > min) return val;
            } catch (Exception e) {}
            System.out.print("Valor inválido, tente novamente: ");
        }
    }

    public boolean bissexto() {
        return (ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0);
    }

    public int diasNoAno() {
        int total = dia;
        for (int i = 1; i < mes; i++)
            total += diasDoMes(i, ano);
        return total;
    }

    public String formato1() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    public String formato2() {
        return dia + " de " + MESES[mes - 1] + " de " + ano;
    }

    private static boolean valida(int d, int m, int a) {
        return a > 0 && m >= 1 && m <= 12 && d >= 1 && d <= diasDoMes(m, a);
    }

    private static int diasDoMes(int m, int a) {
        return switch (m) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> (new DataSimples(1, 1, a).bissexto() ? 29 : 28);
            default -> 31;
        };
    }

    public static void main(String[] args) {
        System.out.println("** Data interativa **");
        DataSimples d1 = new DataSimples();
        System.out.println("Formato 1: " + d1.formato1());
        System.out.println("Formato 2: " + d1.formato2());
        System.out.println("Bissexto?  " + d1.bissexto());
        System.out.println("Dias no ano: " + d1.diasNoAno());

        System.out.println("\n** Data fixa **");
        DataSimples natal = new DataSimples(25, 12, 2025);
        System.out.println("Formato 1: " + natal.formato1());
        System.out.println("Formato 2: " + natal.formato2());
        System.out.println("Bissexto?  " + natal.bissexto());
        System.out.println("Dias no ano: " + natal.diasNoAno());
    }
}
