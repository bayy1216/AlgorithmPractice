import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a,b)-> b-a);
        int size = 0;
        for(String op: operations){
            String[] input = op.split(" ");
            Integer num = Integer.parseInt(input[1]);
            if(input[0].equals("I")){//add
                pqMin.add(num);
                pqMax.add(num);
                size++;
                continue;
            }
            if(size<1){
                continue;
            }
            size--;
            if(num==1){//remove max
                var n = pqMax.poll();
                pqMin.remove(n);
            }else{//remove min
                var n = pqMin.poll();
                pqMax.remove(n);
            }
            if(size==0){
                pqMin.clear();
                pqMax.clear();
            }
            
        }
        if(size > 0){
            
            int max = pqMax.peek();
            int min = pqMin.peek();
            return new int[] {max, min};
        }
        
        
        return new int[] {0,0};
    }
}