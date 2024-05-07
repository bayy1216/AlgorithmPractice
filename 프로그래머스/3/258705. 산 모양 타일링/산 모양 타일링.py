def solution(n, tops):
    answer = 0
    dp = [0]*(2*n+2)
    dp[1],dp[2] = 1, 2
    if tops[0] == 1:
        dp[2] = 3
    
    for i in range(3,2*n+2):
        current_top_index = i//2 - 1
        
        if i%2 == 0:#짝수번째, 탑있거나 없거나
            if tops[current_top_index] ==1:
                dp[i] = dp[i-1] * 2 + dp[i-2]
            else:
                #현재 탑 아님
                dp[i] = (dp[i-2]+dp[i-1])
        else:#홀수번째, 전에꺼가 탑이였거나 없거나
            dp[i] = dp[i-2]+dp[i-1]
        dp[i] = dp[i] % 1_0007
            
            
            
        
    
    return dp[2*n+1]