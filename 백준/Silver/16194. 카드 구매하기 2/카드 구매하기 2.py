N = int(input())
cards = list(map(int, input().split()))

dp = [0]
for x in cards:
    dp.append(x)

for i in range(1, N + 1):
    for money in range(0, N):
        money_n = money + 1
        if i - money_n >= 0 and dp[i - money_n] + cards[money] < dp[i]:
            dp[i] = dp[i - money_n] + cards[money]
print(dp[N])
