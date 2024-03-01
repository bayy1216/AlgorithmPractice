import sys
from collections import deque
N = int(input())

q = deque()
for _ in range(N):
    command = sys.stdin.readline().rstrip().split()
    if command[0] == "push":
        num = command[1]
        q.append(num)
    elif command[0] == "pop":
        if len(q) == 0:
            print("-1")
            continue
        p = q.popleft()
        print(p)
    elif command[0] == "size":
        print(len(q))
    elif command[0] == "empty":
        if len(q) == 0:
            print("1")
            continue
        print("0")
    elif command[0] == "front":
        if len(q) == 0:
            print("-1")
            continue
        n = q.popleft()
        print(n)
        q.appendleft(n)
    else: #back
        if len(q) == 0:
            print("-1")
            continue
        n = q.pop()
        print(n)
        q.append(n)
