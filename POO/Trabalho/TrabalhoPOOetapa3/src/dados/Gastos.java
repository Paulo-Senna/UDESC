package dados;

public class Gastos {
    //* 
    private int id;
    private String nome;
    private String data;
    private String desc;
    private double valor;
    private TipoGasto tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoGasto getTipo() {
        return tipo;
    }

    public void setTipo(TipoGasto tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\n---" + tipo + "---\nNome: " + nome + "\nData: " + data + "\nDescricao: " + desc + "\nValor: " + valor + "\n";
    }
}
