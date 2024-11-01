import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distances = new int[N+1];
        for(int i=1;i<N+1;i++){
            distances[i] = Integer.MAX_VALUE;
        }
        distances[1]=0;
        
        
        Map<Integer, List<Point>> graph= new HashMap<>();
        
        for(int[] r:road){
            graph.putIfAbsent(r[0], new ArrayList<>());
            graph.putIfAbsent(r[1], new ArrayList<>());
            
            graph.get(r[0]).add(new Point(r[1], r[2]));
            graph.get(r[1]).add(new Point(r[0], r[2]));
        }
    
        
        PriorityQueue<Point> pq = new PriorityQueue<>(
            (a,b)-> a.cost-b.cost
        );
        
        Point init = new Point(1,0);
        pq.add(init);//1번 방문
        while(!pq.isEmpty()){
            Point curr = pq.poll();//최적화 완료된 노드
            
            if(distances[curr.to] < curr.cost){
                continue; //현재 최적화 노드의 비용이 거리저장보다 크면
            } 
            
            List<Point> calcPoints = graph
                .getOrDefault(curr.to, new ArrayList<>());//꺼낸 노드에서 갈수있는 곳
            
            for(Point calcPoint: calcPoints){
                
                int cost = curr.cost + calcPoint.cost;// calcPoint.to로 가는 비용
                if(distances[calcPoint.to] > cost){
                    distances[calcPoint.to] = cost;
                    pq.add(new Point(calcPoint.to,cost));
                }
            }
            
            
        }
        for(int i=1;i<N+1;i++){
            if(distances[i]<=K) answer++;
        }
        
        
        return answer;
    }
    
    static class Point{
        int to;
        int cost;
        public Point(int t, int c){
            this.to=t;
            this.cost=c;
        }
    }
    
    
}