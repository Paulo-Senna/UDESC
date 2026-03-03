package apresentacao;

import javax.swing.*;
import java.awt.*;
import dados.Gastos;
import dados.TipoGasto;
import negocio.Sistema;

public class TelaAlterarGastos extends JFrame {

    private JTextField campoNovoNome, campoNovaData, campoNovaDesc, campoNovoValor;
    private JComboBox<TipoGasto> comboNovoTipo;
    private JButton btnSalvar, btnRemover;

    private Gastos gastoSelecionado;
    private TelaVisualizarGastos telaVisualizar;

    public TelaAlterarGastos(Gastos gasto, TelaVisualizarGastos telaVisualizar) {
        this.gastoSelecionado = gasto;
        this.telaVisualizar = telaVisualizar;

        setTitle("Alterar/Remover Gasto");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        campoNovoNome = new JTextField(gasto.getNome());
        campoNovaData = new JTextField(gasto.getData());
        campoNovaDesc = new JTextField(gasto.getDesc());
        campoNovoValor = new JTextField(String.format("%.2f", gasto.getValor()).replace(",", "."));
        comboNovoTipo = new JComboBox<>(TipoGasto.values());
        comboNovoTipo.setSelectedItem(gasto.getTipo());

        btnSalvar = new JButton("Salvar Alterações");
        btnRemover = new JButton("Remover Gasto");

        add(new JLabel("Novo Nome:"));
        add(campoNovoNome);
        add(new JLabel("Nova Data (dd/mm/aaaa):"));
        add(campoNovaData);
        add(new JLabel("Nova Descrição:"));
        add(campoNovaDesc);
        add(new JLabel("Novo Valor:"));
        add(campoNovoValor);
        add(new JLabel("Novo Tipo:"));
        add(comboNovoTipo);
        add(btnSalvar);
        add(btnRemover);

        btnSalvar.addActionListener(e -> salvarAlteracoes());
        btnRemover.addActionListener(e -> removerGasto());

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                telaVisualizar.habilitarTela();
            }
        });
    }

    private void salvarAlteracoes() {
        String resultado = Sistema.alterarGasto(
            gastoSelecionado,
            campoNovoNome.getText(),
            campoNovaData.getText(),
            campoNovaDesc.getText(),
            campoNovoValor.getText(),
            (TipoGasto) comboNovoTipo.getSelectedItem()
        );

        JOptionPane.showMessageDialog(this, resultado);
        if (resultado.equals("Gasto alterado com sucesso.")) {
            telaVisualizar.habilitarTela();
            dispose();
        }
    }
    
    //*  
    private void removerGasto() {
        int confirmacao = JOptionPane.showConfirmDialog(
            this,
            "Tem certeza que deseja remover o gasto:\n" + gastoSelecionado.getNome() + " (Data: " + gastoSelecionado.getData() + ")?",
            "Confirmação de Remoção",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            boolean sucesso = Sistema.apagarGasto(gastoSelecionado);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Gasto removido com sucesso.");
                telaVisualizar.habilitarTela();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao remover o gasto.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
