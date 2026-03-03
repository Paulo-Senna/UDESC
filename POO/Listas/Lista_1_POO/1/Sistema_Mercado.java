import java.util.Scanner;
import data.Cliente;
import data.Estoque;
import data.Financas;
import data.Funcionario;
import data.Produto;

public class Sistema_Mercado {

    public void exibirInterf() {
        System.out.println("\nBem vindo ao Sistema de SuperMercado Baldo!");
        System.out.println("O que deseja fazer? \n");
        System.out.println("1-Cliente");
        System.out.println("2-Funcionario");
        System.out.println("3-Produto");
        System.out.println("4-Estoque");
        System.out.println("5-Financas");
        System.out.println("6-Fechar Programa");

    }

    public static void exibirCliente() {

        System.out.println("Area do Cliente");
        System.out.println("O que deseja fazer? \n");
        System.out.println("1-Cadastrar Cliente");
        System.out.println("2-Mostrar Clientes Cadastrados");
        System.out.println("3-Remover Cliente");
        System.out.println("4-Voltar");
    }

    public static void exibirFuncionario() {

        System.out.println("Area do Funcionario");
        System.out.println("O que deseja fazer?\n");
        System.out.println("1-Cadastrar Funcionario");
        System.out.println("2-Mostrar Funcionarios");
        System.out.println("3-Demitir funcionario ");
        System.out.println("4-Voltar");
    }

    public static void exibirProduto() {
        System.out.println("Area dos Produtos");
        System.out.println("O que deseja fazer?\n");
        System.out.println("1-Cadastrar Produtos");
        System.out.println("2-Procurar preco de Produto");
        System.out.println("3-Adicionar lista de produtos faltando");
        System.out.println("4-Voltar");

    }

    public static void exibirEstoque() {
        System.out.println("Area do Estoque");
        System.out.println("O que deseja fazer?\n");
        System.out.println("1-Ver Produtos em Estoque");
        System.out.println("2-Ver Lista de Produtos faltando");
        System.out.println("3-Voltar");

    }

    public static void exibirFinancas() {
        System.out.println("Area Financas");
        System.out.println("O que deseja fazer? \n");
        System.out.println("1-Mostrar Gastos");
        System.out.println("2-Mostrar Ganhos");
        System.out.println("3-Voltar");

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Sistema_Mercado sistema = new Sistema_Mercado();

        int x;
        do {
            sistema.exibirInterf();
            x = scan.nextInt();
            scan.nextInt();
            int y;

            switch (x) {
                case 1:
                    exibirCliente();
                    y = scan.nextInt();
                    scan.nextInt();
                    switch (y) {
                        case 1:
                            Cliente.cadastrarClientes();

                            break;
                        case 2:
                            Cliente.mostrarClientes();
                            break;
                        case 3:
                            Cliente.removerCliente();
                            break;
                        case 4:
                            System.out.println("Voltando...");
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                            break;
                    }

                    break;
                case 2:
                    exibirFuncionario();
                    y = scan.nextInt();
                    scan.nextInt();

                    switch (y) {
                        case 1:

                            Funcionario.cadastrarFuncionario();

                            break;
                        case 2:
                            Funcionario.mostrarFuncionarios();
                            break;
                        case 3:
                            Funcionario.demitirFuncionario();
                            break;
                        case 4:
                            System.out.println("voltanod...");
                            break;

                        default:
                            System.out.println("Opcao invalida!");
                            break;
                    }

                    break;

                case 3:
                    exibirProduto();
                    y = scan.nextInt();
                    scan.nextInt();

                    switch (y) {
                        case 1:
                            Produto.cadastrarProduto();

                            break;
                        case 2:
                            Produto.procurarPrecoProduto();
                            break;
                        case 3:
                            Produto.adicionarFaltando();
                            break;
                        case 4:
                            System.out.println("Voltando...");
                            break;

                        default:
                            System.out.println("Opcao invalida");
                            break;
                    }

                    break;
                case 4:
                    exibirEstoque();
                    y = scan.nextInt();
                    scan.nextInt();

                    switch (y) {
                        case 1:
                            Estoque.verProdutosEmEstoque();

                            break;
                        case 2:
                            Estoque.verProdutosFaltando();
                            break;
                        case 3:
                            System.out.println("Voltando...");
                            break;

                        default:
                            System.out.println("Opcao invalida");
                            break;
                    }

                    break;
                case 5:
                    exibirFinancas();
                    y = scan.nextInt();
                    scan.nextInt();

                    switch (y) {
                        case 1:
                            Financas.mostrarGastos();
                            break;
                        case 2:
                            Financas.mostrarGanhos();
                            break;
                        case 3:
                            System.out.println("Voltando");
                        default:
                            System.out.println("Opcao invalida");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("encerrando o programa...");
                    break;

                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }
        } while (x != 6);

        scan.close();
    }

}
