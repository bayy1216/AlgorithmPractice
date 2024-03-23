N = int(input())

ary = []

for i in range(N):
    start, end = map(int, input().split())
    ary.append((start,end))

ary.sort(key = lambda x: (x[1], x[0])) #회의가 가장 빨리 끝나는걸로 정렬, 그중에서 빨리 시작하는애들로 정렬

cnt = 0
time = 0
for start, end in ary:
    if time <= start:
        cnt += 1
        time = end

print(cnt)




