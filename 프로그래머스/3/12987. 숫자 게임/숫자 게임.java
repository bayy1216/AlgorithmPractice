import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int aIdx=0;
        int bIdx=0;
        while(bIdx<B.length){
            if(A[aIdx]> B[bIdx]){//A가 이김
                bIdx++;
            }else if(A[aIdx]< B[bIdx]){//B가 이김
                answer++;
                aIdx++; bIdx++;
            }else{//무승부
                bIdx++;//b다음차수로 보내서 이기게하기
            }
        }
        
        
        return answer;
    }
}