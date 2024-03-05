S = list(input())
ary = [0] * (ord('z')-ord('a') + 1)

for x in S:
    ary[ord(x)-ord('a')] +=1

print(*ary)