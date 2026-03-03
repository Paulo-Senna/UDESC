import java.util.List;

public class Equipe {
    private String nome;
    private List<Aluno> membros;

    public Equipe(String nome, List<Aluno> membros) {
        this.nome = nome;
        this.membros = membros;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Equipe " + nome + ":\n");
        for (Aluno a : membros) {
            sb.append("  ").append(a.toString()).append("\n");
        }
        return sb.toString();
    }
}
