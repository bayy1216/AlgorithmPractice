def solution(n):
    dp = [(0,0,0)] * (n//2) #가로만 있는경우, 세로가 위에 있는경우, 세로가 아래
    dp[0] = 1, 1, 1
    div = 1_000_000_007
    
    for i in range(1,n//2):
        dp[i] = ((dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % div,
                 (dp[i-1][0] + dp[i-1][1]*2 + dp[i-1][2]) % div,
                 (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]*2) % div,
                )
        
        
    return sum(dp[n//2 - 1]) % div