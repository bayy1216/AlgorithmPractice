N = int(input())
ary = list(map(int, input().split()))

stack = [0]
dap = [-1] * N

for i in range(1,N):
    while stack and ary[stack[-1]] < ary[i]:
        dap[stack.pop()] = ary[i]
    stack.append(i)

print(" ".join(map(str, dap)))
