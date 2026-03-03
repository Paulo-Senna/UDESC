package dados;
import java.lang.String;

public class Cidade {
    private String nome;
    private String Estado;

    public Cidade(String nome, String Estado){
        this.nome = nome;
        this.Estado = Estado;
    }

    public String getNome(){
        return nome;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "Cidade: " + nome + "|Estado: " + Estado;

    }

}
