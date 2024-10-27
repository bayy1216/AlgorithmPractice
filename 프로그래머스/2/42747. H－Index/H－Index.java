class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        for(int i=1;i<=citations.length;i++){
            if(check(citations,i)){
                answer=i;
            }else{
                break;
            }
        }
        
        return answer;
    }
    
    public boolean check(int[] arr, int target){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=target) count++;
        }
        return count >= target;
    }
}