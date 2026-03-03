package apresentacao;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        });
    }
}

//quando eu vou alterar um valor do gasto, ele exige que eu preencha todos os campos de dados e depois fala que nao conseguiu caso eu nao altere
//mas mesmo assim, ele acaba alterando 
//testar de novo




/*package negocio;

import java.util.*;
import dados.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op;

        do {
            System.out.println("--- MENU ---");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Logout");
            System.out.println("4 - Adicionar gasto");
            System.out.println("5 - Mostrar gastos por mês");
            System.out.println("6 - Alterar gasto");
            System.out.println("7 - Apagar gasto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            op = in.nextInt();
            in.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = in.nextLine();
                    System.out.print("Senha: ");
                    String senha = in.nextLine();
                    System.out.println(Sistema.cadastrarUsuario(nome, senha));
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nomeLogin = in.nextLine();
                    System.out.print("Senha: ");
                    String senhaLogin = in.nextLine();
                    System.out.println(Sistema.fazerLogin(nomeLogin, senhaLogin));
                    break;

                case 3:
                    System.out.println(Sistema.logout());
                    break;

                case 4:
                    if (!Sistema.isUsuarioLogado()) {
                        System.out.println("É necessário estar logado.");
                        break;
                    }
                    System.out.print("Nome do gasto: ");
                    String nomeGasto = in.nextLine();
                    System.out.print("Data (dd/mm/aaaa): ");
                    String data = in.nextLine();
                    System.out.print("Descrição: ");
                    String desc = in.nextLine();
                    System.out.print("Valor: ");
                    double valor = in.nextDouble();
                    in.nextLine();

                    System.out.println("Escolha o tipo de Gasto: ");
                    TipoGasto[] tipos = TipoGasto.values();

                    for(int i = 0; i < tipos.length; i++){
                        System.out.printf("%d - %s\n", i + 1, tipos[i]);
                    }
                    int tipoInt;

                    do{

                        System.out.println("Digite o numero do tipo: ");
                        tipoInt = in.nextInt();
                        in.nextLine();
                    }while (tipoInt < 1 || tipoInt > tipos.length);
                    TipoGasto tipo = tipos[tipoInt - 1];

                    System.out.println(Sistema.adicionarGasto(nomeGasto, data, desc, valor, tipo));
                    break;

                case 5:
                    if (!Sistema.isUsuarioLogado()) {
                        System.out.println("É necessário estar logado.");
                        break;
                    }
                    Map<String, List<Gastos>> gastosPorMes = Sistema.getGastosPorMes();
                    for (String mes : gastosPorMes.keySet()) {
                        System.out.println("\nMês: " + mes);
                        for (Gastos g : gastosPorMes.get(mes)) {
                            System.out.printf("- %s | R$%.2f | %s | %s\n", g.getNome(), g.getValor(), g.getDesc(),
                                    g.getTipo());
                        }
                    }
                    break;

                case 6:
                    if (!Sistema.isUsuarioLogado()) {
                        System.out.println("É necessário estar logado.");
                        break;
                    }
                    System.out.print("Nome do gasto a alterar: ");
                    String gastoAlvo = in.nextLine();
                    System.out.println("1 - Alterar nome\n2 - Alterar data\n3 - Alterar descrição\n4 - Alterar valor");
                    int campo = in.nextInt();
                    in.nextLine();
                    if (campo == 4) {
                        System.out.print("Novo valor: ");
                        double novoValor = in.nextDouble();
                        in.nextLine();
                        boolean alterado = Sistema.alterarValorGasto(gastoAlvo, novoValor);
                        System.out.println(alterado ? "Valor alterado." : "Gasto não encontrado.");
                    } else {
                        System.out.print("Novo valor: ");
                        String novoValor = in.nextLine();
                        boolean alterado = Sistema.alterarGasto(gastoAlvo, campo, novoValor);
                        System.out.println(alterado ? "Gasto alterado." : "Gasto não encontrado.");
                    }
                    break;

                case 7:
                    if (!Sistema.isUsuarioLogado()) {
                        System.out.println("É necessário estar logado.");
                        break;
                    }
                    System.out.print("Nome do gasto a apagar: ");
                    String nomeExcluir = in.nextLine();
                    boolean apagado = Sistema.apagarGasto(nomeExcluir);
                    System.out.println(apagado ? "Gasto apagado." : "Gasto não encontrado.");
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (op != 0);

        in.close();
    }
}
*/