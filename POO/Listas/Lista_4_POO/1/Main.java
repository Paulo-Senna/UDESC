import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
    }

    List<IOperacaoInteira> operacoes = Arrays.asList(
        new Soma();
        new MDC();
        new Mod;
        new Multiplicacao();
    );

    for(IOperacaoInteira operacao : operacoes){
        int a = random.nextInt(100);
        int b = random.nextInt(99) + 1;

        System.out.println(operacao.executar(a,b));
    }
    
}
