class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        
        for(int i=0;i<N;i++){
            int num = prices[i];
            for(int j=i+1;j <N; j++){
                answer[i]++;
                if(num > prices[j]){
                    break;
                }
            }
        }
        
        
        return answer;
    }
}