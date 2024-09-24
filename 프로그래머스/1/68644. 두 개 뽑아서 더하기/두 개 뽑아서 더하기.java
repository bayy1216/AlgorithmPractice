import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        
        int siz = len*(len-1) / 2;
        int[] ary = new int[siz];
        int a=0;
        for(int x=0;x<len;x++){
            for(int y=x+1;y<len;y++){
                ary[a++] = numbers[x]+numbers[y];
            }
        }
        
        Integer[] ans = Arrays.stream(ary).boxed().distinct()
            .toArray(Integer[]::new);
        Arrays.sort(ans);
        
        
        
        return Arrays.stream(ans).mapToInt(Integer::intValue).toArray();
    }
}