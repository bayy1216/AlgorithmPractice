class Solution {
    public int[] solution(int[][] arr) {
        Score p = getScore(arr, 0,0, arr.length);
        return p.toAnswer();
    }
    
    public Score getScore(int[][] arr, int startY, int startX, int width){
        
        boolean canDel = true;
        int flag=arr[startY][startX];
        for(int y=startY;y<startY+width;y++){
            for(int x=startX; x<startX+width;x++){
                if(y==startY && x==startX) continue;
                if(flag != arr[y][x]){
                    canDel=false;
                    break;
                }
            }
            if(!canDel) break;
        }
        if(canDel){//모두 같은값
            return new Score(flag, flag==0? 1:0);
        }
        Score s1 = getScore(arr,startY,startX,width/2);
        Score s2 = getScore(arr,startY+width/2,startX,width/2);
        Score s3 = getScore(arr,startY,startX+width/2,width/2);
        Score s4 = getScore(arr,startY+width/2,startX+width/2,width/2);
        return new Score(s1.one+s2.one+s3.one+s4.one,
                        s1.zero+s2.zero+s3.zero+s4.zero);
        // return s1;
        // return s4;
    }
    
    
    
    public static class Score{
        int one;
        int zero;
        public Score(int o, int z){
            this.one=o;
            this.zero=z;
        }
        
    
        
        public Score plus(Score p){
            this.one += p.one;
            this.zero +=p.zero;
            return this;
        }
        public int[] toAnswer(){
            return new int[]{zero, one};
        }
    }
}