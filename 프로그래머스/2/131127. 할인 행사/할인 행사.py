def solution(want, number, discount):
    answer = 0
    
    #10일 초기날짜 순회
    for i in range(len(discount)-9):
        success = len(want)
        #want 순회
        for j in range(len(want)):
            num = number[j]
            for k in range(i, i+10):
                if discount[k] == want[j]: num -= 1
            if num == 0: success -=1
            
        if success == 0: answer +=1
    
    
    return answer