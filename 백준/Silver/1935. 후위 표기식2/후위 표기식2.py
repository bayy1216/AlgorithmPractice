import sys

N = int(input())
cal = list(input())

dic = dict()

for i in range(N):
    dic[chr(ord('A')+i)] = int(sys.stdin.readline().rstrip())


stack = []
for x in cal:
    if x== '+':
        stack.append(stack.pop() + stack.pop())
    elif x=='-':
        n2 = stack.pop()
        stack.append(stack.pop() - n2)
    elif x=='*':
        stack.append(stack.pop() * stack.pop())
    elif x=='/':
        n2 = stack.pop()
        stack.append(stack.pop() / n2)
    else:
        stack.append(dic[x])
print(f'{stack.pop():.2f}')