package apresentacao;

import javax.swing.*;
import java.awt.*;
import negocio.Sistema;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema de Finanças - Principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(5, 1, 10, 10));

        JButton btnAdicionar = new JButton("Adicionar Gasto");
        JButton btnVisualizar = new JButton("Visualizar Gastos");
        JButton btnAlterar = new JButton("Alterar Gasto");
        JButton btnRemover = new JButton("Remover Gasto");
        JButton btnSair = new JButton("Logout");

        painel.add(btnAdicionar);
        painel.add(btnVisualizar);
        painel.add(btnAlterar);
        painel.add(btnRemover);
        painel.add(btnSair);

        add(painel);

        btnAdicionar.addActionListener(e -> new TelaAdicionarGasto().setVisible(true));

        btnVisualizar.addActionListener(e -> new TelaVisualizarGastos().setVisible(true));

        btnAlterar.addActionListener(e -> new TelaAlterarGastos().setVisible(true));

        btnRemover.addActionListener(e -> new TelaRemoverGasto().setVisible(true));

        btnSair.addActionListener(e -> {
            Sistema.logout();
            JOptionPane.showMessageDialog(this, "Logout realizado.");
            new TelaLogin().setVisible(true);
            this.dispose();
        });
    }
}

