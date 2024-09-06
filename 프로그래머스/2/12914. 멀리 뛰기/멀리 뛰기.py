def solution(n):
    if n==1: return 1
    dp = [0] * (n+1)
    dp[1], dp[2] = 1, 2
    
    if n<3: return dp[n]
    
    for i in range(3,n+1):
        dp[i] = (dp[i-1] + dp[i-2]) % 1_234_567
    
    
    return dp[n] % 1_234_567