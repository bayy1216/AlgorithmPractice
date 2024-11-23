import java.util.*;


class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination){
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] road: roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        int[] distance = new int[n+1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[destination]= 0;
        
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->a.cost - b.cost);
        
        pq.add(new Point(destination, 0));
        while(!pq.isEmpty()){
            Point currPoint = pq.poll();
            
            if(distance[currPoint.to] < currPoint.cost){
                continue;
            }
            
            //canGo는 curr에서 갈수있는 장소들
            for(Integer canGo: graph.get(currPoint.to)){
                int nowCost = currPoint.cost +1; 
                //canGo로 현재저장된비용 > curr로 가는비용 + curr에서 canGo로 가능비용
                if(distance[canGo] > nowCost){
                    distance[canGo] = nowCost;
                    pq.add(new Point(canGo, nowCost));
                }
            }
        }
        
        
        int[] answer = new int[sources.length];
        
        for(int i=0; i< answer.length;i++){
            int ans = distance[sources[i]];
            if(ans == Integer.MAX_VALUE){
                ans=-1;
            }
            answer[i] = ans; 
        }
        return answer;
    }
    
    public static class Point{
        int to;
        int cost;
        public Point(int t, int c){
            this.to=t; this.cost=c;
        }
    }
}