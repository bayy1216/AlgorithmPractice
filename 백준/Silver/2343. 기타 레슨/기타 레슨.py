N, M = map(int, input().split())

ary = list(map(int, input().split()))

mean_n = N // M - 1

start = 0
# end = 0
# for i in range(mean_n, N-1):
#     end += ary[i]
end = sum(ary)

while start <= end:
    mid = (start + end) // 2
    i = 0

    blue_ray = 0
    for _ in range(M):
        target = mid
        while True:
            target -= ary[i]
            if target < 0: break #초과해버림
            i += 1
            if i==N:break #끝까지 도착함

        if i==N:break #끝까지 도착함

    if i==N:
        end = mid -1
    else:
        start = mid +1


print(start)
