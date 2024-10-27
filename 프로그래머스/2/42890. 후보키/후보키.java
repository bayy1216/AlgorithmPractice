import java.util.*;

class Solution {
    static int[] arr;
    static int[] output;
    
    static List<Integer> check = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int N = relation[0].length;
        output = new int[N];
        arr = new int[N];
        
        for(int i=0;i<N;i++){
            arr[i]=i;
        }
        for(int i=1;i<N;i++){
            combin(relation,0,0,N,i);
        }
        
        int[] arr = new int[check.size()];
        for(int i=0;i<check.size();i++){
            arr[i]=check.get(i);
        }
        
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
            
                int t1 = arr[i];
                int t2 = arr[j];
                if(t1==0 || t2==0 || i==j) continue;
                int x = t1&t2;
                
                if(x == t1){
                    arr[j]=0;
                }
            }
        }
        int answer=0;
        
        for(int a: arr){
            if(a!=0) answer++;
        }
    
        return answer>0? answer : 1;
    }
    
    
    public void combin(String[][] relation,int start, int depth, int n, int r){
        if(depth==r){
            boolean canPush = true;
            Set<String> set = new HashSet<>();
            for(int a=0;a<relation.length;a++){
                String target = "";
                for(int x=0;x<r;x++){
                    target += relation[a][output[x]];
                }
                if(!set.contains(target)){
                    set.add(target);
                }else{
                    canPush = false;
                    break;
                }
            }
            if(canPush) {
                int num = 0;
                for(int x=0;x<r;x++){
                    num += (int)Math.pow(2, output[x]);
                }
                check.add(num);
            }
            
            return;
        }
        
        for(int i=start; i<n; i++){
            output[depth] = arr[i];
            combin(relation, i+1, depth+1, n, r);
        }
        
    }
}