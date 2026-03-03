public class Imovel {
    private float largura;
    private float comprimento;
    private float preco;

    public Imovel(float largura, float comprimento, float preco) {
        this.largura = largura;
        this.comprimento = comprimento;
        this.preco = preco;
    }

    public float getArea() {
        return largura * comprimento;
    }

    public float getPreco() {
        return preco;
    }

    public String toString() {
        return String.format("Imóvel - Área: %.2f m² | Preço: R$ %.2f", getArea(), preco);
    }
}
