public class Aluno {
    private String nome;
    private int idade;
    private double[] notas;

    public Aluno(String nome, int idade, double[] notas) {
        this.nome = nome;
        this.idade = idade;
        this.notas = notas;
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public String toString() {
        return "Nome: " + nome + ", " +"Idade: " +idade + " anos, média: " + String.format("%.2f", calcularMedia());
    }
}
