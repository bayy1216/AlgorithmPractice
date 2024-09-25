import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        Stack<Character> st = new Stack<>();
        for(int i=0; i< s.length();i++){
            char ch = s.charAt(i);
            
            if(!st.isEmpty() && st.peek()==ch){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        if(!st.isEmpty()) answer = 0;
        
        return answer;
    }
}