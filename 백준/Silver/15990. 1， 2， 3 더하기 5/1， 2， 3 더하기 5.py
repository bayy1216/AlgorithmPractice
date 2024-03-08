from collections import deque

T = int(input())
dp = [(0, 0, 0)] * 100001
dp[1], dp[2], dp[3] = (1, 0, 0), (0, 1, 0), (1, 1, 1)

dp_1 = [0] * 100001
dp_2 = [0] * 100001
dp_3 = [0] * 100001

for n in range(4, 100001):
    # dp_1[n] = dp_2[n - 1] + dp_3[n - 1]
    # dp_2[n] = dp_1[n - 2] + dp_3[n - 2]
    # dp_3[n] = dp_1[n - 3] + dp_2[n - 3]
    dp[n] = ((dp[n - 1][1] + dp[n - 1][2])%1000000009, (dp[n - 2][0] + dp[n - 2][2])%1000000009, (dp[n - 3][0] + dp[n - 3][1])%1000000009)

for _ in range(T):
    x = int(input())
    print((dp[x][0] + dp[x][1] + dp[x][2]) % 1000000009)
