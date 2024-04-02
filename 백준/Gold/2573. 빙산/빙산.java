import java.io.*;
import java.util.*;

public class Main {
    public static int ary[][];

    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ary = new int[n][m];

        for(int x=0;x<n;x++){
            input = br.readLine().split(" ");
            for(int y=0;y<m;y++){
                ary[x][y] = Integer.parseInt(input[y]);
            }
        }


        int lvl = 0;
        while(phase(n,m)){



            lvl++;
            if(check(n,m)){
                System.out.println(lvl);
                return;
            }
        }

        System.out.println(0);


    }

    public static void dfs(int n, int m, int x, int y){
        visit[x][y] = true;
        if(!visit[x-1][y]) dfs(n,m,x-1,y);
        if(!visit[x+1][y]) dfs(n,m,x+1,y);
        if(!visit[x][y-1]) dfs(n,m,x,y-1);
        if(!visit[x][y+1]) dfs(n,m,x,y+1);

    }
    public static boolean visit[][];


    public static boolean check(int n,int m){

        visit= new boolean[n][m];
        for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){

                if(ary[x][y] > 0) visit[x][y] = false;
                else visit[x][y] = true;
            }
        }


        boolean first = true;
        for(int x=1;x<n-1;x++){
            for(int y=1;y<m-1;y++){
                if(ary[x][y] > 0 && first){
                    dfs(n,m,x,y);
                    first = false;
                }
                if(!visit[x][y]){
                    return true;
                }
            }
        }
        return false;



    }


    public static boolean phase(int n,int m){
        boolean notEnd = false;
        int mark[][] = new int[n][m];

        for(int x=1;x<n-1;x++){
            for(int y=1;y<m-1;y++){
                if(ary[x-1][y] <= 0 && ary[x][y]>0) mark[x][y]++;
                if(ary[x+1][y] <= 0 && ary[x][y]>0) mark[x][y]++;
                if(ary[x][y-1] <= 0 && ary[x][y]>0) mark[x][y]++;
                if(ary[x][y+1] <= 0 && ary[x][y]>0) mark[x][y]++;
                if(ary[x][y] > 0) notEnd = true;
            }
        }
        for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){
                ary[x][y] -= mark[x][y];
            }
        }
        return notEnd;
    }

}
