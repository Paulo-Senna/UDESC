package apresentacao;

import dados.Contato;
import negocio.ListaTelefonica;
import java.util.Scanner;
import java.util.List;

public class Principal {
    Scanner scan = new Scanner(System.in);
    private ListaTelefonica lista = new ListaTelefonica();

    public ListaTelefonica getLista() {
        return lista;
    }

    public void setLista(ListaTelefonica lista) {
        this.lista = lista;
    }

    public int menu() {
        System.out.println("\n1 - Adicionar contato");
        System.out.println("2 - Excluir Contato");
        System.out.println("3 - Listar Contatos");
        System.out.println("4 - Excluir Contatos de uma letra");
        System.out.println("0 - Sair");
        return Integer.parseInt(scan.nextLine());
    }

    public void executar() {
        int opcao;

        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    exibirContatos();
                    break;
                case 4:
                    removerTodosPorInicial();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void adicionarContato() {
        Contato c = new Contato();
        System.out.print("Nome: ");
        c.setNome(scan.nextLine());
        System.out.print("Telefone: ");
        c.setTelefone(scan.nextLine());
        lista.adicionarContato(c);
        System.out.println("Contato adicionado");
    }

    private void exibirContatos() {
        System.out.println("\nContatos:");
        System.out.println(lista);
    }

    private void removerContato() {
        System.out.print("Digite a inicial do nome: ");
        char inicial = scan.nextLine().toUpperCase().charAt(0);
        List<Contato> contatos = lista.buscarContatos(inicial);

        if (contatos == null || contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado com essa inicial.");
            return;
        }

        System.out.println("Contatos com inicial " + inicial + ":");
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println((i + 1) + " - " + contatos.get(i));
        }

        System.out.print("Escolha o número do contato para remover: ");
        int escolha = Integer.parseInt(scan.nextLine());

        if (escolha < 1 || escolha > contatos.size()) {
            System.out.println("Escolha inválida");
        } else {
            Contato removido = contatos.get(escolha - 1);
            lista.removerContato(removido);
            System.out.println("Contato removido");
        }
    }

    private void removerTodosPorInicial() {
        System.out.print("Digite a inicial: ");
        char inicial = scan.nextLine().toUpperCase().charAt(0);
        List<Contato> contatos = lista.buscarContatos(inicial);

        if (contatos == null || contatos.isEmpty()) {
            System.out.println("Nenhum contato com essa inicial");
        } else {
            contatos.clear();
            System.out.println("Todos os contatos com inicial " + inicial + " foram removidos");
        }
    }

    //achei essa forma diferente de iniciar a main
    public static void main(String[] args) {
        new Principal().executar();
    }
}
