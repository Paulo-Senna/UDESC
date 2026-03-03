public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private int idade;
    private String cpf;
    private String cidade;

    public Pessoa(String nome, int idade, String cpf, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public FaixaEtaria getFaixaEtaria() {
        if (idade >= 1 && idade <= 12) return FaixaEtaria.CRIANCA;
        else if (idade <= 18) return FaixaEtaria.ADOLESCENTE;
        else if (idade <= 25) return FaixaEtaria.JOVEM;
        else if (idade <= 59) return FaixaEtaria.ADULTO;
        else return FaixaEtaria.IDOSO;
    }

    public int compareTo(Pessoa outra) {
        return this.nome.compareToIgnoreCase(outra.nome);
    }

    public String toString() {
        return String.format("- %s, %d, %s, %s;", nome, idade, cpf, cidade);
    }
}
