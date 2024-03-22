import itertools

N = int(input())

ary = list(map(int,input().split()))

dap = 0
for i in range(2,N+1):
    current = itertools.combinations(ary,i)

    for i in current:
        hap = 0
        for x in i:
            hap = hap+ (1/x)
        if (99/100) <= hap <=(101/100):
            dap +=1
print(dap)