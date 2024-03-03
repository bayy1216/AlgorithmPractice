bar_input = list(input())

stack = []

ret = 0

for i in range(len(bar_input)):
    if bar_input[i] == '(':
        stack.append(i)
    elif bar_input[i] == ')':
        start = stack.pop()
        mack = len(stack)
        if start +1 == i: # 레이저
            ret += mack
        else: #막대끝
            ret +=1

print(ret)
