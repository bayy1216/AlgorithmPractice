class Solution {
    public String solution(int n) {
        n -=1;
        String answer = "";
        StringBuilder builder = new StringBuilder("");
        while(n>=0){
            int mod = n %3;
            n /=3;
            if(n>=0) n-=1;
            if(mod==0){
                builder.append("1");
            }else if(mod==1){
                builder.append("2");    
            }else if(mod ==2){
                builder.append("4");
            }
            
        }
        answer = builder.toString();
        StringBuffer sb = new StringBuffer(answer);
        answer = sb.reverse().toString();
        
        return answer;
    }
}