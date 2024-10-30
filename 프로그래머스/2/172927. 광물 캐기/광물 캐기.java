import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        List<Bag> bags = new ArrayList<>();
        int pickCount = picks[0]+picks[1]+picks[2];
        
    
        for(int i=0; i<minerals.length/5 + 1;i++){
            if(pickCount < i+1) break;//곡갱이 부족
            
            int di = 0; int ir=0; int st=0;
            for(int j=0;j<5;j++){
                if(i*5+j >= minerals.length) break;
                
                String m = minerals[i*5+j];
                if(m.equals("diamond")) di+=1;
                if(m.equals("iron")) ir+=1;
                if(m.equals("stone")) st+=1;
            }
            if(di==0 && ir==0 && st==0) break;
            bags.add(new Bag(di,ir,st));
        }
        
        bags.sort((a,b)-> b.calc(2)-a.calc(2));
        
        int answer = 0;
        for(int i=0;i<bags.size();i++){
            Bag bag = bags.get(i);
            for(int j=0;j<3;j++){
                if(picks[j]>0){
                    answer += bag.calc(j);
                    picks[j]--;
                    break;
                }
            }
        }
        
        
        
        
        return answer;
    }
    
    public static class Bag{
        int diamond;
        int iron;
        int stone;
        public Bag(int di, int ir, int st){
            this.diamond = di;
            this.iron = ir;
            this.stone = st;
        }
        
        public int calc(int idx){
            if(idx==0){
                return diamond+iron+stone;
            }else if(idx==1){
                return diamond*5+iron+stone;
            }else{
                return diamond*25+iron*5+stone;
            }
        }
    }
}