from math import sqrt

N, K = map(int, input().split())

dp = [[0 for _ in range(K + 2)] for x in range(N + 2)]

dp[0][1] = 1
for x in range(1, K + 1):
    dp[0][x] = 1
    dp[1][x] = x
for x in range(1, N + 1):
    dp[x][1] = 1

for n in range(2, N + 1):
    for k in range(2, K + 1):
        for i in range(0, n + 1):
            dp[n][k] += dp[n - i][k - 1]
        dp[n][k] = (dp[n][k] % 1000000000)

print(dp[N][K])
