import java.util.List;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        Gerador gerador;
        List<Integer> resultado;

        // Fibonacci
        gerador = new Fibonacci();
        gerador.gerar(random(50));
        resultado = gerador.getSequencia();
        imprimir("Fibonacci", resultado);

        // Naturais
        gerador = new Naturais();
        gerador.gerar(random(50));
        resultado = gerador.getSequencia();
        imprimir("Naturais", resultado);

        // Perfeitos
        gerador = new Perfeitos();
        gerador.gerar(random(50));
        resultado = gerador.getSequencia();
        imprimir("Perfeitos", resultado);

        // Quadrados
        gerador = new Quadrados();
        gerador.gerar(random(50));
        resultado = gerador.getSequencia();
        imprimir("Quadrados", resultado);

        // Abundantes
        gerador = new Abundantes();
        gerador.gerar(random(50));
        resultado = gerador.getSequencia();
        imprimir("Abundantes", resultado);

        // Primos
        gerador = new Primos();
        gerador.gerar(random(50));
        resultado = gerador.getSequencia();
        imprimir("Primos", resultado);

        // Fatoriais
        gerador = new Fatoriais();
        gerador.gerar(random(12)); 
        resultado = gerador.getSequencia();
        imprimir("Fatoriais", resultado);
    }

    public static void imprimir(String tipo, List<Integer> seq){
        if(seq.size() < 1){
            System.out.println("\n" + tipo + " de " + seq.size() + ": [ ]" );
        } else {
            System.out.print("\n" + tipo + " de " + seq.size() + ": [");
            for(int i = 0; i < seq.size() - 1; i++){
                System.out.print(seq.get(i) + ", ");
            }
            System.out.println(seq.get(seq.size() - 1) + "]");
        }
    }

    public static int random(int n){
        Random r = new Random();
        return r.nextInt(n) + 1; 
    }
}
