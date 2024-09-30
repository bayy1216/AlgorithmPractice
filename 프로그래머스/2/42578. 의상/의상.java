import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String[] cloth: clothes){
            int count = hm.getOrDefault(cloth[1], 0);
            hm.put(cloth[1], count+1);
        }
        
        for(String k :hm.keySet()){
            int v= hm.get(k);
            answer *= (v+1);
        }
        
        
        return answer-1;
    }
}