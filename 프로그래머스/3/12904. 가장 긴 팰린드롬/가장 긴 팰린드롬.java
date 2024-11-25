import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        char[] word = s.toCharArray();
        boolean[][] dp = new boolean[word.length][word.length];
        for(int i=0;i<word.length;i++){
            dp[i][i] = true;
        }
        for(int i=0;i+1<word.length;i++){
            if(word[i]==word[i+1]){
                dp[i][i+1] = true;
                answer=2;
            }
                
        }
        
        for(int len = 3; len<=word.length; len++){
            
            for(int start = 0; start+len-1<word.length; start++){
                int end = start+len-1;
                if(!dp[start+1][end-1]){//팰린드롬 아니면,
                    continue;
                }
                if(word[start] == word[end]){//양끝이 같으면 dp에 저장
                    dp[start][end] = true;
                    answer = len;
                }
            }
        }
        


        return answer;
    }
    
    
}