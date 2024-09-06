def calc(start, target):
    hap = 0
    for i in range(start, target):
        hap += i
        if hap == target: return True
        elif hap > target: return False
    return False

def solution(n):
    answer = 1
    
    for i in range(1, n//2+1):
        if calc(i, n): answer+=1
        
    return answer

