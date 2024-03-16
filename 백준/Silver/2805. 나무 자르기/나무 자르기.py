N, M = list(map(int,input().split()))

ary = list(map(int,input().split()))

start = 0
end = max(ary) - 1


while start <= end:
    mid = (start + end) // 2
    tree = 0
    for i in ary:
        tree += max(0,i-mid)

    if tree < M:
        end = mid - 1
    else:
        start = mid + 1
#while 탈출조건이 start> end로 깨지게 된것이므로 end를 추렭하면 된다!
print(end)