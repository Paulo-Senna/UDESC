public class Perfeitos extends Gerador {
    public void gerar(int n) {

        for (int i = 1; i < n; i++) {
            if (perfeito(i)) {
                sequencia.add(i);
            }
        }

    }

    public boolean perfeito(int n) {
        int soma = 0;
        for (int i = 1; i < n; i++) {
            if (n % 1 == 0) {
                soma += i;
            }
        }
        if (n != soma) {
            return false;
        } else {
            return true;
        }
    }
}
