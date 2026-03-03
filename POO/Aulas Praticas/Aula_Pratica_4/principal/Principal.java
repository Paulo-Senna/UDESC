import dados.*;
import java.util.Scanner;

public class Principal {
    public static void Interface() {
        System.out.println("ZOOLOGICO");
        System.out.println("1 - Cadastrar Viveiro");
        System.out.println("2 - Cadastrar Aquário");
        System.out.println("3 - Cadastrar Animal");
        System.out.println("4 - Alocar Animal");
        System.out.println("5 - Mostrar Viveiros");
        System.out.println("0 - Sair");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Zoologico zoo = new Zoologico();
        int opcao;

        do {
            Interface();
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1: {
                    Viveiro v = new Viveiro();
                    System.out.print("Nome do viveiro: ");
                    v.setNome(scan.nextLine());

                    System.out.print("Comprimento: ");
                    v.setComprimento(scan.nextFloat());

                    System.out.print("Largura: ");
                    v.setLargura(scan.nextFloat());

                    zoo.cadastrarViveiro(v);
                    break;
                }

                case 2: {
                    Aquario a = new Aquario();
                    System.out.print("Nome do aquário: ");
                    a.setNome(scan.nextLine());

                    System.out.print("Comprimento: ");
                    a.setComprimento(scan.nextFloat());

                    System.out.print("Largura: ");
                    a.setLargura(scan.nextFloat());

                    System.out.print("Altura: ");
                    a.setAltura(scan.nextFloat());

                    System.out.print("Temperatura: ");
                    a.setTemperatura(scan.nextFloat());

                    zoo.cadastrarViveiro(a);
                    break;
                }

                case 3: {
                    System.out.print("O animal é um peixe? (s/n): ");
                    char tipo = scan.next().charAt(0);
                    scan.nextLine();

                    Animal animal;
                    if (tipo == 's') {
                        Peixe peixe = new Peixe();
                        System.out.print("Temperatura ideal: ");
                        peixe.setTempIdeal(scan.nextFloat());
                        animal = peixe;
                    } else {
                        animal = new Animal();
                    }

                    scan.nextLine();
                    System.out.print("Nome: ");
                    animal.setNome(scan.nextLine());

                    System.out.print("Cor: ");
                    animal.setCor(scan.nextLine());

                    System.out.print("Idade: ");
                    animal.setIdade(scan.nextInt());

                    System.out.print("Largura: ");
                    animal.setLargura(scan.nextInt());

                    System.out.print("Comprimento: ");
                    animal.setComprimento(scan.nextInt());

                    System.out.print("Altura: ");
                    animal.setAltura(scan.nextInt());

                    break;
                }

                case 4: {
                    System.out.println("Alocar manualmente via código para fins didáticos.");
                    break;
                }

                case 5: {
                    for (Viveiro v : zoo.getTodosViveiros()) {
                        if (v != null) System.out.println(v.toString());
                    }
                    break;
                }

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scan.close();
    }
}
