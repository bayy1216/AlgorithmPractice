import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=n;i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] edg: edge){
            graph.get(edg[0]).add(edg[1]);
            graph.get(edg[1]).add(edg[0]);
        }
        
        int[] visited = new int[n+1];
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[1] = 1;
        queue.addFirst(1);
        
        int distance=0;
        while(!queue.isEmpty()){
            Integer curr = queue.pollLast();
            List<Integer> canMove = graph.get(curr);
            for(int move: canMove){
                if(visited[move] != 0){
                    continue;
                }else{
                    visited[move] = visited[curr]+1;
                    distance = Math.max(distance, visited[move]);
                    queue.addFirst(move);
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(visited[i]==distance) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static class Point{
        int to;
        int cost;
        public Point(int to, int cost){this.to=to; this.cost=cost;}
    }
}