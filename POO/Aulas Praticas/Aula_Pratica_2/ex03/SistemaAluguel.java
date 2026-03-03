package ex03;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAluguel {
    static Scanner s = new Scanner(System.in);
    static ArrayList<Carro> carros = new ArrayList<>();
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void mostrarMenu() {
        System.out.println("---Sistema de Aluguel de Carros---");
        System.out.println("O que deseja fazer? ");
        System.out.println("1-Alugar um Carro");
        System.out.println("2-Cadastrar um Carro");
        System.out.println("3-Cadastrar um Cliente");
        System.out.println("4-Mostrar Clientes Cadastrados");
        System.out.println("5-Mostrar Carros cadastrados");
        System.out.println("-1 - SAIR");
    }

    public static void alugarCarro() {
        System.out.println("---Aluguel de Carro---");
        System.out.println("Selecione um Cliente antes de Alugar o carro: ");
        mostrarClientes();
        String nome = s.nextLine();

        Cliente cliente = buscarClientePorNome(nome);
        if(cliente == null){
            System.out.println("Cliente nao foi encontrado");
            return;
        }

        System.out.println("Agora escolha um dos carros disponiveis: ");
        mostrarCarros();

        String modelo = s.nextLine();
        Carro carro = buscarCarroPorModelo(modelo);

        if(carro == null){
            System.out.println("Carro nao foi encontrado");
            return;
        }
        carro.setAlugado(true);

        Aluguel aluguel = new Aluguel(cliente, carro);
        cliente.getAlugueis().add(aluguel);
        System.out.println("Carro alugado com sucesso!");
    }

    public static Cliente buscarClientePorNome(String nome){
        for(Cliente c : clientes){
            if(c.getNome().equalsIgnoreCase(nome)){
                return c;
            }
        }
        return null;
    }

    public static Carro buscarCarroPorModelo(String modelo){
        for(Carro c : carros){
            if(c.getModelo().equalsIgnoreCase(modelo) && !c.getAlugado()){
                return c;
            }
        }
        return null;
    }

    public static void cadastrarCarro() {
        Carro c = new Carro();
        System.out.println("\n---Cadastro de Carro---\n");
        System.out.print("Modelo: ");
        c.setModelo(s.nextLine());

        System.out.print("Placa: ");
        c.setPlaca(s.nextLine());

        System.out.print("Ano: ");
        c.setAno(s.nextInt());
        s.nextLine();
        carros.add(c);

    }

    public static void cadastrarCliente() {
        Cliente c = new Cliente();
        System.out.println("\n---Cadastro Cliente---\n");
        System.out.print("Nome: ");
        c.setNome(s.nextLine());

        System.out.print("CPF: ");
        c.setCpf(s.nextLine());
        clientes.add(c);
    }

    public static void mostrarClientes() {
        if(clientes.isEmpty()){
            System.out.println("Nao ha clientes ");
        }else{
            for(Cliente c : clientes){
                System.out.println("\n---Dados de Cliente---\n");
                System.out.println(c);
            }
        }

    }

    public static void mostrarCarros() {
        if(carros.isEmpty()){
            System.out.println("Nao ha carros cadastrados para alugar!");
        }else{
            for(Carro c : carros){
                System.out.println("\n---Carros Cadastrados---\n");
                System.out.println(c);
            }
        }

    }

    public static void main(String[] args) {
        int x;

        do {
            mostrarMenu();
            x = s.nextInt();
            s.nextLine();

            switch (x) {
                case 1:

                    alugarCarro();

                    break;
                case 2:
                    cadastrarCarro();

                    break;
                case 3:
                    cadastrarCliente();

                    break;
                case 4:

                    mostrarClientes();

                    break;
                case 5:
                    mostrarCarros();

                    break;

                case -1:
                    System.out.println("Encerrando programa");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        } while (x != -1);

        s.close();

    }

}
