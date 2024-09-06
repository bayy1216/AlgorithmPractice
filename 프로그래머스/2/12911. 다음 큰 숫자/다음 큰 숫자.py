def solution(n):
    
    n_of_one = calc_one(n)
    
    answer = n+1
    while True:
        if calc_one(answer) == n_of_one: break
        answer +=1
    
    return answer


def calc_one(x1):
    one = 0
    while x1>0:
        one += x1 % 2
        x1 = x1//2
    return one