import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        int[] clear = new int[N+2];
        int[] go = new int[N+2];
        
        for(int i=0;i<stages.length;i++){
            for(int x=1;x<stages[i];x++){
                clear[x]++;
                go[x]++;
            }
            go[stages[i]]++;
        }
        
        ArrayList<Stage> st = new ArrayList<>();
        for(int i=1;i<N+1;i++){
            st.add(new Stage(i,(double)clear[i]/go[i]));
        }
        
        
        
        return st.stream()
            .sorted(Comparator.comparingDouble(a -> a.score))
            .mapToInt(Stage::getLvl).toArray();
    }
    
    public static class Stage{
        int lvl;
        double score;
        Stage(int l, double s){
            this.lvl=l;
            this.score=s;
        }
        public int getLvl(){
            return lvl;
        }
    }
}