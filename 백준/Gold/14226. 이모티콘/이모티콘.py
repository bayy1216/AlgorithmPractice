S = int(input())

from collections import deque

q = deque([])

q.append((1,0,0)) # count, clip, time
emo = [[False] * 1001 for _ in range(1001)]

while q:
    count, clip, time = q.popleft()
    emo[count][clip] = True

    if count == S:
        print(time)
        break
    #클립보드에 저장
    if not emo[count][count]:
        q.append((count, count, time +1))
    #붙여넣기
    if clip >0 and count+clip < 1001 and not emo[count+clip][clip]:
        if count+clip ==S:
            print(time+1)
            break
        q.append((count+ clip, clip, time+1))
    #삭제하기
    if count >= 1 and not emo[count-1][clip]:
        q.append((count-1, clip, time+1))
