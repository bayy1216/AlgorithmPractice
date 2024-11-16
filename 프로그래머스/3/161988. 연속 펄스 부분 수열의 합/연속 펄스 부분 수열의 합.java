import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long case1[] = new long[sequence.length];//1번쨰에 -1
        for(int i=0; i<sequence.length; i++){
            if(i%2==1) case1[i] = -1 *(long) sequence[i];
            else case1[i] = (long) sequence[i];
        }
        
        long case2[] = new long[sequence.length];//0번째에 -1
        for(int i=0; i<sequence.length; i++){
            if(i%2==0) case2[i] = -1 * (long) sequence[i];
            else case2[i] = (long) sequence[i];
        }
        
        long answer = Math.max(genMax(case1), genMax(case2));
        
        return answer;
    }
    
    public long genMax(long[] nums){
        long ret = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] = Math.max(nums[i-1] + nums[i], nums[i]);
            ret = Math.max(nums[i], ret);
        }
        return ret;
        
    }
}