import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        while (true) {
            System.out.println("Digite o nome da pessoa: ");
            String nome = scan.nextLine();
            if (nome.equals("-1")) break;

            System.out.println("Idade:");
            int idade = Integer.parseInt(scan.nextLine());

            System.out.println("CPF:");
            String cpf = scan.nextLine();

            System.out.println("Cidade:");
            String cidade = scan.nextLine();

            Pessoa novaPessoa = new Pessoa(nome, idade, cpf, cidade);
            pessoas.add(novaPessoa);

            exibirAgrupadasPorFaixaEtaria(pessoas);
        }

        System.out.println("Encerrando o programa.");
        scan.close();
    }

    private static void exibirAgrupadasPorFaixaEtaria(List<Pessoa> pessoas) {
        Collections.sort(pessoas);

        Map<FaixaEtaria, List<Pessoa>> agrupadas = new EnumMap<>(FaixaEtaria.class);

        for (FaixaEtaria faixa : FaixaEtaria.values()) {
            agrupadas.put(faixa, new ArrayList<>());
        }

        for (Pessoa p : pessoas) {
            agrupadas.get(p.getFaixaEtaria()).add(p);
        }

        System.out.println("\n--- Lista de Pessoas (agrupadas e ordenadas) ---");
        for (FaixaEtaria faixa : FaixaEtaria.values()) {
            List<Pessoa> grupo = agrupadas.get(faixa);
            if (!grupo.isEmpty()) {
                System.out.println("• " + faixa.getDescricao() + ":");
                for (Pessoa p : grupo) {
                    System.out.println(p);
                }
            }
        }
        System.out.println();
    }
}
