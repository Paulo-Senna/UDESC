import java.util.*;

public class SistemaArquivos{
    private Map<String, List<Arquivo>> diretorios = new HashMap<>();

    public void criarDocumento(String nome, String diretorio, String texto) throws NomeInvalidoException{
        Documento doc = new Documento(nome, texto);
        adicionarAoDiretorio(diretorio, doc);
    }

    public void criarMusica(String nome, String diretorio, int duracao) throws NomeInvalidoException {
        Musica musica = new Musica(nome, duracao);
        adicionarAoDiretorio(diretorio, musica);
    }
    
    public void criarVideo(String nome, String diretorio, Qualidade qualidade) throws NomeInvalidoException{
        Video video = new Video(nome, qualidade);
        adicionarAoDiretorio(diretorio, video);
    }

    private void adicionarAoDiretorio(String diretorio, Arquivo arquivo){
        diretorios.computeIfAbsent(diretorio, k -> new ArrayList<>()).add(arquivo);

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(String dir : diretorios.keyset()){
            sb.append(dir).append(":\n");
            for(Arquivo arq : diretorios.get(dir)){
                sb.append("    ").append(arq.toString()).append("\n\n");
            }
        }
        return sb.toString();
    }
}
