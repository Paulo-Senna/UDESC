public class Financas {

    public static void mostrarGastos() {
        double total = 0;
        for (Funcionario f : Funcionario.funcionarios) {
            total += f.getSalario();
        }
        System.out.println("Total de gastos com funcionarios: R$ " + total);
    }

    public static void mostrarGanhos() {
        double total = 0;
        for (Produto p : Produto.getProdutos()) {
            total += p.getPreco();
        }
        System.out.println("Estimativa de ganhos com produtos: R$ " + total);
    }
}
