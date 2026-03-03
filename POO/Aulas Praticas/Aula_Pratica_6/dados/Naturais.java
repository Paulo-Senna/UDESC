public class Naturais extends Gerador {

    public void gerar(int n) {
        for (int i = 0; i < n; i++) {
            sequencia.add(n);
        }
    }

    public boolean Naturais(int n) {
        if (n >= 0) {
            return true;
        } else {
            return false;
        }

    }

}
