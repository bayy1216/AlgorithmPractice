n = int(input())

ary = [ 0 for _ in range(n+1)]
for i in range(1, n+1):
    if i == 1:
        ary[i] = 1
    elif i == 2:
        ary[i] = 2
    else:
        ary[i] = (ary[i-1] + ary[i-2]) % 10

print(ary[n])