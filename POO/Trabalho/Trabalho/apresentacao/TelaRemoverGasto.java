package apresentacao;

import javax.swing.*;
import java.awt.*;
import negocio.Sistema;

public class TelaRemoverGasto extends JFrame {

    public TelaRemoverGasto() {
        setTitle("Remover Gasto");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JTextField campoNome = new JTextField();
        JButton btnRemover = new JButton("Remover");

        add(new JLabel("Nome do gasto a remover:"));
        add(campoNome);
        add(btnRemover);

        btnRemover.addActionListener(e -> {
            boolean sucesso = Sistema.apagarGasto(campoNome.getText());
            JOptionPane.showMessageDialog(this, sucesso ? "Removido com sucesso." : "Gasto não encontrado.");
            dispose();
        });
    }
}
