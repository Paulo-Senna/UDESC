package dados;

public class Cliente {

    private int cpf;
    private String nome;
    private String endereco;
    private int telefone;

    public Cliente(int cpf, String nome, String endereco, int telefone){
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;

    }

    public int getCpf() {
        return cpf;
    }

    public String getNome(){
        return nome;
    }
    
    public String getEnd(){
        return endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public String toStrin(){
        return "Cliente: "+nome+"|CPF: "+cpf+"|Endereco: "+endereco+"|Telefone: "+telefone;
    }

    

}
