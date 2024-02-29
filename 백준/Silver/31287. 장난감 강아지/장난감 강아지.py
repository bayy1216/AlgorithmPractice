N, K = map(int, input().split())
str = input()

curY, curX = 0, 0

if K > (N // 2):
    K = N // 2

while K > 0:
    for c in str:
        if c == 'U':
            curY += 1
        elif c == 'D':
            curY -= 1
        elif c == 'L':
            curX -= 1
        else:
            curX += 1

        if curY == 0 and curX == 0:
            print("YES")
            exit()

    K -= 1

print("NO")
