import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        
        HashMap<String, Set<String>> reportDataMap = new HashMap<>();
        
        HashMap<String, Integer> reportCountMap = new HashMap<>();
        
        for(String id: id_list){
            reportDataMap.put(id, new HashSet<>());
        }
        
        for(var r: report){
            String[] split = r.split(" ");
            String from = split[0];
            String to = split[1];
            reportDataMap.get(from).add(to);
        }
        
        //reportCountMap 세팅
        for(String dataKey : reportDataMap.keySet()){
            Set<String> reportSet= reportDataMap.get(dataKey);
            for(String name: reportSet){
                Integer count = reportCountMap.getOrDefault(name, 0);
                reportCountMap.put(name, count+1);
            }
        }
        
        List<String> banedUser = new ArrayList<>();
        
        for(String keyName: reportCountMap.keySet()){
            if(reportCountMap.get(keyName)>=k){
                banedUser.add(keyName);
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i=0;i<id_list.length; i++){
            Set<String> toBan = reportDataMap.get(id_list[i]);
            for(String b: toBan){
                if(banedUser.contains(b)){
                    answer[i]++;
                }
            }
        }
        
        
        return answer;
    }
}