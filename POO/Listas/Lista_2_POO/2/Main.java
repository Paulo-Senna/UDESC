import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número de linhas: ");
        int n = sc.nextInt();
        System.out.print("Digite o número de colunas: ");
        int m = sc.nextInt();

        Matriz<Integer> matriz = new Matriz<>(n, m);

        System.out.println("Digite os elementos da matriz (" + n + "x" + m + "):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                int valor = sc.nextInt();
                matriz.set(valor, i, j);
            }
        }

        while (true) {
            System.out.print("\nDigite o quadrante para exibir (PRIMEIRO, SEGUNDO, TERCEIRO, QUARTO) ou SAIR: ");
            String entrada = sc.next().toUpperCase();

            if (entrada.equals("SAIR")) {
                break;
            }

            try {
                Quadrante q = Quadrante.valueOf(entrada);
                List<Integer> elementos = matriz.getElementosQuadrante(q);
                System.out.println("Elementos do " + q + ":");
                for (Integer valor : elementos) {
                    System.out.print(valor + " ");
                }
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("Quadrante inválido. Tente novamente.");
            }
        }

        sc.close();
    }
}
