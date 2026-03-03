import java.util.Scanner;
import dados.Contato;
import negocio.ListaTelefonica;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static ListaTelefonica lista = new ListaTelefonica();

    public static Contato cadastrarContato() {
        System.out.println("Digite o nome do Contato: ");
        String nome = s.nextLine();
        s.nextLine();

        System.out.println("Digite o telefone do contato: ");
        int telefone = s.nextInt();

        Contato c = new Contato();
        c.setNome(nome);
        c.setTelefone(telefone);

        return c;

    }

    public void removerPessoa() {
        System.out.println("Escolha uma letra que deseja remover: ");

        String entrada = s.next().toUpperCase();

        if (lista.buscarContatos(entrada.charAt(0)).size() > 0) {
            exibirContatos(entrada, charAt(0));

            System.out.println("Escolha um contato para remover: ");
            int index = s.nextInt();

            if (index < lista.buscarContatos(entrada.charAt(0)).size()) {

                lista.removeContato(lista.buscarContatos(entrada.charAt(0)).get(index));
            }
        } else {
            System.out.println("Nao existem contatos removiveis");
        }

    }

    public void mostrarPessoas() {

        lista.buscarContatos().forEach((chave, lista) -> {
            System.out.println(chave + ":");
            for (Contato contato : lista) {
                System.out.println(" " + contato.toString());

            }
        });

    }

    public static void mostrarContatos(char letra) {
        for (int i = 0; i < lista.buscarContatos(letra).size(); i++) {
            System.out.println("Codigo: " + i);
            System.out.println(lista.bucarContatos(letra).get(i).toString());
        }
    }

    public static void main(String[] args) {
        int x = -1;
        while (x != 0) {
            System.out.println("Escolha: ");
            System.out.println("1 - Cadastrar um Contato");
            System.out.println("2 - Remover um Contato");
            System.out.println("3 - Mostrar todos os contatos");
            System.out.println("0-Sair");
            x = s.nextInt();
            s.nextInt();

            switch (x) {
                case 0:
                    break;
                case 1:
                    Contato contato = novoContato();
                    lista.adicionarContato(contato);
                    break;

                case 2:
                    removerContato();

                    break;
                case 3:
                    exibirContatos();

                    break;

                default:
                    System.out.println("opcao invalida");
                    break;
            }
        }

    }
}