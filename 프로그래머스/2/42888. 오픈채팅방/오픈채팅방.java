import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> userMap = new HashMap<>();
        
        for(String r: record){
            String[] sp = r.split(" ");
            if(sp[0].equals("Enter")){
                userMap.put(sp[1], sp[2]);
                answer.add(sp[1]+" 님이 들어왔습니다.");
            }else if(sp[0].equals("Change")){
                userMap.put(sp[1], sp[2]);
            }else{
                answer.add(sp[1]+" 님이 나갔습니다.");
            }
        }
        
        
        String[] res = new String[answer.size()];
        for(int i=0; i< answer.size(); i++){
            String query = answer.get(i);
            String uid = query.split(" ")[0];
            res[i] = query.replace(uid + " ", userMap.get(uid));
        }
        return res;
    }
}