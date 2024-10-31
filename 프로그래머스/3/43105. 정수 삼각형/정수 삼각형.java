import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        for(int i=triangle.length-2; i>=0; i--){
            for(int j=0;j<=i;j++){
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
                
            }
        }
        
        
        // int answer = getAnswer(0,0, triangle);
        return triangle[0][0];
    }
    
    public int getAnswer(int lvl, int pos, int[][] tri){
        if(lvl==tri.length-1){
            return tri[lvl][pos];
        }
        
        int ans0 = getAnswer(lvl+1, pos,tri);
        int ans1 = getAnswer(lvl+1, pos+1,tri);
        
        return tri[lvl][pos] + Math.max(ans0, ans1);
    }
}