import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        Arrays.sort(money);
        //dp[화페의 갯수][현재의 금액]
        
        
//         int[][] dp = new int[money.length][n+1];
        
//         for(int j=0; j< money.length; j++){
//             dp[j][0]=1;
//         }
        
//         int currMoney = money[0];
//         for(int i=currMoney;i<n+1;i+=currMoney){
//             dp[0][i] = 1;
//         }
        
        
//         for(int j=1; j< money.length; j++){
//             for(int i=1;i<n+1;i++){
//                 currMoney = money[j];
                
//                 //dp[j-1]의 i-currMoney, i-currMoney*2를 더해주기
//                 int sum = 0;
//                 for(int m = i; m>=0; m-=currMoney){
//                     sum += dp[j-1][m];
//                 }
//                 dp[j][i] = sum % 1_000_000_007;
//             }
//         }
        
//         return dp[money.length-1][n];
        
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int m: money){
            for(int i=m; i<n+1;i++){
                dp[i] += dp[i-m];
                dp[i] = dp[i] %1_000_000_007;
            }       
        }
        return dp[n];
    }
}