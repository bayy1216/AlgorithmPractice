import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    static int ary[];
    public int solution(int x, int y, int n) {
        if(x==y) return 0;
        
        ary = new int[y+1];
        ary[x] = 0;
        
        int current = x;
        while(current<y){
            int caseAdd = current+n;
            int caseMul2= current*2;
            int caseMul3 = current*3;
            logic(caseAdd, ary[current]+1, y);
            logic(caseMul2, ary[current]+1, y);
            logic(caseMul3, ary[current]+1, y);
            while(true){
                current++;
                if(current > y || ary[current]>0) break;
            }
        }
        int answer = -1;
        if(ary[y]>0) answer = ary[y];
        return answer;
    }
    static void logic(int index, int num, int y){
        if(index > y) return;
        if(ary[index]==0){
            ary[index] = num;
            return;
        }
        ary[index] = Math.min(ary[index],num);
        
    }
}