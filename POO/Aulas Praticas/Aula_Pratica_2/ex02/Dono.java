package ex02;

public class Dono {
    private String nome;
    Endereco enderecoDono = new Endereco();
    private String cpf;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Endereco getEndereco(){
        return enderecoDono;
    }

    public void setEndereco(Endereco enderecoDono){
        this.enderecoDono = enderecoDono;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String toString(){
        return "\n---Dados do Dono---\nNome: "+nome+"\nEndereco: "+enderecoDono+"\nCPF: "+cpf;

    }
    
    
}
