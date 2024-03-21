N, K = map(int, input().split())

from collections import deque

q = deque([])
q.append((N, 0))

visit = [False] * 100001

while q:
    pos, lvl = q.popleft()
    visit[pos] = True

    if pos == K:
        print(lvl)
        break
    next_lvl = lvl+1
    if pos-1 >-1 and not visit[pos-1]:
        q.append((pos-1,next_lvl))
    if pos +1 <100001 and not visit[pos+1]:
        q.append((pos+1,next_lvl))
    if pos*2 < 100001 and not visit[pos*2]:
        q.append((pos*2,next_lvl))