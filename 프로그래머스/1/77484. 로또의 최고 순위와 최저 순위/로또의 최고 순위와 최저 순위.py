def solution(lottos, win_nums):
    answer = []
    #lottos = lottos.sort()
    #win_nums= win_nums.sort()
    good = 7
    bad = 7
    for l in lottos:
        if l==0:
            good-=1
            continue
        for w in win_nums:
            if l == w:
                good-=1
                bad-=1
    if good ==7:
        good-=1
    if bad==7:
        bad-=1
    answer.append(good)
    answer.append(bad)
    return answer