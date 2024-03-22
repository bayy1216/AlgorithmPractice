from collections import deque

N, M = map(int, input().split())

ladder = [-1] * 101
snake = [-1] * 101
visit = [False] * 101

for _ in range(N):
    f, t = map(int,input().split())
    ladder[f] = t


for _ in range(M):
    f, t = map(int,input().split())
    snake[f] = t

q = deque([(1,0)])

while q:
    pos,lvl = q.popleft()
    visit[pos] = True

    for i in range(1,7):
        if ladder[i+pos] != -1:
            if visit[ladder[i+pos]]: continue
            q.append((ladder[i+pos], lvl + 1))
        elif snake[i+pos] != -1:
            if visit[snake[i + pos]]: continue
            q.append((snake[i+pos], lvl + 1))
        else:
            if visit[i + pos]: continue
            if pos+i == 100:
                print(lvl+1)
                exit()
            q.append((pos+i, lvl + 1))