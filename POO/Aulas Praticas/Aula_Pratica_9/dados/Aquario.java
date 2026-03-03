package dados;

public class Aquario extends Viveiro {
    private float altura;
    private float temperatura;

    public float getAltura() {
        return altura;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float calculaEspaco() {
        return getComprimento() * getLargura() * altura;
    }

    public boolean adicionarAnimal(Animal animal) {
        if (espacoDisponivel() >= animal.calculaEspacoOcupado() * 0.7f) {
            if (animal instanceof Peixe) {
                Peixe p = (Peixe) animal;
                if (p.getTempIdeal() < (temperatura - 3) || p.getTempIdeal() > (temperatura + 3)) {
                    return false;
                }
            }
            animais[quantAnimais] = animal;
            quantAnimais++;
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuffer string = new StringBuffer();
        string.append("Aquario\n");
        string.append("Nome: " + getNome() + "\n");
        string.append("Altura: " + altura + ", Temperatura: " + temperatura + "\n");
        for (int i = 0; i < quantAnimais; i++) {
            string.append("\t" + animais[i].toString());
        }
        return string.toString();
    }
}
