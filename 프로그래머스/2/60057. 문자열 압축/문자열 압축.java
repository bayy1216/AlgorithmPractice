class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1;i<=s.length()/2;i++){
            answer = Math.min(answer, getAnswer(s, i));
        }
        return answer;
    }
    
    public int getAnswer(String s, int tokenLen){
        int len = s.length();
        int pos = 0;
    
        while(pos+tokenLen<=s.length()){
            String token = s.substring(pos, pos+tokenLen);//현재 기준값
            int slice = pos+tokenLen;//현재값에서 다음 윈도우 시작점
        
            Integer removeCount=1;
            while(slice+tokenLen<=s.length()){
                String next = s.substring(slice, slice+tokenLen);
                if(token.equals(next)){
                    len-=tokenLen;
                    slice+=tokenLen;//다음 시작점
                    removeCount++;
                }else{
                    break;
                }
            }
            
            if(removeCount>1) {
                len+=removeCount.toString().length();
                pos=slice;
            }else{
                pos+=tokenLen;
            }
        }
        return len;
    }
    
}