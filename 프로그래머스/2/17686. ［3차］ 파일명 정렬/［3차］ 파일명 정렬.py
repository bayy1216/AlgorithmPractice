def to_int(num):
    n = ""
    for x in num:
        if x=="0" and not n: continue
        n += x
    return int(n)

def solution(files):
    answer = []
    
    ary = []
    
    for file in files:
        head, number, tail = "", "", ""
        
        for ch in file:
            if not number and not ch.isdigit():
                head += ch.lower()
                
            elif ch.isdigit() and not tail:
                number += ch
            else:
                #if not tail and ch == " ":continue
                tail += ch
        n = int(number)
        
        ary.append((head,n,tail, file))
    # ary.sort(key = lambda x:(x[0],x[1],x[2]))
    
    
    le = len(files)
    for i in range(le-1):
        for j in range(0,le-1):
            if ary[j][0] > ary[j+1][0]:
                ary[j], ary[j+1] = ary[j+1], ary[j]
    
    
    for i in range(le-1):
        for j in range(0,le-1):
            if ary[j][0] == ary[j+1][0] and ary[j][1] > ary[j+1][1]:
                ary[j], ary[j+1] = ary[j+1], ary[j]
    
    
    for a in ary:
        answer.append(a[3])
    
    
    return answer