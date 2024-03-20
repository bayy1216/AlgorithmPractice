N, M = map(int, input().split())

ary = list(map(int, input().split()))

start = 0
end = 10000

while start <= end:
    mid = (start + end) // 2
    i = 0
    for x in range(M):
        local_min = ary[i]
        local_max = ary[i]

        while True:
            local_min = min(local_min, ary[i])
            local_max = max(local_max, ary[i])
            if local_max - local_min >mid:
                break
            i += 1
            if i==N:
                break
        if i == N:
            break

    if i == N:
        end = mid-1
    else:
        start = mid +1

print(start)