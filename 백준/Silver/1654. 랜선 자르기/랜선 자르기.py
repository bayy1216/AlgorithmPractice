import sys

K, N = list(map(int,input().split()))

ary = []

left = 1
right = 1

for i in range(K):
    line = int(sys.stdin.readline().rstrip())
    ary.append(line)
    right = max(right,line)

dap = 0

while left <= right:
    mid = (left + right) //2

    line_count = 0
    for line in ary:
        line_count += (line // mid)

    if line_count < N:
        right = mid - 1
    elif line_count >= N:
        left = mid + 1
        dap = max(mid,dap)



print(dap)