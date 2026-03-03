package apresentacao;

import javax.swing.*;
import java.awt.*;
import negocio.Sistema;

public class TelaAlterarGastos extends JFrame {

    public TelaAlterarGastos() {
        setTitle("Alterar Gasto");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        JTextField campoNome = new JTextField();
        JTextField novoNome = new JTextField();
        JTextField novaData = new JTextField();
        JTextField novaDesc = new JTextField();
        JTextField novoValor = new JTextField();

        JButton btnSalvar = new JButton("Salvar");

        add(new JLabel("Nome do gasto a alterar:"));
        add(campoNome);
        add(new JLabel("Novo nome:"));
        add(novoNome);
        add(new JLabel("Nova data:"));
        add(novaData);
        add(new JLabel("Nova descrição:"));
        add(novaDesc);
        add(new JLabel("Novo valor:"));
        add(novoValor);
        add(new JLabel(""));
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String nomeOriginal = campoNome.getText();
            Sistema.alterarGasto(nomeOriginal, 1, novoNome.getText());
            Sistema.alterarGasto(nomeOriginal, 2, novaData.getText());
            Sistema.alterarGasto(nomeOriginal, 3, novaDesc.getText());

            try {
                double val = Double.parseDouble(novoValor.getText());
                Sistema.alterarValorGasto(nomeOriginal, val);
                JOptionPane.showMessageDialog(this, "Gasto alterado.");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valor inválido.");
            }
        });
    }
}
