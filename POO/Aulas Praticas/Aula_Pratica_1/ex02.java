package Aula_Pratica_1;
import java.util.Scanner;

public class ex02 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String []v =  new String[5];
        for(int i = 0; i < v.length; i++){
            System.out.println("Nome "+ (i+1));
            v[i] = s.nextLine();
        }
    }
    
}
