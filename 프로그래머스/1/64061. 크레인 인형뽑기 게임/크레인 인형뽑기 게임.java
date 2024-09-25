import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int move: moves){
            int num = getNum(board,move);
            if(num==0) continue;
            if(!st.isEmpty() && st.peek() == num){
                answer +=2;
                st.pop();
            }else{
                st.push(num);
            }
        }
        return answer;
    }
    
    
    public int getNum(int[][] board, int move){
        
        for(int x=0;x<board.length; x++){
            if (board[x][move-1] !=0){
                int ret = board[x][move-1];
                board[x][move-1] = 0;
                return ret;
            }
        }
        
        return 0;
    }
}