N = int(input())
dp = [(0,0)] * (N+2)

dp[1] = (1,0)
dp[2] = (1,0)

for i in range(2,N):
    dp[i+1] = (dp[i][0]+dp[i][1], dp[i][0])

print(sum(dp[N]))