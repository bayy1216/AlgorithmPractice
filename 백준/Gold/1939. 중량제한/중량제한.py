import sys
from collections import deque


def bfs(weight):
    queue = deque([])
    queue.append(facA)
    visited = [False] * (N+1)
    visited[facA] = True

    while queue:
        v = queue.popleft()

        for to, w in bridges[v]:
            if not visited[to] and w >= weight:
                visited[to] = True
                queue.append(to)

    if visited[facB]:
        return True
    return False



N, M = map(int, input().split())


bridges = [[] for _ in range(N+1)]




for i in range(M):
    A, B, C = map(int, sys.stdin.readline().rstrip().split())
    bridges[A].append((B, C))
    bridges[B].append((A, C))

facA, facB = map(int, sys.stdin.readline().rstrip().split())

start = 1

end = 1000000000

while start <= end:
    mid = (start + end) // 2

    if bfs(mid):#배송성공
       start = mid + 1
    else:
        end = mid - 1

print(end)