import java.util.*;
import java.io.*;

class Solution {
    public static class Point{
        Long x; Long y;
        Point(long y,long x){
            this.x = x;
            this.y= y;
        }
    }
    
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        
        String[] answer;
        int target = 0;
        //int other = 1;
        while(target < line.length){
            for(int other= target+1; other<line.length; other++){
                long A = (long)line[target][0];
                long B = (long)line[target][1];
                long E = (long)line[target][2];
                
                long C = (long)line[other][0];
                long D = (long)line[other][1];
                long F = (long)line[other][2];
                if((long)A*D == (long)B*C) continue;
                
                double x = (double)(B*F - E*D)/(A*D - B*C);
                double y = (double)(E*C - A*F)/(A*D - B*C);
                
                if((x % 1 !=0) || (y%1 !=0)) continue;
                Point p = new Point(
                    ((long)E*C - (long)A*F)/((long)A*D - (long)B*C),
                    ((long)B*F - (long)E*D)/((long)A*D - (long)B*C)
                );
                points.add(p);
            }
            target++;
        }
    
        
        long pointMaxX = points.stream()
            .map(p->p.x).mapToLong(x->x).max().orElseThrow(RuntimeException::new);
        long pointMinX = points.stream()
            .map(p->p.x).mapToLong(x->x).min().orElseThrow(RuntimeException::new);
        
        long pointMaxY = points.stream()
            .map(p->p.y).mapToLong(x->x).max().orElseThrow(RuntimeException::new);
        long pointMinY = points.stream()
            .map(p->p.y).mapToLong(x->x).min().orElseThrow(RuntimeException::new);
        
        
        
        int yLen = (int) (pointMaxY-pointMinY)+1;
        int xLen = (int) (pointMaxX-pointMinX)+1;
        char[][] map = new char[yLen][xLen];
        answer = new String[yLen];
        for(char[] xStr: map){
            Arrays.fill(xStr, '.');
        }
        
        for(Point p: points){
            int py = (int)(pointMaxY - p.y);
            int px = (int)(p.x - pointMinX);
            map[py][px] = '*';
        }
        
        for(int a=0;a<answer.length;a++){
            answer[a] = new String(map[a]);
        }
        
        
        return answer;
    }
}