package ex04;

import java.util.Scanner;
import java.util.ArrayList;

public class SistemaBiblioteca {
    static Scanner s = new Scanner(System.in);
    static ArrayList<Livro> livros = new ArrayList<>();
    static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void mostrarMenu() {
        System.out.println("\n---SISTEMA BIBLIOTECA---\n");
        System.out.println("Escolha: ");
        System.out.println("1-Cadastrar pessoa");
        System.out.println("2-Cadastrar Livro");
        System.out.println("3-Realizar emprestimo");
        System.out.println("4-Mostrar pessoas");
        System.out.println("5-Mostrar livros");
        System.out.println("6-Mostrar Emprestimos de uma pessoa");
        System.out.println("-1 - SAIR");
    }

    public static void cadastrarPessoa() {
        Pessoa p = new Pessoa();
        System.out.println("\n---Cadastro Pessoa---\n");
        System.out.print("Nome: ");
        p.setNome(s.nextLine());

        System.out.print("CPF: ");
        p.setCpf(s.nextLine());

        System.out.println("Cadastro realizado com sucesso!");
        pessoas.add(p);

        }


    public static void cadastrarLivro() {
        Livro livro = new Livro();

        System.out.println("\n---Cadastro Livro---\n");
        System.out.print("Titulo: ");
        livro.setTitulo(s.nextLine());

        System.out.print("Autor: ");
        livro.setAutor(s.nextLine());

        System.out.print("Ano: ");
        livro.setAno(s.nextInt());
        livros.add(livro);

    }

    public static void realizarEmprestimo() {
        System.out.println("\n---Sistema de Emprestimo de Livro---\n");
        System.out.println("Qual livro voce deseja pegar? ");
        mostrarLivros();
        String livro = s.nextLine();

        Livro l = procurarLivro(livro);
        if(livro == null){
            System.out.println("O livro nao foi encontrado no estoque!");
            return;
        }

        System.out.println("Qual o cliente que estaria fazendo este emprestimo? ");
        mostrarPessoas();
        String nome = s.nextLine();
        Pessoa p = procurarPessoa(nome);

        if(p == null){
            System.out.println("Pessoa nao foi encontrada nos registros!");
            return;
        }
        l.setEmprestado(true);

        Emprestimo emprestimo = new Emprestimo(l, p);
        p.getEmprestimos().add(emprestimo);
        System.out.println("Emprestimo realizado com sucesso!");
    }

    public static void mostrarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nao ha pessoas cadastradas");
        }else{
            for(Pessoa p : pessoas){
                System.out.println(p);
            }

        }

    }

    public static void mostrarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nao ha livros cadastrados");
        }else{
            for(Livro l : livros){
                System.out.println(l);
            }

        }

    }

    public static void mostrarEmprestimosDeUmaPessoa() {
        System.out.println("De qual pessoa voce gostaria de ver os emprestimos? ");
        String nome = s.nextLine();
        Pessoa p = procurarPessoa(nome);
        if(p == null){
            System.out.println("Pessoa nao foi encontrada");
            return;
        }
        for(Emprestimo e : p.getEmprestimos()){
        System.out.println(e);

        }

    }

    public static Pessoa procurarPessoa(String nome){
        for(Pessoa p : pessoas){
            if(p.getNome().equalsIgnoreCase(nome)){
                return p;
            }
        }
        return null;

    }

    public static Livro procurarLivro(String livro){
        for(Livro l : livros){
            if(l.getTitulo().equalsIgnoreCase(livro)){
                return l;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int x;
        do {
            mostrarMenu();
            x = s.nextInt();
            s.nextLine();
            switch (x) {
                case 1:
                    cadastrarPessoa();
                    break;

                case 2:
                    cadastrarLivro();

                    break;
                case 3:
                    realizarEmprestimo();

                    break;
                case 4:
                    mostrarPessoas();

                    break;
                case 5:
                    mostrarLivros();

                    break;
                case 6:
                    mostrarEmprestimosDeUmaPessoa();

                    break;
                case -1:
                    System.out.println("Fechando sistema!");

                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

        } while (x != -1);
        s.close();
    }

}
