import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario){
        this.salario = salario;

    }

    public String toString() {
        return "Nome: " + nome + "\nSalario: R$ " + salario;
    }

    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public static void cadastrarFuncionario() {
        System.out.print("Nome do funcionario: ");
        scan.nextLine();
        String nome = scan.nextLine();

        System.out.print("Salario: ");
        double salario = scan.nextDouble();

        funcionarios.add(new Funcionario(nome, salario));
        System.out.println("Funcionario cadastrado.");
    }

    public static void mostrarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
        } else {
            for (Funcionario f : funcionarios) {
                System.out.println(f);
                System.out.println("-------------------");
            }
        }
    }

    public static void demitirFuncionario() {
        System.out.print("Digite o nome do funcionario para demitir: ");
        scan.nextLine();
        String nome = scan.nextLine();

        Funcionario removido = null;
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                removido = f;
                break;
            }
        }

        if (removido != null) {
            funcionarios.remove(removido);
            System.out.println("Funcionario demitido.");
        } else {
            System.out.println("Funcionario não encontrado.");
        }
    }
}
