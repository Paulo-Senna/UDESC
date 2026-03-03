public class Main {
    public static void main(String[] args){
        SistemaProcessos sistema = new SistemaProcessos();

        Juiz juiz1 = new Juiz("Juiz A", 5);
        Juiz juiz2 = new Juiz("Juiz B", 5);
        Juiz juiz3 = new Juiz("Juiz C", 5);

        sistema.cadastrarJuiz(juiz1);
        sistema.cadastrarJuiz(juiz2);
        sistema.cadastrarJuiz(juiz3);

        for(int i = 1; i <= 18; i++){
            Processo processo = new Processo(i, "Processo "+ i);
            sistema.cadastrarProcesso(processo);
        }

        try{
            sistema.distribuirProcessos();
            System.out.println("Distribuicao concluida!\n");
        }catch(ProcessoSemJuizException e){
            System.out.println("Erro "+ e.getMessage());
        }
    }
    
}
