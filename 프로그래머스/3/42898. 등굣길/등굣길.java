import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        
        
        
        int[][] dp = new int[n+1][m+1];
        dp[0][1]=1;
        for(int y=1;y<=n;y++){
            for(int x=1;x<=m;x++){
                boolean canMove= true;
                for(var puddle:puddles){
                    if(y==puddle[1] && x==puddle[0]){
                        canMove= false; break;
                    }
                }
                if(!canMove) continue;
                dp[y][x] = (dp[y-1][x]+dp[y][x-1])%1_000_000_007;
            }
        }
        
        // ArrayDeque<Point> queue = new ArrayDeque<>();
//         queue.addFirst(new Point(1,1));
        
//         while(!queue.isEmpty()){
//             Point curr= queue.pollLast();
//             for(var p: curr.move()){
//                 if(p.y>m || p.x>n) continue;
//                 if(!p.canMove(puddles)){
//                     continue;
//                 }
//                 dp[p.y][p.x]=(dp[p.y][p.x]+1)%1_000_000_007;
//                 queue.addFirst(p);
//             }
//         }
        
        
        return dp[n][m];
    }
    
    public static class Point{
        int y;
        int x;
        public Point(int y, int x){
            this.y=y; this.x=x;
        }
        public List<Point> move(){
            List<Point> list = new ArrayList<>();
            list.add(new Point(y+1,x));
            list.add(new Point(y,x+1));
            return list;
        }
        public boolean canMove(int[][] puddles){
            for(var puddle:puddles){
                if(x==puddle[1] && y==puddle[0]){
                    return false;
                }
            }
            return true;
        }
    }
}