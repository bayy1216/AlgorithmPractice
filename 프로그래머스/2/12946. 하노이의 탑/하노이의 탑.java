import java.util.*;

class Solution {
    public int[][] solution(int n) {
        int[][] answer;
        
        List<Move> mo = hano(n, 1, 2, 3);
        
        answer = new int[mo.size()][];
        
        for(int i=0; i< answer.length; i++){
            Move m = mo.get(i);
            answer[i] = new int[] {m.from, m.to};
        }
        
        return answer;
    }
    
    
    public List<Move> hano(int n,int from, int mid, int to){
        //base에서 to으로 이동하기, n의 상황에서
        if(n < 1){
            return new ArrayList<Move>();
        }
        
        //n-1을 from에서 mid로
        List<Move> left = hano(n-1, from, to, mid);
        //n을 from에서 to로
        Move m = new Move(from, to);
        
        //n-1을 mid에서 to로
        List<Move> right = hano(n-1, mid, from, to);
        
        left.add(m);
        left.addAll(right);
        return left;
    }
    
    
    public static class Move{
        int from;
        int to;
        
        Move(int f, int t){
            this.from=f;
            this.to=t;
        }
    }
}