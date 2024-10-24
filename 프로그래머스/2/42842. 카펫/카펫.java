class Solution {
    public int[] solution(int brown, int yellow) {
        
        int yellowX;
        int yellowY;
        
        int totalSize = brown+yellow;
        int[] answer = new int[2];
        
        for(int b=1;b<=totalSize;b++){
            for(int a=b; a<=totalSize/b ;a++){
                if(a*b != totalSize) continue;
                
                yellowX = b-2;
                yellowY = a-2;
                if(yellowX*yellowY == yellow){
                    answer[0]=a; answer[1]=b;
                    return answer;
                }
            }
        }
        
        
        
        
        
        return answer;
    }
}