package dados;

public class Peixe extends Animal {
    private float temperaturaIdeal;

    public float getTempIdeal() {
        return temperaturaIdeal;
    }

    public void setTempIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public float calculaEspacoOcupado() {
        return getAltura() * super.calculaEspacoOcupado();
    }

    public String toString() {
        return super.toString() + "Temperatura Ideal: " + temperaturaIdeal + "\n";
    }
}
