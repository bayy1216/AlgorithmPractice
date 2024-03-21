N, M = map(int, input().split())
ary = list(map(int, input().split()))

# 놀이기구 운행이 종료되는 시간
start = 0
end = 60000000000
num = 0

if N<M:
    print(N)
else:
    while start <= end:
        mid = (start + end) // 2

        hap = 0
        for time in ary:
            hap += (mid // time) + 1
        if hap >= N:
            #print(start, mid, end, "True")
            end = mid - 1
            num = mid
        else:
            #print(start, mid, end, "False")
            start = mid + 1


    #print("end is", end)
    cnt = 0

    for i in range(M):
        cnt += ((num-1) // ary[i]) + 1

    for i in range(M):
        if num % ary[i] == 0: cnt +=1
        if cnt == N:
            print(i+1)
            break
