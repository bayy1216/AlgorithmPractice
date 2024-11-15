import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = 200_000_001;
        while(start<=end){
            int mid = start+(end-start)/2;
            
            if(canMove(stones, k, mid)){
                answer= Math.max(answer, mid);
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        
        return answer;
    }
    
    public boolean canMove(int[] stones, int k, int person){
        int cnt=0;
        for(int stone: stones){
            if(stone < person){
                cnt++;
            }else{
                cnt=0;
            }
            if(cnt==k){//연속으로 못건너면
                return false;
            }
        }
        return true;
    }
}