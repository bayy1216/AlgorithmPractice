import sys

N = int(input())


prev_max = (0,0,0)
prev_min = (0,0,0)

for i in range(N):
    n0, n1, n2 = map(int, sys.stdin.readline().rstrip().split())
    max0 = n0 + max(prev_max[0],prev_max[1])
    max1 = n1 + max(prev_max[0],prev_max[1],prev_max[2])
    max2 = n2 + max(prev_max[2],prev_max[1])
    prev_max = (max0, max1, max2)


    min0 = n0 + min(prev_min[0], prev_min[1])
    min1 = n1 + min(prev_min[0], prev_min[1], prev_min[2])
    min2 = n2 + min(prev_min[2], prev_min[1])
    prev_min = (min0,min1,min2)



print(f'{max(prev_max)} {min(prev_min)}')