def solution(land):
    answer = 0
    score = (land[0][0], land[0][1],land[0][2],land[0][3])
    lvl = len(land)
    for i in range(1,lvl):
        
        score_next = (
            land[i][0]+ max(score[3],score[1],score[2]),
            land[i][1] + max(score[0],score[3],score[2]),
            land[i][2] + max(score[1],score[0],score[3]),
            land[i][3]+max(score[0],score[1],score[2]),
        )
        score = score_next

    return max(score)