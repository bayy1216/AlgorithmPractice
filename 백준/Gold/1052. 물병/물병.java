import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K =Integer.parseInt(input[1]);


        int[] two = new int[25];
        int i=0;
        while(true){
            int div = N/2;
            int mod = N%2;
            two[i++] = mod;
            N=div;
            if(N==0) break;
        }
        int x= 24;

        int check = 0;
        for(int a=0;a<25;a++){
            if(two[a]==1)
                check++;
        }
        if(check <= K){
            System.out.println("0");
            return;
        }


        for(;x>-1;x--){
            if(two[x]==1){
                K--;
            }
            if(K==0) break;
        }


        int target=m2(x);

        for(int ii=0;ii<x;ii++){
            if(two[ii]==1)
                target -= m2(ii);
        }

        System.out.println(target);



    }
    public static int m2(int x){
        int target=1;
        for(int a=0;a<x;a++){
            target *=2;
        }
        return target;
    }

}
