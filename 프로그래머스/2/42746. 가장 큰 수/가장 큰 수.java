import java.util.*;
import java.util.stream.*;


class Solution {
    public String solution(int[] numbers) {
        
        StringBuilder sb = new StringBuilder();
        
        List<Integer> li = Arrays.stream(numbers)
            .boxed().collect(Collectors.toList());
        
        boolean flag=false;
        for(int i=0;i<li.size();i++){
            if(!li.get(i).equals(0)) flag=true;
        }
        if(!flag) return "0";
        
        Collections.sort(li,(a,b)->{
           String aa = a.toString()+ a.toString()+a.toString();
            String bb = b.toString()+ b.toString()+b.toString();
            
           return (bb).compareTo(aa);
        });
        
        
        
        
        for(int i=0;i<li.size();i++){
            sb.append(li.get(i).toString());
        }
        
        return sb.toString();
    }
}