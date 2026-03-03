package dados;

public class Contato {
    private String nome;
    private String telefone;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Contato c = (Contato) obj;
        return nome.equalsIgnoreCase(c.getNome()) && telefone.equals(c.getTelefone());
    }

    public String toString(){
        return "Nome: " + nome + " - Telefone: " + telefone;
    }
}
