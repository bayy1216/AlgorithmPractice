from math import sqrt
N = int(input())
dp = [ i for i in range(N+1)]

for i in range(1,N+1):
    sq = int(sqrt(i))
    if sqrt(i) == sq:
        dp[i] = 1
        continue
    for x in range(1,sq+1):
        dp[i] = min(dp[i], dp[i-(x**2)]+ 1)


print(dp[N])