import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        
        
        // 직원, 레퍼럴줘야하는직원
        HashMap<String,String> hm = new HashMap<>();
        
        
        HashMap<String, Integer> peopleMoney = new HashMap<>();
        
        for(int i=0;i<enroll.length; i++){
            hm.put(enroll[i], referral[i]);
        }
        
        int[] answer = new int[enroll.length];
        for(int i=0; i<seller.length; i++){
            int money = amount[i];
        
            String ref = seller[i];
            
            int get = money*100;
            while(!ref.equals("-")){
                int give = (int)Math.ceil((double)get*0.9);
                
                if(get < 10){//2원이라면 다주고 끝내기
                    int mon = peopleMoney.getOrDefault(ref, 0);
                    peopleMoney.put(ref, mon+get);
                    // addMoney(ref,answer,get, enroll);
                    break;
                }
                // addMoney(ref,answer,give, enroll);
                int mon = peopleMoney.getOrDefault(ref, 0);
                peopleMoney.put(ref, mon+give);
                get = get-give;
            
                ref= hm.get(ref);
                
            }
            
        }
        for(int i=0;i<enroll.length;i++){
            answer[i] = peopleMoney.getOrDefault(enroll[i],0);
        }
        
        
        
        return answer;
    }
    
    public void addMoney(String people, int[] arr,int money, String[] enroll){
        for(int i=0;i<enroll.length; i++){
            if(people.equals(enroll[i])){
                arr[i] +=money;
                return;
            }
        }
    }
}