import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int standard = s/n;
        if(n>s) return new int[]{-1};
        
        Arrays.fill(answer, standard);
        
        int remain = s % n;
        for(int i=n-1;remain>0 ;i--){
            answer[i]+=1;
            remain--;
        }
        return answer;
    }
}