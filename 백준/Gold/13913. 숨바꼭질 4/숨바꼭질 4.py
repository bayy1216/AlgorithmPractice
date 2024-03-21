N, K = map(int, input().split())

from collections import deque

q = deque([])
q.append((N, 0, ""))

visit = [False] * 100001

lvl = None

def print_his(num, his):
    pr = []
    pr.append(num)
    for i in range(len(his)):
        if his[i] == '1':
            num = num -1
            pr.append(num)
        elif his[i] == '2':
            num = num +1
            pr.append(num)
        else:
            num = num *2
            pr.append(num)
    print(*pr)

while q:
    pos, lvl,his_str = q.popleft()
    visit[pos] = True

    if pos == K:
        print(lvl)
        #print(his_str)
        print_his(N, his_str)
        break
    next_lvl = lvl+1
    if pos-1 >-1 and not visit[pos-1]:
        q.append((pos-1,next_lvl,his_str+"1"))
    if pos +1 <100001 and not visit[pos+1]:
        q.append((pos+1,next_lvl,his_str+"2"))
    if pos*2 < 100001 and not visit[pos*2]:
        q.append((pos*2,next_lvl,his_str+"3"))

