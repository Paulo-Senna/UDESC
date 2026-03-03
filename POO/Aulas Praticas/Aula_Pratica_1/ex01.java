package Aula_Pratica_1;
import java.util.Scanner;

public class ex01 {


    public float calculaMedia(int []v){
        int cont = 0;
        for(int i = 0; i < 5; i++){
            cont += v[i];
        }
        return cont/ v.length;
    }

    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

        int []v = new int[5];

        System.out.println("--Calculo de Media em Array--\n");
        System.out.println("Digite 5 valores: ");
        for(int i = 0; i < 5; i++){
            System.out.println((i+1) + "- ");
            v[i] = s.nextInt();
        }
        System.out.println("Media = "+ calculaMedia(v));
        
    }
    
}
