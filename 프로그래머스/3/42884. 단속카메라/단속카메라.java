import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Car[] cars = new Car[routes.length];
        for(int i=0;i<routes.length;i++){
            cars[i] = new Car(routes[i][0], routes[i][1]);
        }
        
        Arrays.sort(cars, (a,b)-> a.end- b.end);
        
        int camera = Integer.MIN_VALUE;
        
        for(Car car: cars){
            if(car.start > camera){
                answer++;
                camera = car.end;
            }
        }
        
        
        
        return answer;
    }
    
    public static class Car{
        int start;
        int end;
        public Car(int s, int e){
            this.start=s; this.end=e;
        }
    }
}