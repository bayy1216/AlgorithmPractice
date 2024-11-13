import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {

        return greedy(n,stations, w);
    }
    
    public int greedy(int n, int[] stations, int w){
        // Apt apt = Apt.of(stations, w, n);
        int answer=0;
        int prev=1;//다음 기지국 X 시작점
        int unit = 2*w + 1;
        for(int stat: stations){
            int curr = stat-w;//기지국 OK인 마지막
            if(curr<= prev){
                prev=stat+w+1; 
                continue;  
            } 
            int diff = curr-prev;
            
            answer += diff/unit;
            if(diff%unit != 0){
                answer++; 
            }
            prev=stat+w+1;   
        }
        
        if(prev<n+1){//
            int diff = n+1 - prev;
            answer += diff/unit;
            if(diff%unit !=0) answer++;
        }
        
        // while(curr<=n){
        //     // Integer next = apt.next(curr);
        //     if(next==null){
        //         curr += w*2 + 1;
        //         answer++;
        //         continue;
        //     }
        //     curr= next;
        // }
        return answer;
    }
    
    
    public static class Apt{
        Map<Integer, Integer> apts;//next
        
        public Apt(Map<Integer, Integer> apts){
            this.apts = apts;
        }
        
        public Integer next(int n){
            return apts.get(n);
        }
        
        public static Apt of(int[] stations, int w, int n){
            Map<Integer, Integer> apts = new HashMap<>();
            for(int stat: stations){
                for(int i= stat-w; i<= stat+w && i<=n; i++){
                    if(i<1) continue;
                    apts.put(i, stat+w+1);   
                
                }
            }
            return new Apt(apts);
            
        }
    }
    
}