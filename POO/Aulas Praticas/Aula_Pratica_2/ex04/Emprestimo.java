package ex04;

public class Emprestimo {
    private Livro livro;
    private Pessoa pessoa;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo (Livro livro, Pessoa pessoa){
        this.livro = livro;
        this.pessoa = pessoa;
    }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public String getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String toString(){
        return "Livro: "+livro.getTitulo()+"\nPessoa "+pessoa.getNome();
    }

    
}
