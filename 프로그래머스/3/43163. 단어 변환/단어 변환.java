import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Point init = new Point(0,begin);
        
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.addFirst(init);
        
        // List<String> wordList = Arrays.stream(words).collect(Collectors.toList());
        boolean[] visited = new boolean[words.length];
        
        
        while(!queue.isEmpty()){
            Point curr = queue.pollLast();
            for(int i=0;i<words.length;i++){
                if(visited[i]) continue;
                
                if(curr.check(words[i])){
                    if(words[i].equals(target)){
                        return curr.lvl+1;
                    }
                    visited[i]=true;
                    queue.addFirst(new Point(curr.lvl+ 1, words[i]));
                }
                
            }
            
        }
        
        
        
        return 0;
    }
    
    
    public static class Point{
        int lvl;
        String word;
        public Point(int lvl, String word){
            this.lvl=lvl;
            this.word=word;
        }
        
        public boolean check(String other){
            int c=0;
            for(int i=0;i<other.length();i++){
                if(word.charAt(i) == other.charAt(i)) c++;
            }
            return c == other.length()-1;
        }
    }
    
    
}