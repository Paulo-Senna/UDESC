import java.util.*;


public class Pilha<T> {
    private int limite;
    private List<T> elementos;

    public Pilha(int limite){
        this.limite = limite;
        this.elementos = new ArrayList<>();
    }
    public void inserir(T objeto) throws PilhaCheiaException{
        if(elementos.size() >= limite){
            throw new PilhaCheiaException();
        }
        elementos.add(objeto);
    }

    public T remover() throws PilhaVaziaException{
        if(elementos.isEmpty()){
            throw new PilhaVaziaExeception();
        }
        return elementos.remove(elementos.size() -1);
    }

    public int getSize(){
        return elementos.size();
    }
}
