import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Boolean> st = new Stack<>();
        
        for(int i=0;i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(true);
            }else{
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        if(!st.isEmpty()) return false;
        
        

        return answer;
    }
}