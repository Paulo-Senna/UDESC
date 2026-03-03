import java.util.ArrayList;
import java.util.Random;

public class Sorteador {
    private ArrayList<Pessoa> pessoas;
    private Random random;

    public Sorteador(ArrayList<Pessoa> pessoas) {
        this.pessoas = new ArrayList<>(pessoas);
        this.random = new Random();
    }

    public Pessoa sortearProximo() {
        if (pessoas.isEmpty()) {
            return null;
            int index = random.nextInt(pessoas.size());
            return pessoas.remove(index);
        }
    }
}
