import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Turma turma = new Turma();

        while (true) {
            System.out.print("Nome do aluno: ");
            String nome = scanner.nextLine();
            if (nome.equals("-1")) break;

            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());

            double[] notas = new double[5];
            for (int i = 0; i < 5; i++) {
                System.out.print("Nota " + (i + 1) + ": ");
                notas[i] = Double.parseDouble(scanner.nextLine());
            }

            turma.adicionarAluno(new Aluno(nome, idade, notas));
        }

        List<Equipe> equipes = turma.separarEmEquipes();

        for (Equipe equipe : equipes) {
            System.out.println(equipe);
        }

        scanner.close();
    }
}
