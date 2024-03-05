N = int(input())
ary = list(map(int,input().split()))
nums = [0] * (max(ary)+1)

stack = []
dap = [-1] * N



for i in range(N):
    nums[ary[i]] += 1

for i in range(N):
    while stack and nums[ary[i]] > nums[ary[stack[-1]]]:
        dap[stack.pop()] = ary[i]
    stack.append(i)

print(*dap)