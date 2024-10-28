import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length-1;
        
        while(start<end){
            int small = people[start];
            int big = people[end];
            
            if(small+big <= limit){
                start++;
                end--;
                answer++;
            }else{
                end--;
                answer++;
            }
        }
        if(start==end) answer++;
        
        
        return answer;
    }
}