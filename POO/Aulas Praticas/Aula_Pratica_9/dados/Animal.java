package dados;

public class Animal {
    private String nome;
    private String cor;
    private int idade;
    private int largura;
    private int comprimento;
    private int altura;

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public int getIdade() {
        return idade;
    }

    public int getLargura() {
        return largura;
    }

    public int getComprimento() {
        return comprimento;
    }

    public int getAltura() {
        return altura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public float calculaEspacoOcupado() {
        return largura * comprimento * altura;
    }

    public String toString() {
        return "Nome: " + nome + ", Cor: " + cor + ", Idade: " + idade + "\n";
    }
}
