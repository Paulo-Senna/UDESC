package dados;

public class Reserva {

    private int nreserva;
    private String data;
    private String hora;
    private float preco;
    private String classe;
    private boolean idaVolta = false;
    private int poltrona;

    public Reserva(int nreserva2, String data, String hora, float preco, String classe, boolean idaVolta,
            int poltrona) {
        this.nreserva = nreserva2;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.classe = classe;
        this.idaVolta = idaVolta;
        this.poltrona = poltrona;
    }

    // getters

    public int getReserva() {
        return nreserva;

    }

    public String getData() {
        return data;

    }

    public String getHora() {
        return hora;

    }

    public float getPreco() {
        return preco;

    }

    public String getClasse() {
        return classe;

    }

    public boolean getIdaVolta() {
        return idaVolta;

    }

    public int getPoltrona() {
        return poltrona;

    }

    // setters

    public void setReserva(int nreserva) {
        this.nreserva = nreserva;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }

    public String toString() {
        return "Numero da reserva: " + nreserva + " | Data: " + data + " | Hora: " + hora +
                " | Preço: R$" + preco + " | Classe: " + classe + " | Poltrona: " + poltrona;
    }

}
