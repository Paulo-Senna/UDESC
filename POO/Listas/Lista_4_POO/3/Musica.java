public class Musica extends Arquivo{
    private int duracao;

    public Musica(String nome, int duracao) throws NomeInvalidoException{
        super(nome);
        this.duracao = duracao;
        this.extenao = ".mp3";
    }

    public String toString(){
        return nome + extensao + "\nDuracao: " + duracao;
    }
    
}
