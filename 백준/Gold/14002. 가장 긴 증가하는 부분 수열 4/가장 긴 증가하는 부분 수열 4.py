N = int(input())

ary = list(map(int, input().split()))

dap = 0
dp = []
for i in range(N):
    dp.append((1, [ary[i]]))

for i in range(1, N):
    for j in range(0, i):
        if ary[j] < ary[i] and dp[i][0] < dp[j][0] + 1:
            li = dp[j][1].copy()
            li.append(ary[i])
            dp[i] = (dp[j][0] + 1, li)

dap = dp[0]
for i in range(1, N):
    if dp[i][0] > dap[0]:
        dap = dp[i]

print(dap[0])
print(*dap[1])
