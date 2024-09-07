def solution(board):
    answer = 0
    if len(board[0]) ==1 and len(board) == 1 and board[0][0]==1: return 1
    
    
    for x in range(1,len(board[0])):
        for y in range(1,len(board)):
            if board[y][x] == 0: continue
                        
            board[y][x] = min(board[y-1][x-1],board[y][x-1],board[y-1][x])+1
            
            answer = max(board[y][x], answer)

    return answer*answer

            