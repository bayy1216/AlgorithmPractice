import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[speeds.length];
        int ansI = 0;
        
        int cur = 0;
        while(true){
            int day = (int) Math.ceil((double)(100 - progresses[cur])/speeds[cur]);
            int to= cur;
            process(progresses, speeds, day);
            for(int i=cur; i< speeds.length; i++){
                if(progresses[i] < 100){
                    break;
                }
                to++;
            }
            answer[ansI++] = to-cur;
            
            cur = to;
            if(to>=speeds.length) break;
        }
        
        return Arrays.stream(answer).boxed().filter(e->e>0)
            .mapToInt(Integer::intValue).toArray();
    }
    public void process(int[] progresses, int[] speeds, int day) {
        for(int i=0;i<speeds.length;i++){
            progresses[i] += speeds[i]*day;
        }
    }
}