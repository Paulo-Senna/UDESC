package apresentacao;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.Map;
import negocio.Sistema;

public class TelaGraficos extends JFrame {

    public TelaGraficos() {
        setTitle("Análise Gráfica de Gastos por Mês");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Map<String, Double> dados = Sistema.getSomaGastosPorMes();

        GraficoBarrasPanel painelGrafico = new GraficoBarrasPanel(dados);

        add(painelGrafico, BorderLayout.CENTER);
    }
}