package 1;

public class Mod implements IOperacaoInteira{
    public int executar(int valor1, int valor2){
        if(valor2 == 0) throw new ArithmeticException("Dividiu por zero ai mano, nao pode, nao viaja meu");
        return valor1 % valor2;
    }
    
}
