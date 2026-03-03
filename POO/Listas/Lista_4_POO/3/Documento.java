public class Documento extends Arquivo{

    private String texto;

    public Documento(String nome, String texto) throws NomeInvalidoException{
        super(nome);
        this.texto = texto;
        this.extensao = ".txt";
    }

    public String toString(){
        return nome + extensao;
    }
    
}
