class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int M = key.length;
        int N = lock.length;
        for(int x=-M+1;x<N;x++){
            for(int y=-M+1;y<N;y++){
                //check
                if(check(key,lock,x,y)) return true;
            }   
        }
        //key M <= lock N
        for(int i=0;i<3;i++){
            rotate(key);
            for(int x=-M;x<N;x++){
                for(int y=-M;y<N;y++){
                    //check
                    if(check(key,lock,x,y)) return true;
                }   
            }
            
        }
        return answer;
    }
    
    public boolean check(int[][] key, int[][] lock, int x, int y){
        int[][] copyKey = new int[lock.length][lock.length];
        
        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock.length;j++){
                if(i-x<0 || j-y <0 || i-x>=key.length || j-y >= key.length) 
                    continue;
                copyKey[i][j] = key[i-x][j-y];
            }
        }
        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock.length;j++){
                if(lock[i][j] + copyKey[i][j] != 1) return false;
            }
        }
        
        
        
        return true;
    }
    
    
     public void rotate(int[][] matrix) {
        int n = matrix.length;

        // reverse up and down
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;

            }
        }

        // reverse diagonally
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
     }
}