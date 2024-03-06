N = int(input())
ary = list(map(int, input().split()))

dp = [0] * (N + 1)
dp[1] = ary[0]
if len(ary) > 2:
    if ary[0] * 2 > ary[1]:
        dp[2] = ary[0] * 2
    else:
        dp[2] = ary[1]

for i in range(1, N + 1):
    for money in range(0, N):
        money_n = money + 1
        if i - money_n >= 0 and dp[i - money_n] + ary[money] > dp[i]:
            dp[i] = dp[i - money_n] + ary[money]

print(dp[N])
