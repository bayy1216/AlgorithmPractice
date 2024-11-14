import java.util.*;

class Solution {
    static int[] output;
    static int[] arr;
    static boolean[] visited;
    static int answer;
    static String[] userId;
    static String[] bannedId;
    static Set<Integer> answerSet;
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        int N = user_id.length;
        int R = banned_id.length;
        answerSet = new HashSet<>();
        arr = new int[N];
        output = new int[R];
        visited = new boolean[N];
        userId=user_id; bannedId=banned_id;
        
        for(int i=0;i<N;i++){
            arr[i]=i;
        }
        
        permu(0, N, R);
        return answerSet.size();
    }
    
    
    //순서있게 N개중에서 R개 뽑기
    public void permu(int depth, int n, int r){
        if(depth==r){
            for(int i=0;i<r;i++){
                if(!isMatch(userId[output[i]], bannedId[i])){
                    return;
                }
            }
            answerSet.add(genBit(output));
            // answer++;
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                permu(depth+1, n, r);
                visited[i] = false;
            }
        }
    }
    
    
    public boolean isMatch(String str, String pattern){
        if(str.length() != pattern.length()){
            return false;
        }
        for(int i=0;i<str.length();i++){
            if(pattern.charAt(i) == '*') continue;
            if(pattern.charAt(i) != str.charAt(i)) return false;
        }
        return true;
    }
    
    public int genBit(int[] nums){
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res+=Math.pow(2, nums[i]);
        }
        return res;
    }
}