S = list(input())
ary = [-1] * (ord('z')-ord('a') + 1)

for x in range(len(S)):
    index = ord(S[x])-ord('a')
    if ary[index] != -1:
        continue
    ary[index] = x

print(*ary)