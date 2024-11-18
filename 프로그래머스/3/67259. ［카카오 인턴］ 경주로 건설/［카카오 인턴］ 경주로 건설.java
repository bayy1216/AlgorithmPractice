import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        ArrayDeque<Point> queue = new ArrayDeque<>();
        if(board[0][1] == 0){
            queue.addFirst(new Point(0,0,1, 0));    
        }
        if(board[1][0] == 0){
            queue.addFirst(new Point(0,0,2, 0));    
        }
        
        
        while(!queue.isEmpty()){
            Point curr = queue.pollLast();
            for(Point move: curr.move()){
                //이동불가능
                if(move.y>= board.length || move.x >=board.length
                  ||move.x<0 || move.y<0 || (move.x==0&&move.y==0)
                   || board[move.y][move.x] == 1){
                    continue;
                }
                
                if(move.dir!=curr.dir) move.money+=500;
                if(board[move.y][move.x]==0){
                    queue.addFirst(move);
                    board[move.y][move.x] = move.money;   
                }else{
                    if(board[move.y][move.x] +400>= move.money){
                        queue.addFirst(move);
                        board[move.y][move.x] 
                            = Math.min(move.money,board[move.y][move.x]);   
                    }
                }
            }
        }
        // if(board.length==5)
        //     return board[4][3];
        return board[board.length-1][board.length-1];
    }
    
    public static class Point{
        int y;
        int x;
        int dir;//위로 0, 오른쪽 1, 아래 2, 왼쪽 3
        int money;
        
        public Point(int y, int x, int dir, int money){
            this.y=y; this.x=x; this.dir=dir; this.money=money;
        }
        
        public List<Point> move(){
            List<Point> p = new ArrayList<>();
            for(int i=0;i<4;i++){
            
                p.add(this.moveCopy(i));
            }
            return p;
        }
        
        public Point moveCopy(int moveDir){
            int addMoney = 100;
        
            if(moveDir==0){
                return new Point(y-1,x,moveDir, money+addMoney);
            }else if(moveDir==1){
                return new Point(y,x+1,moveDir, money+addMoney);
            }else if(moveDir==2){
                return new Point(y+1,x,moveDir, money+addMoney);
            }else{
                return new Point(y,x-1,moveDir, money+addMoney);
            }
        }
        
    }
}