import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String mn = br.readLine();
        String[] s = mn.split(" ");

        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        char[][] ary = new char[m][n];

        for(int i=0; i< m;i++){
            String x = br.readLine();
            for (int j=0;j<n;j++){
                ary[i][j] = x.charAt(j);
            }
        }
        int dap = 64;

        for(int i=0; i< m-7;i++) {
            for(int j=0; j<n-7; j++){
                int draw1 = 0;
                int draw2 = 0;


                for(int x=i; x<i+8;x++){
                    for(int y=j; y<j+8; y++){
                        if((x+y) % 2 == 0){
                            if(ary[x][y] == 'B'){
                                draw1++;
                            }else{
                                draw2++;
                            }
                        }else{
                            if(ary[x][y] == 'W'){
                                draw1++;
                            }else{
                                draw2++;
                            }
                        }

                    }
                }
                dap = Math.min(dap, draw1);
                dap = Math.min(dap, draw2);


            }
        }
        System.out.println(dap);
    }
}
