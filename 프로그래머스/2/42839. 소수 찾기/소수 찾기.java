import java.util.*;

class Solution {
    static int answer = 0;
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static Set<Integer> nums = new HashSet<>();
    
    public int solution(String numbers) {
        int n = numbers.length();
        arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = numbers.charAt(i)- '0';
        }
        
        output = new int[n];
        visited = new boolean[n];
        
        for(int i=1;i<= n; i++){
            permutation(0, n, i);
        }
        
        int answer = 0;
        for(int x: nums){
            // answer+=x;
            if(isPrime(x)) answer+=1;
        }
        return answer;
    }
    
    public boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    
    
    public void permutation(int depth, int n, int r){
        if(depth==r){
            int x =0;
            for(int a=0;a<r;a++){
                x= x*10 + output[a];
            }
            nums.add(x);
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                
                output[depth] = arr[i];
                permutation(depth+1, n, r);
                visited[i] = false;
            }
        }
    }
}