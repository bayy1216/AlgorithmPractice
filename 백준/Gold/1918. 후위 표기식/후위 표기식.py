middle_fix = list(input())

stack = []

dap = []

for x in middle_fix:
    if x == '+' or x == '-':
        while stack and stack[-1] != '(':
            dap.append(stack.pop())

        stack.append(x)
    elif x == '*' or x == '/':
        while stack and (stack[-1] == '*' or stack[-1] == '/'):
            dap.append(stack.pop())
        stack.append(x)
    elif x == '(':
        stack.append(x)
    elif x == ')':
        while stack and stack[-1] != '(':
            dap.append(stack.pop())
        stack.pop()

    else:
        dap.append(x)
while stack:
    dap.append(stack.pop())
print(''.join(dap))
