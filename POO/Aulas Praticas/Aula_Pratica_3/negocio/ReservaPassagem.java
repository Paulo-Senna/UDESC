package negocio;

import java.util.Scanner;
import dados.Cidade;
import dados.Cliente;
import dados.Reserva;
import java.util.ArrayList;

public class ReservaPassagem {

    static Scanner scan = new Scanner(System.in);
    private static int contadorReserva = 0;
    private static int contadorPoltrona = 10;
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    public static void cadastrarCidade() {

        System.out.println("Cadastro de Cidade\n");
        System.out.println("Digite o nome da Cidade: ");
        String nome = scan.nextLine();
        System.out.println("Digite o Estado: ");
        String Estado = scan.nextLine();
        Cidade nCidade = new Cidade(nome, Estado);
        System.out.println("Cidade Cadastrada!");

    }

    public static void cadastrarCliente() {
        System.out.println("Cadastro de Clientes\n");
        System.out.println("Digite o CPF: ");
        int cpf = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite o Nome: ");
        String nome = scan.nextLine();
        scan.nextLine();

        System.out.println("Digite o Endereco: ");
        String endereco = scan.nextLine();

        System.out.println("Digite o Telefone: ");
        int telefone = scan.nextInt();
        scan.nextInt();

        Cliente nCliente = new Cliente(cpf, nome, endereco, telefone);
        System.out.println("Cliente Cadastrado!");

    }

    public static void fazerReserva() {

        int nreserva = ++contadorReserva;
        int poltrona = contadorPoltrona++;

        System.out.println("Fazendo sua Reserva...\n");
        System.out.println("Que dia voce pretende viajar? ");
        String data = scan.nextLine();

        System.out.println("Que horas? ");
        String hora = scan.nextLine();

        System.out.println("Gostaria de reservar a volta?(s/n)");
        String res = scan.next().toLowerCase();
        boolean idaVolta = res.equals("s");
        scan.nextLine();

        System.out.println("Qual a classe que voce deseja?\n");
        System.out.println("1-Primeira Classe - R$3000");
        System.out.println("2-Executiva - R$1500");
        System.out.println("3-Comercial - R$10 (promocao!!!!)");
        int c = scan.nextInt();
        String classe;
        float preco;
        if (c == 1) {

            System.out.println("Primeira classe selecionada!!");
            classe = "Primeira_Classe";
            preco = 3000;

        } else if (c == 2) {

            System.out.println("Classe executiva selecionada!!");
            classe = "Executiva";
            preco = 1500;

        } else if (c == 3) {
            System.out.println("Classe comercial selecionada!!");
            classe = "Comercial";
            preco = 10;

        } else {
            System.out.println("Opcao nao disponivel!");
            System.out.println("Classe comercial selecionada");
            classe = "Comercial";
            preco = 10;
        }
        Reserva novaReserva = new Reserva(nreserva, data, hora, preco, classe, idaVolta, poltrona);
        reservas.add(novaReserva);
        System.out.println("Reserva realizada!\n");

    }

    public static void mostrarReservas() {
        System.out.println("Reservas feitas:");
        for (Reserva r : reservas) {
            System.out.println(r);
        }

    }
}
