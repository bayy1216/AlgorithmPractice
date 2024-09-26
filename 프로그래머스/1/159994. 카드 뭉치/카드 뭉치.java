import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        
        int N1= cards1.length;
        int N2 = cards2.length;
        int c1 = 0;
        int c2 = 0;
        
        List<String> path = new ArrayList<>();
        
        
        while(true){
            String p = "";
            boolean flag=false;
            
            
            for(int i=0; i<goal.length;i++){
                if(c1 < N1 && goal[i].equals(cards1[c1]) && !path.contains(p)){
                    c1++;
                    p += "c1"+c1;
                    continue;
                }
                if(c2 < N2 && goal[i].equals(cards2[c2]) && !path.contains(p)){
                    c2++;
                    p+= "c2"+c2;
                    continue;
                }
                if(c1+c2 == goal.length){
                    flag=true;
                    answer="Yes";
                }
                if(p.equals("")){ //더이상 시도 불가
                    flag=true;
                }else{
                    path.add(p); //시도 성공
                }

                break;
            }
            
            if(flag) {
                break;
            }
            
        }
        
        
        return answer;
    }
}