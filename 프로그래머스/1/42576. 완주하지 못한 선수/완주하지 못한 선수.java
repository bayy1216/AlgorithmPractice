import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(String p : completion){
            int a = hm.getOrDefault(p,0);
            hm.put(p, a+1);
        }
        
        for(String c: participant){
            Integer i = hm.get(c);
            if(i==null || i<=0){
                return c;
            }
            hm.put(c, i-1);
        }
        
        return answer;
    }
}