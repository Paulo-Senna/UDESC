package apresentacao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

import dados.Gastos;
import dados.TipoGasto;
import negocio.Sistema;

public class TelaVisualizarGastos extends JFrame {

    private JTable tabela;
    private JComboBox<String> filtroMes;
    private JComboBox<TipoGasto> filtroCategoria;

    public TelaVisualizarGastos() {
        setTitle("Visualizar Gastos");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel painelFiltros = new JPanel();

        filtroMes = new JComboBox<>();
        filtroMes.addItem("Todos");
        Sistema.getGastosPorMes().keySet().forEach(filtroMes::addItem);

        filtroCategoria = new JComboBox<>();
        filtroCategoria.addItem(null); // Para "Todos"
        for (TipoGasto tipo : TipoGasto.values()) filtroCategoria.addItem(tipo);

        JButton btnFiltrar = new JButton("Filtrar");

        painelFiltros.add(new JLabel("Mês:"));
        painelFiltros.add(filtroMes);
        painelFiltros.add(new JLabel("Categoria:"));
        painelFiltros.add(filtroCategoria);
        painelFiltros.add(btnFiltrar);

        tabela = new JTable();
        JScrollPane scroll = new JScrollPane(tabela);

        setLayout(new BorderLayout());
        add(painelFiltros, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        preencherTabela(Sistema.getGastosUsuarioLogado());

        btnFiltrar.addActionListener(e -> {
            String mes = (String) filtroMes.getSelectedItem();
            TipoGasto tipo = (TipoGasto) filtroCategoria.getSelectedItem();

            List<Gastos> lista = Sistema.getGastosUsuarioLogado();

            if (!"Todos".equals(mes)) {
                lista = lista.stream()
                        .filter(g -> g.getData().contains(mes))
                        .collect(Collectors.toList());
            }

            if (tipo != null) {
                lista = lista.stream()
                        .filter(g -> g.getTipo() == tipo)
                        .collect(Collectors.toList());
            }

            preencherTabela(lista);
        });
    }

    private void preencherTabela(List<Gastos> gastos) {
        String[] colunas = {"Nome", "Data", "Descrição", "Valor", "Categoria"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Gastos g : gastos) {
            modelo.addRow(new Object[]{
                    g.getNome(),
                    g.getData(),
                    g.getDesc(),
                    String.format("R$ %.2f", g.getValor()),
                    g.getTipo()
            });
        }

        tabela.setModel(modelo);
    }
}
