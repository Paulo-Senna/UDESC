public class Estoque {

    public static void verProdutosEmEstoque() {
        if (Produto.getProdutos().isEmpty()) {
            System.out.println("Nenhum produto em estoque.");
        } else {
            for (Produto p : Produto.getProdutos()) {
                System.out.println(p);
                System.out.println("-------------------");
            }
        }
    }

    public static void verProdutosFaltando() {
        if (Produto.getFaltando().isEmpty()) {
            System.out.println("Nenhum produto faltando.");
        } else {
            for (String nome : Produto.getFaltando()) {
                System.out.println("Produto faltando: " + nome);
            }
        }
    }
}
