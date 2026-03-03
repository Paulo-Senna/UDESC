package apresentacao;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Map;

public class GraficoBarrasPanel extends JPanel {

    private Map<String, Double> dados; 
    private final int PADDING = 30; 
    private final int LABEL_PADDING = 25; 
    private Color corDaBarra = new Color(79, 129, 189);
    private Color corDaGrade = new Color(200, 200, 200, 200);

    public GraficoBarrasPanel(Map<String, Double> dados) {
        this.dados = dados;
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (dados == null || dados.isEmpty()) {
            g2.drawString("Não há dados para exibir.", getWidth() / 2 - 50, getHeight() / 2);
            return;
        }
        
        double valorMaximo = getValorMaximo();
        double larguraGrafico = getWidth() - 2 * PADDING;
        double alturaGrafico = getHeight() - 2 * PADDING - LABEL_PADDING;

        g2.drawLine(PADDING, getHeight() - PADDING - LABEL_PADDING, PADDING, PADDING);
        g2.drawLine(PADDING, getHeight() - PADDING - LABEL_PADDING, getWidth() - PADDING, getHeight() - PADDING - LABEL_PADDING);

        Font fontOriginal = g2.getFont();
        g2.setFont(fontOriginal.deriveFont(10f));
        int numeroDeMarcas = 10;
        for (int i = 0; i <= numeroDeMarcas; i++) {
            int y = getHeight() - PADDING - LABEL_PADDING - i * (int) (alturaGrafico / numeroDeMarcas);
            g2.setColor(corDaGrade);
            g2.drawLine(PADDING + 1, y, getWidth() - PADDING, y);
            g2.setColor(Color.BLACK);
            String label = String.format("R$ %.0f", (i * valorMaximo / numeroDeMarcas));
            g2.drawString(label, PADDING - 25, y + 5);
        }
        g2.setFont(fontOriginal);

        int larguraBarra = (int) (larguraGrafico / dados.size()) - 10;
        int x = PADDING + 5;

        for (Map.Entry<String, Double> entry : dados.entrySet()) {
            double valor = entry.getValue();
            int alturaBarra = (int) ((valor / valorMaximo) * alturaGrafico);
            int y = getHeight() - PADDING - LABEL_PADDING - alturaBarra;

            g2.setColor(corDaBarra);
            g2.fillRect(x, y, larguraBarra, alturaBarra);

            g2.setColor(Color.BLACK);
            g2.drawString(entry.getKey(), x + larguraBarra / 4, getHeight() - PADDING - LABEL_PADDING + 20);

            x += larguraBarra + 10;
        }
    }

    private double getValorMaximo() {
        double max = 0.0;
        for (Double valor : dados.values()) {
            if (valor > max) {
                max = valor;
            }
        }
        return max * 1.1;
    }
}