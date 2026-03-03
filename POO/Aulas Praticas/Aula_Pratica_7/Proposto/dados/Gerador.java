package Proposto.dados;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Gerador implements ISequencia{

    protected List<Integer> sequencia = new LinkedList<Integer>();

    public List<Integer> getSequencia(){
    return this.sequencia;
    }

    public abstract void gerar(int n);


    public int sortear(){
        Random r = new Random();
        return sequencia.get(r.nextInt(sequencia.size()));
    }

    public long somatorio(){
        long soma = 0;
        for(int num : sequencia){
                soma += num;
        }
        return soma;
    }

    public long produtorio(){
        long produto = 1;
        for(int num : sequencia){
            if(num > 0){
                produto *= num;
            }
        }
        return produto;
    } 

    public double mediaGeometrica(){
        double res;
        res = Math.pow(produtorio(), 1.0 / (double) sequencia.size());
        return res;
    }

    public double mediaAritmetica(){
        return somatorio() / (double) sequencia.size();
    }

    public double variancia(){
        double media = mediaAritmetica();
        double soma = 0;
        for(int num : sequencia){
            soma += Math.pow(num - media, 2);
        }
        return soma / (double) sequencia.size() -1;
    }

    public double desvioPadrao(){
        return Math.sqrt(variancia());
    }

    public int amplitude(){
        int x = -1;
        int y = 101;
        for(int num : sequencia){
            if(num > x){
                x = num;
            }
        }
        for(int num : sequencia){
            if(num < y){
                y = num;
            }
        }
        return x - y;
        //ou return Collections.max(sequencia) - Collections.min(sequencia);

    }
}