package ex02;
import java.util.ArrayList;
import java.util.Scanner;

public class SisemaPetShop {
    static Scanner s = new Scanner(System.in);
    static ArrayList<Animal> animais = new ArrayList<>();
    static ArrayList<Veterinario> veterinarios = new ArrayList<>();
    private int quantidadeDeVeterinarios = veterinarios.size();

    public static void mostrarMenu() {
        System.out.println("\n--Sistema PetShop--\n");
        System.out.println("1-Cadastrar Veterinario");
        System.out.println("2-Mostrar Veterinarios");
        System.out.println("3-Cadastrar Animal");
        System.out.println("4-Mostrar Animais Cadastrados");
        System.out.println("-1 - SAIR");
    }

    public static void cadastrarVeterinario() {
        Veterinario vet = new Veterinario();

        System.out.print("\n---Cadastro Veterinario---\n");
        System.out.print("Nome: ");
        vet.setNome(s.nextLine());

        System.out.print("Salario: ");
        vet.setSalario(s.nextFloat());
        s.nextLine();

        System.out.print("Endereco do Veterinario: ");
        s.setEndereco(cadastrarEndereco());

        veterinarios.add(vet);

    }

    public static void mostrarVeterinarios() {
        if (veterinarios.isEmpty()) {
            System.out.println("Nenhum Veterinario cadastrado!");
        } else {
            for (Veterinario v : veterinarios) {
                System.out.println(v.getNome());
                System.out.println("Salario: "+ v.getSalario());
                System.out.println(v.getEndereco());
                System.out.println("--------------");
            }
        }

    }

    public static void cadastrarAnimal() {
        Animal a = new Animal();
        System.out.println("---Cadastro Animal--- \n");
        System.out.print("Nome: ");
        a.setNome(s.nextLine());

        System.out.print("Especie: ");
        a.setEspecie(s.nextLine());

        System.out.print("Decricao: ");
        a.setDescricao(s.nextLine());
        Dono dono = new Dono();

        System.out.println("---Cadastro Dono---");
        System.out.println("Nome do Dono: ");
        dono.setNome(s.nextLine());
        System.out.println("Endereco: ");
        dono.setEndereco(cadastrarEndereco());
        System.out.print("CPF: ");
        dono.setCpf(s.nextLine());
        a.setDono(dono);
        animais.add(a);
        System.out.println("Animal cadastrado!\n");

    }

    public static Endereco cadastrarEndereco() {
        Endereco e = new Endereco();
        System.out.print("Rua: ");
        e.setRua(s.nextLine());

        System.out.print("Numero: ");
        e.setNumero(s.nextInt());
        s.nextLine();

        System.out.print("Bairro: ");
        e.setBairro(s.nextLine());

        System.out.print("Cidade: ");
        e.setCidade(s.nextLine());

        System.out.print("Estado: ");
        e.setEstado(s.nextLine());

        System.out.print("CEP: ");
        e.setCep(s.nextInt());
        s.nextLine();
        return e;

    }

    public static void mostrarAnimais(){
        if(animais.isEmpty()){
            System.out.println("Nao ha animais cadastrados no sistema");
        }else{
            for(Animal a : animais){
                System.out.println(a.toString());
                System.out.println("----------");
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
                    cadastrarVeterinario();

                    break;
                case 2:
                    mostrarVeterinarios();

                    break;

                case 3:
                    cadastrarAnimal();
                    break;
                case 4:
                    mostrarAnimais();
                    break;

                case -1:
                    System.out.println("Encerrando programa");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

        } while (x != -1);
        s.close();
    }

}