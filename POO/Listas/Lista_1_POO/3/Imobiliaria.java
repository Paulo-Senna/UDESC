import java.util.ArrayList;
import java.util.Comparator;

public class Imobiliaria {
    private String nome;
    private ArrayList<Imovel> imoveis;

    public Imobiliaria(String nome) {
        this.nome = nome;
        this.imoveis = new ArrayList<>();
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public Imovel[] filtrarPorArea(float x) {
        return imoveis.stream()
            .filter(im -> im.getArea() >= x)
            .sorted(Comparator.comparing(Imovel::getPreco))
            .toArray(Imovel[]::new);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imobiliária: " + nome + "\nLista de imóveis:\n");
        for (Imovel imovel : imoveis) {
            sb.append(imovel.toString()).append("\n");
        }
        return sb.toString();
    }
}
