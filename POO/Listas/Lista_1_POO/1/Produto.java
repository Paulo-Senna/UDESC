import java.util.ArrayList;
import java.util.Scanner;

public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public String toString() {
        return "Produto: " + nome + "\nPreço: R$ " + preco;
    }

    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static ArrayList<String> faltando = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public static void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        scan.nextLine();
        String nome = scan.nextLine();

        System.out.print("Preço: ");
        double preco = scan.nextDouble();

        produtos.add(new Produto(nome, preco));
        System.out.println("Produto cadastrado!");
    }

    public static void procurarPrecoProduto() {
        System.out.print("Nome do produto: ");
        scan.nextLine();
        String nome = scan.nextLine();

        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Preço: R$ " + p.getPreco());
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public static void adicionarFaltando() {
        System.out.print("Nome do produto faltando: ");
        scan.nextLine();
        String nome = scan.nextLine();

        faltando.add(nome);
        System.out.println("Produto adicionado à lista de faltando.");
    }

    public static ArrayList<String> getFaltando() {
        return faltando;
    }

    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }
}
