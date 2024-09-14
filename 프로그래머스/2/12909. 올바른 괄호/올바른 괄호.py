def solution(s):
    answer = True
    
    stack = []
    for c in s:
        if c=='(':
            stack.append(c)
            continue
        if not stack:
            answer=False
            break
        stack.pop()
    if stack: return False
    return answer