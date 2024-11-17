import java.util.*;


class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b)-> a[0]-b[0]);
        PriorityQueue<Job> pq = new PriorityQueue<>(
        (a,b)->a.cost - b.cost == 0 ? a.reqTime-b.reqTime : a.cost - b.cost
        );
        
        
        int answer = 0;
        int time = 0;
        
        int finishedJob =0;
        int idx=0;
        while(finishedJob<jobs.length){
            while(idx< jobs.length && jobs[idx][0]<=time){
                pq.add(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(pq.isEmpty()){
                time= jobs[idx][0];
            }else{
                Job curr=pq.poll();
                time += curr.cost;
                finishedJob++;
                
                answer += time-curr.reqTime;
            }
            
        }
        
        
        return answer/jobs.length;
    }

    
    public static class Job{
        int reqTime;
        int cost;
        public Job(int r, int c){
            this.reqTime=r;
            this.cost=c;
        }
    }
}