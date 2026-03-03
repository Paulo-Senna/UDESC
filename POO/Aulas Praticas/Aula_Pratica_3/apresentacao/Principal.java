package apresentacao;

import java.util.Scanner;

import negocio.ReservaPassagem;

public class Principal {

    

    public static void exibirInterface() {
        System.out.println("Bem vindo ao Sistema de Cadastros do Baldo!");
        System.out.println("O que deseja fazer?");
        System.out.println("1-Fazer Reserva");
        System.out.println("2-Cadastrar Cliente");
        System.out.println("3-Cadastrar Cidade");
        System.out.println("4-Mostrar Reservas");
        System.out.println("0-Sair");

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x;
        do {
            exibirInterface();
            x = scan.nextInt();
            scan.nextInt();

            switch (x) {
                case 1:

                    ReservaPassagem.fazerReserva();

                    break;
                case 2:
                    ReservaPassagem.cadastrarCliente();

                    break;

                case 3:
                    ReservaPassagem.cadastrarCidade();

                    break;

                case 4:
                    ReservaPassagem.mostrarReservas();

                    break;

                case 0:
                    System.out.println("Fechando programa!");
                    break;
                default:
                    break;
            }

        } while (x != 0);
        scan.close();

    }

  
}
