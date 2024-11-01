import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        
        for(int y=0;y<computers.length;y++){
            for(int x=0;x<computers.length;x++){
                // if(x==y) {
                //     computers[y][x] = 0;
                //     continue;
                // }
                if(computers[y][x] == 1){
                    bfs(new Point(y,x), computers);
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
    
    public void bfs(Point p, int[][] arr){
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.addFirst(p);
        arr[p.y][p.x]=0;
        while(!queue.isEmpty()){
            Point curr = queue.pollLast();
            for(int x=0;x<arr.length;x++){
                if(arr[curr.x][x] == 1){//이동가능
                    queue.addFirst(new Point(curr.x,x));
                    arr[curr.x][x]=0;
                }
            }
            
        }
    }
    
    static class Point{
        int x; int y;
        public Point(int y,int x){
            this.x=x; this.y=y;
        }
        public List<Point> move(int yLen, int xLen){
            List<Point> p = new ArrayList<>();
            if(x+1<xLen) p.add(new Point(y,x+1));
            if(x>0) p.add(new Point(y,x-1));
            if(y+1<yLen) p.add(new Point(y+1,x));
            if(y>0) p.add(new Point(y-1,x));
            return p;
        }
    }
    
    
}