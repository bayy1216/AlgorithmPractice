import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet();
        for(var g: gems){
            gemSet.add(g);
        }
        
        int start=0;
        int end=0;
        int gemCount = gemSet.size();
        Map<String, Integer> gemMap = new HashMap<>();
        
        int currentMinLen = Integer.MAX_VALUE;
        int[] answer={1,1};
        while(true){
            
            if(gemMap.size() == gemCount){//다른구간 찾기
                String startGem = gems[start];
                gemMap.merge(startGem, -1, (a,b)->a+b);
                if(gemMap.get(startGem)<=0){
                    gemMap.remove(startGem);
                } 
                start++;
            }else if(end== gems.length){
                break;
            }
            else{//오른쪽 늘려주기
                String endGem = gems[end];
                gemMap.merge(endGem, 1, (a,b)->a+b);
                end++;
            }
            if(gemMap.size() == gemCount
               && currentMinLen > end-start){
                answer[0]= start+1;
                answer[1]= end;
                currentMinLen = end-start;
            }
        }
//         int start=0;
//         int end = gems.length-1;
//         while(start<end){
//             String startGem = gems[start];
//             String endGem = gems[end];
//             if(hm.get(endGem)>1){
//                 end--;
//                 hm.merge(endGem, -1, (a,b)->a+b);
//             }else if(hm.get(startGem)>1){
//                 start++;
//                 hm.merge(startGem, -1, (a,b)->a+b);
//             }else{
//                 break;
//             }
            
//         }
        
        
        
        return answer;
    }
}