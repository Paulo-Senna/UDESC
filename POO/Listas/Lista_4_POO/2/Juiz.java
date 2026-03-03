public class Juiz {
    private String nome;
    private Pilha<Processo> processos;

    public Juiz(String nome, int limite){
        this.nome = nome;
        this.processos = new Pilha<>(limite);
    }

    public void cadastrarProcesso(Processo processo) throws PilhaCheiaException{
        processos.inserir(processo);
    }

    public String getNome(){
        return nome;
    }
    
}
