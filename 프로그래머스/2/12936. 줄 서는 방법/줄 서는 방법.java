import java.util.*;

class Solution {
    
    
    public int[] solution(int n, long k) {
    
        int[] answer = new int[n];
        
        int depth = 0;
        
        
        long curK=0;
        
        while(depth<n){
            int number=0;
            long localK = subCount(n, depth);
            while(true){
                if(curK+localK*(number+1) >= k){
                    answer[depth] = number;
                    curK+=localK*number;
                    break;
                }
                
                number++;
            }
            
            depth++;
        }
        
        List<Integer> li = new ArrayList<>();
        for(int i=1;i<n+1;i++) li.add(i);
        
        int[] an = new int[n];
        
        int idx=0;
        while(idx<n){
            int toAdd = li.get(answer[idx]);
            an[idx] = toAdd;
            li.remove(answer[idx]);
            idx++;
        }
        
        
        return an;
    }
    
    public long subCount(int n, int depth){
        int remain = n-depth-1;
        long ret = 1;
        while(remain>0){
            ret*= remain;
            remain--;
        }
        return ret;
    }
    
    
    
}