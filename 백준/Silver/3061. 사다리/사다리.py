import sys
T = int(sys.stdin.readline())


def solve(n, ary):
    dap = 0
    for ix in range(n-1):
        for i in range(n-1):
            if ary[i] > ary[i+1]:
                dap += 1
                ary[i], ary[i+1] = ary[i+1], ary[i]
                

    print(dap)



for _ in range(T):
    N = int(sys.stdin.readline())
    ARY = list(map(int,sys.stdin.readline().split()))
    solve(N,ARY)



