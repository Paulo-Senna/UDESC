import java.util.ArrayList;
import java.util.List;

public class Matriz<T> {
    private final int linhas;
    private final int colunas;
    private final Object[][] elementos;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.elementos = new Object[linhas][colunas];
    }

    public boolean set(T objeto, int i, int j) {
        if (i >= 0 && i < linhas && j >= 0 && j < colunas) {
            elementos[i][j] = objeto;
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T get(int i, int j) {
        if (i >= 0 && i < linhas && j >= 0 && j < colunas) {
            return (T) elementos[i][j];
        }
        return null;
    }

    public List<T> getLinha(int linha) {
        List<T> resultado = new ArrayList<>();
        if (linha >= 0 && linha < linhas) {
            for (int j = 0; j < colunas; j++) {
                resultado.add(get(linha, j));
            }
        }
        return resultado;
    }

    public List<T> getColuna(int coluna) {
        List<T> resultado = new ArrayList<>();
        if (coluna >= 0 && coluna < colunas) {
            for (int i = 0; i < linhas; i++) {
                resultado.add(get(i, coluna));
            }
        }
        return resultado;
    }

    public List<T> getElementosQuadrante(Quadrante quadrante) {
        List<T> resultado = new ArrayList<>();
        int meioLinha = linhas / 2;
        int meioColuna = colunas / 2;

        switch (quadrante) {
            case PRIMEIRO:
                for (int i = 0; i < meioLinha; i++) {
                    for (int j = 0; j < meioColuna; j++) {
                        resultado.add(get(i, j));
                    }
                }
                break;
            case SEGUNDO:
                for (int i = 0; i < meioLinha; i++) {
                    for (int j = meioColuna; j < colunas; j++) {
                        resultado.add(get(i, j));
                    }
                }
                break;
            case TERCEIRO:
                for (int i = meioLinha; i < linhas; i++) {
                    for (int j = 0; j < meioColuna; j++) {
                        resultado.add(get(i, j));
                    }
                }
                break;
            case QUARTO:
                for (int i = meioLinha; i < linhas; i++) {
                    for (int j = meioColuna; j < colunas; j++) {
                        resultado.add(get(i, j));
                    }
                }
                break;
        }

        return resultado;
    }
}
