package ex02;

import java.util.ArrayList;

public class Veterinario {
    private String nome;
    private float salario;
    Endereco endereco = new Endereco();
    private ArrayList<Animal> animais = new ArrayList<>();

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public ArrayList<Animal> getAnimais() {
        return animais;
    }
    public void setAnimais(Animal animal) {
        animais.add(animal);
    }
    
    public String toString(){
        return "---Dados Veterinario---\nNome: "+nome+"\nSalario: "+salario+"\nEndereco: "+endereco+"Animais cadastrados: "+animais.size();
    }
}
