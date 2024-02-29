N = int(input())

ary = list(map(int, input().split()))

dap = "YES"

for i in range(1, N):
    if i % 2 == 1:
        if ary[i] % 2 == 1:
            dap = "NO"
            break
    else:
        if ary[i] % 2 == 0:
            dap = "NO"
            break

print(dap)
