import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int work: works){
            pq.add(work);
        }
        for(int i=0;i<n;i++){
            if(pq.isEmpty()) break;
            int curr = pq.poll();
            if(--curr == 0) continue;
            pq.add(curr);
        }
        while(!pq.isEmpty()){
            int a = pq.poll();
            answer += (long) a*a; 
        }
        
        
        return answer;
    }
}