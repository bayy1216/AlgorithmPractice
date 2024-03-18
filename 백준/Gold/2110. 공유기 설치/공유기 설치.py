import sys
N, C = list(map(int,input().split()))


house = [int(sys.stdin.readline().rstrip()) for _ in range(N)]
house.sort()


start = 1
end = house[-1] - house[0]





while start <= end:
    mid = (end + start) // 2

    current = house[0]
    count = 1

    for i in range(1, len(house)):
        if house[i] >= current + mid:
            count +=1
            current = house[i]

    if count >= C:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)