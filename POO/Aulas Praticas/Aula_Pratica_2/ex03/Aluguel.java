package ex03;

public class Aluguel {
    private Cliente cliente;
    private Carro carro;
    private String dataInicio;
    private String dataFim;

    public Aluguel(Cliente cliente, Carro carro){
        this.cliente = cliente;
        this.carro = carro;
        this.dataInicio = "01/02/2025";
        this.dataFim = "01/03/2025";
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Carro getCarro() {
        return carro;
    }
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    public String getDataFim() {
        return dataFim;
    }
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String toString(){
        return "---Dados de Cadastro---\nCliente: "+cliente+"\nCarro: "+carro+"\nData de Inicio: "+dataInicio+"\nData de Fim: "+dataFim;
    }


}
