package apresentacao;

import javax.swing.*;
import java.awt.*;
import negocio.Sistema;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema de Finanças - Principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(5, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnAdicionar = new JButton("Adicionar Gasto");
        JButton btnVisualizar = new JButton("Visualizar/Alterar Gastos");
        JButton btnGraficos = new JButton("Visualizar Gráficos");
        JButton btnSair = new JButton("Logout");

        painel.add(btnAdicionar);
        painel.add(btnVisualizar);
        painel.add(btnGraficos);
        painel.add(btnSair);

        add(painel);

        btnAdicionar.addActionListener(e -> new TelaAdicionarGasto().setVisible(true));
        btnVisualizar.addActionListener(e -> new TelaVisualizarGastos().setVisible(true));

        btnGraficos.addActionListener(e -> {
            if (Sistema.getGastosUsuarioLogado().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não há gastos cadastrados para gerar gráficos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                new TelaGraficos().setVisible(true);
            }
        });

        btnSair.addActionListener(e -> {
            Sistema.logout();
            JOptionPane.showMessageDialog(this, "Logout realizado.");
            new TelaLogin().setVisible(true);
            this.dispose();
        });
    }
}
