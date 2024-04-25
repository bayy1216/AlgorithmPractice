import java.util.*;


class Solution {
    

    public static boolean[][] visit;
    public static int yLen, xLen;
    public int solution(int[][] maps) {
        
        yLen = maps.length;
        xLen = maps[0].length;
        
        visit = new boolean[yLen][xLen];
        for(int y=0;y<maps.length;y++){
            for(int x=0;x<maps[0].length;x++){
                if(maps[y][x] == 0) visit[y][x] = true;
            }
        }
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1));
        
        visit[0][0]=true;
        int[] dx = new int[4];
        int[] dy = new int[4];
        dx[2]=-1; dx[3]=1;
        dy[0]=-1; dy[1]=1;
        while(!q.isEmpty()){
            Point p = q.poll();
            int y= p.y;
            int x= p.x;
            int lvl = p.lvl;
            
            for(int i=0;i<4;i++){
                int moveX = x+dx[i];
                int moveY = y+dy[i];
                
                if(canMove(moveY,moveX)){
                    q.add(new Point(moveY,moveX,lvl+1));
                    visit[moveY][moveX]=true;
                    maps[moveY][moveX] = lvl+1;
                }
            }
            
        }
        return maps[yLen-1][xLen-1] ==1 ? -1 : maps[yLen-1][xLen-1];
    }
    public class Point{
        int y,x,lvl;
        Point(int y, int x,int lvl){
            this.lvl = lvl;
            this.x=x;
            this.y=y;
        }
    }
    
    public static boolean canMove(int y,int x){
        return y>=0 && x>=0 && y<yLen && x< xLen && !visit[y][x];
    }
}