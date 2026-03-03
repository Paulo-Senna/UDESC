import dados.*;

public class Zoologico {
    private Viveiro[] viveiros = new Viveiro[100];
    private int quantViveiros = 0;

    public void cadastrarViveiro(Viveiro v) {
        viveiros[quantViveiros++] = v;
    }

    public Viveiro[] getSoViveiros() {
        int count = 0;
        for (int i = 0; i < quantViveiros; i++) {
            if (!(viveiros[i] instanceof Aquario)) {
                count++;
            }
        }

        Viveiro[] resultado = new Viveiro[count];
        int j = 0;
        for (int i = 0; i < quantViveiros; i++) {
            if (!(viveiros[i] instanceof Aquario)) {
                resultado[j++] = viveiros[i];
            }
        }
        return resultado;
    }

    public boolean alocarAnimal(Animal animal, Viveiro viveiro){
        return viveiro.adicionarAnimal(animal);
    }

    public Viveiro[] getTodosViveiros() {
        return viveiros;
    }
}
