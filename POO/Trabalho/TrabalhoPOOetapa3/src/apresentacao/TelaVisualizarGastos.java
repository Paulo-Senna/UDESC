package apresentacao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import dados.Gastos;
import negocio.Sistema;

public class TelaVisualizarGastos extends JFrame {

    private JTable tabelaGastos;
    private DefaultTableModel modeloTabela;
    private JButton btnAlterarGasto;

    private List<Gastos> listaGastos;

    public TelaVisualizarGastos() {
        setTitle("Visualizar Gastos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Nome", "Data", "Descrição", "Valor", "Tipo"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaGastos = new JTable(modeloTabela);
        tabelaGastos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(tabelaGastos);
        add(scroll, BorderLayout.CENTER);

        btnAlterarGasto = new JButton("Alterar Gasto");
        btnAlterarGasto.setEnabled(false);

        JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelSul.add(btnAlterarGasto);
        add(painelSul, BorderLayout.SOUTH);

        carregarGastos();

        tabelaGastos.getSelectionModel().addListSelectionListener(e -> {
            boolean selecionado = tabelaGastos.getSelectedRow() != -1;
            btnAlterarGasto.setEnabled(selecionado);
        });

        btnAlterarGasto.addActionListener(e -> abrirTelaAlterar());

    }

    private void carregarGastos() {
        modeloTabela.setRowCount(0); 
        listaGastos = Sistema.getGastosUsuarioLogado();

        for (Gastos g : listaGastos) {
            modeloTabela.addRow(new Object[]{
                g.getId(),
                g.getNome(),
                g.getData(),
                g.getDesc(),
                String.format("R$ %.2f", g.getValor()),
                g.getTipo()
            });
        }
    }

    private void abrirTelaAlterar() {
        int linha = tabelaGastos.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um gasto para alterar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Gastos gastoSelecionado = listaGastos.get(linha);
        TelaAlterarGastos telaAlterar = new TelaAlterarGastos(gastoSelecionado, this);
        telaAlterar.setVisible(true);
        this.setEnabled(false);
    }

    public void atualizarTabela() {
        carregarGastos();
    }

    public void habilitarTela() {
        this.setEnabled(true);
        this.toFront();
        carregarGastos();
    }
}
