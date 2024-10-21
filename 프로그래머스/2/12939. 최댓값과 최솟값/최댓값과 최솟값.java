import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] arr = s.split(" ");
        
        Integer min = Integer.valueOf(arr[0]);
        Integer max = Integer.valueOf(arr[0]);
        
        for(int i=0; i<arr.length; i++){
            int n = Integer.valueOf(arr[i]);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        return min.toString() + " "+max.toString();
    }
}