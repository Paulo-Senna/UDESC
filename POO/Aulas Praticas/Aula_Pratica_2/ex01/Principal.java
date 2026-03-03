package ex01;

import java.util.Scanner;

public class Principal {

    static Scanner s = new Scanner(System.in);
    static Grupo grupo = new Grupo();

    public static void mostrarOpcoes() {
        System.out.println("Bem vindo ao Sistema de Academia!\n");
        System.out.println("O que gostaria de fazer? ");
        System.out.println("1-Cadatrar Aluno");
        System.out.println("2-Remover Aluno");
        System.out.println("3-Mostrar Alunos cadastrados");
        System.out.println("-1-Sair");
    }

    public static void cadastrarAluno() {
        Pessoa p = new Pessoa();

        System.out.println("Digite os seguintes elementos para cadastrar o Aluno: \n");
        System.out.print("Nome: ");
        p.setNome(s.nextLine());

        System.out.print("Idade: ");
        p.setIdade(s.nextInt());

        System.out.print("Altura: ");
        p.setAltura(s.nextFloat());

        System.out.print("Massa: ");
        p.setMassa(s.nextFloat());

        grupo.adicionarAluno(p);

    }

    public static void removerAluno() {
        System.out.println("Digite o nome do aluno para ser removido: ");
        String nome = s.nextLine();
        grupo.removerAluno(nome);
        System.out.println("Aluno removido");

    }

    public static void mostrarAlunos() {
        System.out.println("Lista de Alunos em ordem de IMC");
        grupo.mostrarAlunos();
    }

    public static void main(String[] args) {

        int x;
        do {
            mostrarOpcoes();
            x = s.nextInt();
            s.nextLine();

            switch (x) {
                case 1:
                    cadastrarAluno();

                    break;
                case 2:
                    removerAluno();
                    break;

                case 3:
                    mostrarAlunos();
                    break;

                default:

                    System.out.println("opcao invalida!");
                    break;
            }
        } while (x != -1);

        s.close();
    }
}
