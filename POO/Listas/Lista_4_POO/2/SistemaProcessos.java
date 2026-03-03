import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaProcessos{
    private List<Processo> processos;
    private List<Juiz> juizes;

    public SistemaProcessos(){
        processos = new ArrayList<>();
        juizes = new ArrayList<>();
    }

    public void cadastrarProcesso(Processo processo){
        processos.add(processo);
    }

    public void cadastrarJuiz(Juiz juiz){
        juizes.add(juiz);
    }

    public void distribuirProcessos() throws PRocessoSemJuizException{
        if(juizes.isEmpty()){
            throw new ProcessoSemJuizException();
        }

        Random rand = new Random();

        for(PRocesso processo : processo){
            boolean distribuido = false;
            int tent = 0;
            while(!distribuido && tent < juizes.size()){
                Juiz juiz = juizes.get(rand.nextInt(juizes.size()));
                try{
                    juiz.cadastrarProcesso(processo);
                    distribuido = true;
                }catch(PilhaCheiaException e){
                    tent++;
                }
            }
            if(!distribuido){
                System.out.println("Nao deu pra distribuir processo " + processo.getId());
            }
        }

        processos.clear();
    }
}
