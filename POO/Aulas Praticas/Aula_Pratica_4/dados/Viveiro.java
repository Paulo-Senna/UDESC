package dados;

public class Viveiro {
    private String nome;
    private float comprimento;
    private float largura;
    protected Animal[] animais = new Animal[100];
    protected int quantAnimais = 0;

    public String getNome() {
        return nome;
    }

    public float getComprimento() {
        return comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float calculaEspaco() {
        return comprimento * largura;
    }

    public float espacoOcupado() {
        float area = 0;
        for (int i = 0; i < quantAnimais; i++) {
            area += animais[i].calculaEspacoOcupado();
        }
        return area;
    }

    public float espacoDisponivel() {
        return calculaEspaco() - espacoOcupado();
    }

    public boolean adicionarAnimal(Animal animal) {
        if (espacoDisponivel() >= animal.calculaEspacoOcupado() * 0.7f) {
            if (!(animal instanceof Peixe)) {
                animais[quantAnimais] = animal;
                quantAnimais++;
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuffer string = new StringBuffer();
        string.append("Viveiro\n");
        string.append("Nome: " + nome + "\n");
        string.append("Comprimento: " + comprimento + ", Largura: " + largura + "\n");
        for (int i = 0; i < quantAnimais; i++) {
            string.append("\t" + animais[i].toString());
        }
        return string.toString();
    }
}
