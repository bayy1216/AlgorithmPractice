import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        //n회 배차, t분 간격으로 배차
        //한셔틀의 용량은 m명
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<timetable.length;i++){
            String[] sp = timetable[i].split(":");
            int time = Integer.parseInt(sp[0])*60 + Integer.parseInt(sp[1]);
            pq.add(time);
        }
        
        int currBusTime = 540;
        int currBusPeo=0;
        
        int lastPeoTime=1;
        
        for(int i=0;i<n;i++){
            currBusPeo = 0;
            while(!pq.isEmpty() && pq.peek() <= currBusTime){
                currBusPeo++;
                lastPeoTime = pq.poll();
                if(currBusPeo == m){
                    break;
                }
            }    
            currBusTime +=t;
        }
        int answer=currBusTime-t;//마지막 버스
        
        if(currBusPeo == m){//마지막 버스에서, 다탔다면
            answer = lastPeoTime-1;
        }
        
        return String.format("%02d:%02d", answer/60, answer%60);
        
        
        
    }
    

}