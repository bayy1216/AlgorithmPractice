import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a,b)-> b-a);
        Map<Integer,Integer> hm = new HashMap<>();
        
        int size = 0;
        for(String op: operations){
            String[] input = op.split(" ");
            Integer num = Integer.parseInt(input[1]);
            if(input[0].equals("I")){//add
                pqMin.add(num);
                pqMax.add(num);
                hm.put(num, hm.getOrDefault(num,0)+1);
                size++;
                continue;
            }
            if(size==0){
                continue;
            }
            int target;
            if(num==1){//remove max
                target = pqMax.poll();
            }else{//remove min
                target = pqMin.poll();
            }
            hm.put(target, hm.getOrDefault(target,0)-1);
            size--;
            if(size==0){
                pqMin.clear();
                pqMax.clear();
            }
            
        }
        if(size==1){
            int a = pqMax.peek();
            int i = pqMin.peek();
            if(hm.get(a) != 0) return new int[] {a,a};
            else return new int[] {i,i};
            
        }
        if(size > 1){
            
            int max = pqMax.peek();
            int min = pqMin.peek();
            return new int[] {max, min};
        } 
        
        return new int[] {0,0};
    }
}