import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int[] dp = new int[sticker.length];
        if(sticker.length == 1){
            return sticker[0];
        }else if(sticker.length==2){
            return Math.max(sticker[0],sticker[1]);
        }
        
        dp[0]=sticker[0];
        dp[1]=sticker[0];
        //0번째를 뜯는경우, 마지막 사용 불가
        for(int i=2; i<sticker.length-1;i++){
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
        }
        answer = dp[sticker.length-2];
        
        
        Arrays.fill(dp,0);
        dp[1] = sticker[1];
        //0번쨰를 안뜯는 경우, 마지막 사용 가능
        for(int i=2; i<sticker.length;i++){
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
        }
        answer = Math.max(answer, dp[sticker.length-1]);
        
        

        return answer;
    }
}