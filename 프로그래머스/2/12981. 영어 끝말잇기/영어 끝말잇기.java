import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        
        Set<String> records = new HashSet<>();
        int idx = 0;
        
        for(String word: words){
            if(records.contains(word)){
                return new int[]{ (idx)%n + 1, idx/n + 1};
            } else if(idx>0 && word.charAt(0) != words[idx-1].charAt(words[idx-1].length()-1)){
                return new int[]{ (idx)%n + 1, idx/n + 1};
            }
            idx++;
            records.add(word);
        }

        return new int[]{0, 0};
    }
}