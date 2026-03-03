package ex03;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    ArrayList<Aluguel> alugueis = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(ArrayList<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "Alugueis cadastrados: " + alugueis.size()+"\n-----------------------";
    }
}
