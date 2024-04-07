import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
    public static long a = 0;
    public static long b = 0;
    public static long c = 0;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String[] inp = x.split(" ");
        a = Long.parseLong(inp[0]);
        b = Long.parseLong(inp[1]);
        c = Long.parseLong(inp[2]);


        long t = calc(a, b);
        System.out.println(t%c);
    }

    public static long calc(long num, long exp){
        if(exp==1){
            return a%c;
        }
        long cache = calc(num, exp/2);
        if(exp%2 == 1){
            return (cache * cache % c) * a % c;    
        }
        
        return cache * cache % c;
    }
}
