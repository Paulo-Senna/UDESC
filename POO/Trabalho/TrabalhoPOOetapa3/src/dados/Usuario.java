package dados;

import java.util.ArrayList;

public class Usuario {
    //* 
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nome;
    private String senha;
    private ArrayList<Gastos> gastos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Gastos> getGastos() {
        return gastos;
    }

    public void adicionarGasto(Gastos g) {
        gastos.add(g);
    }

    public void removerGasto(Gastos g) {
        gastos.remove(g);
    }

    @Override
    public String toString() {
        return "Usuario: " + nome + "\nGastos: " + getGastos();
    }
}