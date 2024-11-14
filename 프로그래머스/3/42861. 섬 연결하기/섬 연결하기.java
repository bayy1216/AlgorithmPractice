import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for(var cost: costs){
            
            graph.get(cost[0]).add(Edge.from(cost));
            graph.get(cost[1]).add(Edge.fromRev(cost));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.addAll(graph.get(0));
        visited[0]=true;
        
        int count=0;
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(visited[curr.to]){
                continue;
            }
            pq.addAll(graph.get(curr.to));
            visited[curr.to]=true;
            answer+=curr.cost;
            if(++count==n){
                break;
            }
        }
        
        
        
        return answer;
    }
    
    public static class Edge{
        int from;
        int to;
        int cost;
        public Edge(int f, int t, int c){
            this.from = f; this.to=t; this.cost=c;
        }
        public static Edge from(int[] nums){
            return new Edge(nums[0], nums[1], nums[2]);
        }
        public static Edge fromRev(int[] nums){
            return new Edge(nums[1], nums[0], nums[2]);
        }
    }
}