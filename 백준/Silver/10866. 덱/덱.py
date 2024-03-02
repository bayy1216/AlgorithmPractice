import sys
from collections import deque

N = int(input())

ary = deque()

for _ in range(N):
    command = sys.stdin.readline().rstrip().split()

    size = len(ary)
    if command[0] == "push_front":
        num = int(command[1])
        ary.appendleft(num)
    elif command[0] == "push_back":
        num = int(command[1])
        ary.append(num)
    elif command[0] == "pop_front":
        if size > 0:
            num = ary.popleft()
            print(num)
        else:
            print("-1")
    elif command[0] == "pop_back":
        if size > 0:
            num = ary.pop()
            print(num)
        else:
            print("-1")
    elif command[0] == "size":
        print(size)
    elif command[0] == "empty":
        if size > 0:
            print("0")
        else:
            print("1")
    elif command[0] == "front":
        if size > 0:
            num = ary.popleft()
            print(num)
            ary.appendleft(num)
        else:
            print("-1")
    elif command[0] == "back":
        if size > 0:
            num = ary.pop()
            print(num)
            ary.append(num)
        else:
            print("-1")
