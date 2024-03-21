from collections import deque

N,K = map(int,input().split())

def visit(num, lv):
    global dp
    ret = []
    if num == 0:
        dp[0] = (True,lv)
        return ret
    x = num

    dp[num] = (True, lv)
    x = x*2
    while x < 100001:
        if not dp[x][0]:
            dp[x] = (True, lv)
            ret.append(x)
        x = x*2
    return ret

q = deque([(N, 0)])

dp = [(False, 0)] * 100001



while q:
    pos, lvl = q.popleft()

    li = visit(pos, lvl)
    for i in li:
        q.appendleft((i,lvl))
    if dp[K][0]:
        print(dp[K][1])
        break
    if pos-1 >-1 and not dp[pos-1][0]: q.append((pos-1,lvl+1))
    if pos +1 <100001 and not dp[pos+1][0]: q.append((pos+1,lvl+1))
