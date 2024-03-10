def solution(m, n, board):
    answer = 0
    for x in range(m):
        board[x] = list(board[x])
    
    while True:
        x = remove_block(m,n,board)
        answer += x
        if x == 0:
            break
        
    return answer


def check(board,x,y):
    target = board[x][y]
    if target == 0:
        return False
    if target != board[x][y+1]:
        return False
    if target != board[x+1][y]:
        return False
    if target != board[x+1][y+1]:
        return False
    return True

def remove_block(m,n,board):
    del_block=set([])
    for x in range(m-1):
        for y in range(n-1):
            if check(board,x,y) == True:
                del_block.add((x,y))
                del_block.add((x,y+1))
                del_block.add((x+1,y))
                del_block.add((x+1,y+1))
            
    for x,y in del_block:
        board[x][y] = 0
    
    for x in range(m-2,-1,-1):
        for y in range(n):
            if board[x+1][y] == 0 and board[x][y] != 0:
                xx = x
                while xx + 1< m:
                    board[xx+1][y] = board[xx][y]
                    board[xx][y] = 0
                    xx+=1
                    if xx+1>=m:
                        break
                    if board[xx+1][y]!=0:
                        break
                
                
    return len(del_block)
#CCBDE
#AAADE
#AAABF
#CCBBF
