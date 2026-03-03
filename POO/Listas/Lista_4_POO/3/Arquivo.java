public class Arquivo {
    protected String nome;
    protected String extensao;

    public Arquivo(String nome) throws NomeInvalidoException{
        validarNome(nome);
        this.nome = nome;
    }

    private void validarNome(String nome) throws NomeInvalidoException {
        if(nome.contais("\n") || nome.contains("\r"))
        throw new NomeInvalidoException("Nome nao pode ter quebra de linhas");
        if(nome.contains("[") || nome.contains("]") || nome.contains("(") || nome.contains(")"))
        throw new NomeInvalidoException("Nome nao pode conter colchetes ou parenteses");
        if(nome.contains("\"") || nome.contains("'"))
        throw new NomeInvalidoException("Nome nao pode conter aspas");
        if(nome.length() < 10 || nome.length() > 256)
        throw new NomeInvalidoException("Nome deve ter tamanho entre 10 e 256 caracteres");
    }
    public abstract String toString();
}
