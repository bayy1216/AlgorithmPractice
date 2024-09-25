import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        
        // for(int i=0;i<N;i++){
        //     int num = prices[i];
        //     for(int j=i+1;j <N; j++){
        //         answer[i]++;
        //         if(num > prices[j]){
        //             break;
        //         }
        //     }
        // }
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i=1;i<N;i++){
            while(!st.isEmpty() && prices[i] < prices[st.peek()]){
                
                int topIndex = st.pop();
                answer[topIndex] = i - topIndex;
            }
            st.push(i);
            
        }
        
        while(!st.isEmpty()){
            int topIndex = st.pop();
            answer[topIndex] = N-1-topIndex;
        }
        
        return answer;
    }
}