import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private int idade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String toString() {
        return "Nome: " + nome + "\nIdade: " + idade;
    }

    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public static void cadastrarClientes() {
        System.out.print("Qual o nome do novo cliente? ");
        scan.nextLine();
        String nome = scan.nextLine();

        System.out.print("Qual a idade? ");
        int idade = scan.nextInt();

        Cliente novo = new Cliente(nome, idade);
        listaClientes.add(novo);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void mostrarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente c : listaClientes) {
                System.out.println(c);
                System.out.println("-------------------");
            }
        }
    }

    public static void removerCliente() {
        System.out.print("Digite o nome do cliente que deseja remover: ");
        scan.nextLine();
        String nome = scan.nextLine();

        Cliente encontrado = null;
        for (Cliente c : listaClientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                encontrado = c;
                break;
            }
        }

        if (encontrado != null) {
            listaClientes.remove(encontrado);
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
