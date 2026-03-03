package apresentacao;

import javax.swing.*;
import java.awt.*;
import negocio.Sistema;
import dados.TipoGasto;

public class TelaAdicionarGasto extends JFrame {

    private JTextField campoNome, campoData, campoDescricao, campoValor;
    private JComboBox<TipoGasto> comboTipo;

    public TelaAdicionarGasto() {
        setTitle("Adicionar Gasto");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(6, 2, 10, 10));

        campoNome = new JTextField();
        campoData = new JTextField();
        campoDescricao = new JTextField();
        campoValor = new JTextField();
        comboTipo = new JComboBox<>(TipoGasto.values());

        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("Data (dd/mm/aaaa):"));
        painel.add(campoData);
        painel.add(new JLabel("Descrição:"));
        painel.add(campoDescricao);
        painel.add(new JLabel("Valor:"));
        painel.add(campoValor);
        painel.add(new JLabel("Tipo:"));
        painel.add(comboTipo);

        JButton btnSalvar = new JButton("Salvar");
        painel.add(btnSalvar);

        add(painel);

        btnSalvar.addActionListener(e -> {
            try {
                String nome = campoNome.getText();
                String data = campoData.getText();
                String desc = campoDescricao.getText();
                double valor = Double.parseDouble(campoValor.getText());
                TipoGasto tipo = (TipoGasto) comboTipo.getSelectedItem();

                String resultado = Sistema.adicionarGasto(nome, data, desc, valor, tipo);
                JOptionPane.showMessageDialog(this, resultado);
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valor inválido.");
            }
        });
    }
}
