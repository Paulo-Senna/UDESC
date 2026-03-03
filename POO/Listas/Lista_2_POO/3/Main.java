import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Matriz<Integer> matriz = new Matriz<>(5, 5);

        System.out.println("-1 encerra a contagem!!");
        System.out.println("Digite os valores da matriz (5x5): ");

        int contador = 0;
        boolean interrompido = false;
        for (int i = 0; i < 5 && !interrompido; i++) {
            for (int j = 0; j < 5 && !interrompido; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                int valor = scan.nextInt();
                if (valor == -1) {
                    interrompido = true;
                } else {
                    matriz.set(valor, i, j);
                    contador++;
                }
            }
        }

        if (contador == 0) {
            System.out.println("Nenhum valor inserido");
            return;
        }

        Integer menorGeral = null;

        for (Quadrante q : Quadrante.values()) {
            List<Integer> elementos = matriz.getElementosQuadrante(q);
            Integer menor = elementos.stream()
                                     .filter(Objects::nonNull)
                                     .min(Integer::compareTo)
                                     .orElse(null);

            if (menor != null) {
                if (menorGeral == null || menor < menorGeral) {
                    menorGeral = menor;
                }
            }
        }

        if (menorGeral != null) {
            System.out.println("Menor elemento entre todos os quadrantes: " + menorGeral);
        } else {
            System.out.println("Nenhum elemento válido foi inserido");
        }

        scan.close();
    }
}
