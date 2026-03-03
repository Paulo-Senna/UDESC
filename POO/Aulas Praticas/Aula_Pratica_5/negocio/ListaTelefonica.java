package negocio;

import java.util.List;
import java.util.Map;
import dados.Contato;
import java.util.HashMap;
import java.util.LinkedList;

public class ListaTelefonica {
    private Map<Character, List<Contato>> contatos;

    public ListaTelefonica() {
        contatos = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            contatos.put(c, new LinkedList<>());
        }
    }

    public void adicionarContato(Contato contato){
        char inicial = Character.toUpperCase(contato.getNome().charAt(0));
        List<Contato> lista = contatos.get(inicial);
        lista.add(contato);
    }

    public void removerContato(Contato contato){
        char inicial = Character.toUpperCase(contato.getNome().charAt(0));
        List<Contato> lista = contatos.get(inicial);
        lista.remove(contato);
    }

    public Map<Character, List<Contato>> buscarContatos(){
        return contatos;
    }

    public List<Contato> buscarContatos(char inicial){
        return contatos.get(Character.toUpperCase(inicial));
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        contatos.forEach((chave, valores) -> {
            if (!valores.isEmpty()) {
                str.append(chave).append(":\n");
                for (Contato c : valores) {
                    str.append("  ").append(c).append("\n");
                }
            }
        });
        return str.toString();
    }
}
