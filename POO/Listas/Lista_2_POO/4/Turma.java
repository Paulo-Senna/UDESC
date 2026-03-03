import java.util.*;

public class Turma {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    private void ordenarAlunosPorMedia() {
        alunos.sort(Comparator.comparingDouble(Aluno::calcularMedia));
    }

    public List<Equipe> separarEmEquipes() {
        ordenarAlunosPorMedia();
        List<Equipe> equipes = new ArrayList<>();
        int equipeNum = 1;

        LinkedList<Aluno> fila = new LinkedList<>(alunos);

        while (!fila.isEmpty()) {
            List<Aluno> equipe = new ArrayList<>();

            if (fila.size() >= 4) {
                equipe.add(fila.removeFirst());
                equipe.add(fila.removeFirst());
                equipe.add(fila.removeLast());
                equipe.add(fila.removeLast());
            } else if (fila.size() == 3) {
                equipe.add(fila.removeFirst());
                equipe.add(fila.removeLast());
                equipe.add(fila.removeFirst());
            } else {
                while (!fila.isEmpty()) {
                    equipe.add(fila.removeFirst());
                }
            }

            equipes.add(new Equipe(String.valueOf(equipeNum++), equipe));
        }

        return equipes;
    }
}
