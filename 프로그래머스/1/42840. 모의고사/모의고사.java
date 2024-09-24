import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int one = 0;
        int two = 0;
        int thr = 0;
        
        int[] twoDap = {1,3,4,5};
        int[] thrDap = {3,1,2,4,5};
        for(int i=0;i<answers.length; i++){
            if(answers[i] == i % 5 + 1){
                one++;
            }
            if(i %2==0 && answers[i]==2){
                two++;
            }
            if(i%2 ==1 && answers[i] == twoDap[(i/2)%4]){
                two++;
            }
            if(answers[i] == thrDap[(i/2)%5]) thr++;
        }
        
        int score = Math.max(one,two);
        score = Math.max(score,thr);
        
        List<Integer> an = new ArrayList<>();
        if(score == one) an.add(1);
        if(score == two) an.add(2);
        if(score == thr) an.add(3);
        return an.stream().mapToInt(Integer::intValue).sorted().toArray();
        
        
    
    }
}