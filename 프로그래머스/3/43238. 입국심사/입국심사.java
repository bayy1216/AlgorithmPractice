import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long start = 0;
        long end = Long.MAX_VALUE;
        long answer = end;
        
        while(start<=end){
            long mid = start + (end-start)/2;
            
            
            if(can(n, times, mid)){//심사가능->시간줄이기
                end = mid-1;
                answer = Math.min(answer, mid);
            }else{
                start = mid+1;
            }
        
        }
        return answer;
    }
    
    
    public boolean can(int n, int[] times, long totalTime){
        //심사 기다리는 n명,
        //심사관이 검사하는데 걸리는 시간
        //심사가능한 시간 totalTime
        long total = 0;
        for(int time: times){
            //검사관이 7분이면, 28분이 지나야 4명이 가능
            total += totalTime/(long)time;
            if(total >=n) return true;
        }
        
        return false;
    }
}