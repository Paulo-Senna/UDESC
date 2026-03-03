package ex01;
import java.util.ArrayList;
import java.util.Comparator;


public class Grupo {
    private ArrayList<Pessoa> listaAlunos = new ArrayList<>();

    public void adicionarAluno(Pessoa p){
        listaAlunos.add(p);

    }

    public void removerAluno(String nome){
        listaAlunos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

     public void mostrarAlunos() {
        // Ordenar por IMC (maior para menor)
        listaAlunos.sort(Comparator.comparingDouble(Pessoa::calculaIMC).reversed());

        for (Pessoa p : listaAlunos) {
            System.out.println(p.toString());
            System.out.println("-------------------------");
        }
    }
}
